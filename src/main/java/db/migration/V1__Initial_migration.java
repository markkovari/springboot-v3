package db.migration;

import db.BaseMigration;
import org.jooq.DSLContext;
import org.jooq.impl.SQLDataType;

public class V1__Initial_migration extends BaseMigration {
    @Override
    public void migrate(DSLContext dslContext) {
        dslContext.createTableIfNotExists("person")
                .column("id", SQLDataType.BIGINT.identity(true))
                .column("name", SQLDataType.VARCHAR(255))
                .execute();
    }
}