package csh.studytobyspring.dao;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MemberDao {

    public void executeSql(final String query) throws SQLException {
        this.jdbcContext.executeSql("delete from members");
    }

    private JdbcContext jdbcContext;

    public void setJdbcContext(DataSource dataSource) {
        this.jdbcContext = new JdbcContext();
        this.jdbcContext.setDataSource(dataSource);
    }

}
