package csh.studytobyspring.dao;

import javax.sql.DataSource;

public class MemberDao {

    private JdbcTemplate jdbcContext;

    public void setJdbcContext(DataSource dataSource) {
        this.jdbcContext = new JdbcTemplate();
        this.jdbcContext.setDataSource(dataSource);
    }

    public void deleteAll() {
        this.jdbcContext.query("delete from members");
    }

}
