package csh.studytobyspring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class MemberDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private JdbcContext jdbcContext;

    public void deleteAll() {
        this.jdbcContext.executeSql("delete from members");
    }

    public void deleteAllJdbcTemplate() {
        this.jdbcTemplate.update("delete from members");
    }

    public void setJdbcContext(DataSource dataSource) {
        this.jdbcContext = new JdbcContext();
        this.jdbcContext.setDataSource(dataSource);
    }

}
