package csh.studytobyspring.dao;

import csh.studytobyspring.exception.RuntimeConnectException;
import csh.studytobyspring.exception.RuntimeSQLException;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.net.ConnectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class JdbcContext {

    public void executeSqlCheckedException(final String query) throws SQLException {
        try {
            workWithStatementStrategy(
                    new StatementStrategy() {
                        public PreparedStatement prepareStatement(Connection c) throws SQLException {
                            return c.prepareStatement(query);
                        }
                    }
            );
        } catch (SQLException e) {
            throw e;
        } catch (ConnectException e) {
            // do nothing
        }
    }


    /**
     * @throws RuntimeSQLException     쿼리 실행 예외
     * @throws RuntimeConnectException 커넥션 연결 실패
     */
    public void executeSql(final String query) throws RuntimeSQLException, RuntimeConnectException {
        try {
            workWithStatementStrategy(
                    new StatementStrategy() {
                        public PreparedStatement prepareStatement(Connection c) throws SQLException {
                            return c.prepareStatement(query);
                        }
                    }
            );
        } catch (SQLException e) {
            throw new RuntimeSQLException(e);
        } catch (ConnectException e) {
            throw new RuntimeConnectException(e);
        }
    }

    private DataSource dataSource;

    private ConnectionMaker connectionMaker;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException, ConnectException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectionMaker.getConnection();
            if (conn == null) throw new ConnectException();
            pstmt = stmt.prepareStatement(conn);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("error", e);
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.error("error", e);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("error", e);
            }
        }
    }

}
