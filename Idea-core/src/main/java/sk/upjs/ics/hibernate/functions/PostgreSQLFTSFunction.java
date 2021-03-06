package sk.upjs.ics.hibernate.functions;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;

import java.util.List;

public class PostgreSQLFTSFunction implements SQLFunction {

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

    @Override
    public Type getReturnType(final Type firstArgumentType, final Mapping mapping) throws QueryException {
        return new BooleanType();
    }

    @Override
    public String render(Type firstArgumentType, List args, SessionFactoryImplementor factory) throws QueryException {
        if (args == null || args.size() < 2) {
            throw new IllegalArgumentException("The function must be passed at least 2 arguments");
        }

        final String placeHolder = "?";
        final String fields = prepareFieldNames(args);

        String fragment = "to_tsvector(" + fields + ") " +
                "@@ plainto_tsquery(" + placeHolder + ")";

        return fragment;
    }

    private String prepareFieldNames(List args) {
        // Remove the placeholder arg from the end
        args.remove(args.size() - 1);

        // Add type conversion to every field
        for (int i = 0; i < args.size(); i++) {
            args.set(i, args.get(i) + "::text");
        }

        return String.join(" || ", args);
    }
}