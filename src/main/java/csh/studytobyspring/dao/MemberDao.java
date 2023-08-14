package csh.studytobyspring.dao;

import org.springframework.dao.DuplicateKeyException;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MemberDao {

    private JdbcContext jdbcContext;

    public void setJdbcContext(DataSource dataSource) {
        this.jdbcContext = new JdbcContext();
        this.jdbcContext.setDataSource(dataSource);
    }

    public void deleteAll() {
        this.jdbcContext.executeSql("delete from members");
    }

    public void add() throws SQLException {
        try {
            jdbcContext.executeSqlCheckedException("");
        } catch (SQLException e) {
            if (e.getErrorCode() == 42000)
                throw new DuplicateKeyException(e.getMessage(), e);
            else throw e;
        }
    }

    private void recover() {
    }

}
