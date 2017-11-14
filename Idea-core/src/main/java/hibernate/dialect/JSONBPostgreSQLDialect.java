package hibernate.dialect;

import org.hibernate.dialect.PostgreSQL82Dialect;

import java.sql.Types;

public class JSONBPostgreSQLDialect extends PostgreSQL82Dialect {

    public JSONBPostgreSQLDialect() {
        super();
        registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }

}