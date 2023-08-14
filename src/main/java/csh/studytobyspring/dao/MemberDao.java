package csh.studytobyspring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.net.ConnectException;
import java.sql.SQLException;

public class MemberDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private JdbcContext jdbcContext;

    public void deleteAll() throws SQLException, ConnectException {
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
