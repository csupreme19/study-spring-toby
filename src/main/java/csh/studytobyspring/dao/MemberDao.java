package csh.studytobyspring.dao;

import csh.studytobyspring.exception.CustomRuntimeException;

import javax.sql.DataSource;
import java.net.ConnectException;
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
        } catch (SQLException e1) {
            throw new CustomRuntimeException(e1);
        } catch (ConnectException e2) {
            throw new CustomRuntimeException(e2);
        } catch (IllegalStateException e3) {
            throw new CustomRuntimeException(e3);

        }
    }

    private void recover() {
    }

}
