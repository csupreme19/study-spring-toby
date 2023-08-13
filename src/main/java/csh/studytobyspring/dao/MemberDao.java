package csh.studytobyspring.dao;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class MemberDao {

    private JdbcContext jdbcContext;

    public void setJdbcContext(DataSource dataSource) {
        this.jdbcContext = new JdbcContext();
        this.jdbcContext.setDataSource(dataSource);
    }

    public void deleteAll() throws SQLException {
        this.jdbcContext.workWithStatementStrategy(
                new StatementStrategy() {
                    @Override
                    public PreparedStatement prepareStatement(Connection conn) throws SQLException {
                        return conn.prepareStatement("delete from members");
                    }
                }
        );
    }

}
