package sk.upjs.ics.hibernate.types;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A {@link UserType} that persists objects as JSONB.
 * <p>
 * Unlike the default JPA object mapping, {@code JsonStringArrayUserType} can also be used
 * for properties that do not implement {@link Serializable}.
 * <p>
 * Users intending to use this type for mutable non-<code>Collection</code>
 * objects should override {@link #deepCopyValue(Object)} to correctly return a
 * <u>copy</u> of the object.
 */
public class JsonStringArrayUserType extends CollectionUserType {

    private final ObjectMapper MAPPER;
    private static final String JSONB_TYPE = "jsonb";

    public JsonStringArrayUserType() {
        MAPPER = new ObjectMapper();
        initializeMapper();
    }

    @Override
    public Class<Object> returnedClass() {
        return Object.class;
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names,
    SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        try {
            final String json = resultSet.getString(names[0]);
            Object obj = json == null
                    ? Collections.emptyList()
                    : MAPPER.readValue(json, List.class);

            return obj;
        } catch (IOException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,
    SharedSessionContractImplementor session) throws HibernateException, SQLException {
        try {
            final String json = value == null
                    ? null
                    : MAPPER.writeValueAsString(value);
            // otherwise PostgreSQL won't recognize the type
            PGobject pgo = new PGobject();
            pgo.setType(JSONB_TYPE);
            pgo.setValue(json);
            st.setObject(index, pgo);
        } catch (JsonProcessingException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    protected Object deepCopyValue(Object value) {
        return value;
    }

    private void initializeMapper() {
        SimpleModule module = new SimpleModule();

        module.addDeserializer(List.class, new JsonDeserializer<List<String>>() {
            // Json array deserializer
            @Override
            public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                if (jsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
                    List<String> permissions = new ArrayList<>();

                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        permissions.add(jsonParser.getValueAsString());
                    }

                    return permissions;
                }

                throw deserializationContext.mappingException("Expected Permissions list");
            }
        });

        MAPPER.registerModule(module);
    }

}