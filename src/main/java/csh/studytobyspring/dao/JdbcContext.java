package csh.studytobyspring.dao;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.net.ConnectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class JdbcContext {

    public void executeSql(final String query) throws SQLException, ConnectException {
        workWithStatementStrategy(
                new StatementStrategy() {
                    public PreparedStatement prepareStatement(Connection c) throws SQLException {
                        return c.prepareStatement(query);
                    }
                }
        );
    }

    private DataSource dataSource;

    private ConnectionMaker connectionMaker;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectionMaker.getConnection();
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
