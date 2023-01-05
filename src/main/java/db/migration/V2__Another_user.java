package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


public class V2__Another_user extends BaseJavaMigration {
    public void migrate(Context context) {
        new JdbcTemplate(
                new SingleConnectionDataSource(context.getConnection(), true)
        ).execute("ALTER TABLE person RENAME COLUMN name TO username;");
    }
}