package db.migration;

import db.BaseMigration;
import org.jooq.DSLContext;


public class V2__Another_user extends BaseMigration {
    @Override
    public void migrate(DSLContext dslContext) {
        dslContext.alterTable("person").renameColumn("name").to("username").execute();
    }
}