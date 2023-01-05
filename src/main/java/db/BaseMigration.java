package db;

import java.sql.Connection;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public abstract class BaseMigration extends BaseJavaMigration {

    protected SQLDialect sqlDialect;

    @Override
    public void migrate(Context context) {
        Connection connection = context.getConnection();
        sqlDialect = SQLDialect.MYSQL;
        DSLContext dslContext = DSL.using(connection, sqlDialect);
        migrate(dslContext);
    }

    /**
     * Using the DSLContext to migrate which already has the connection from the Context, and operating with MYSQL dialect.
     * @param dslContext
     */
    public abstract void migrate(DSLContext dslContext);
}