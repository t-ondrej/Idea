package sk.upjs.ics.hibernate.dialect;

import sk.upjs.ics.hibernate.functions.PostgreSQLFTSFunction;
import org.hibernate.dialect.PostgreSQL9Dialect;

import java.sql.Types;

public class CustomPostgreSQLDialect extends PostgreSQL9Dialect {

    public CustomPostgreSQLDialect() {
        super();
        registerColumnType(Types.JAVA_OBJECT, "jsonb");
        registerFunction("fts", new PostgreSQLFTSFunction());
    }

}