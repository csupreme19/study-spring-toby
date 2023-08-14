package csh.studytobyspring.dao;

import csh.studytobyspring.exception.RuntimeSQLException;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.*;

@Slf4j
public class JdbcTemplate {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @throws RuntimeSQLException 쿼리 실행 예외
     */
    public void query(final String query) throws RuntimeSQLException {
        try {
            template(c -> c.prepareStatement(query));
        } catch (SQLException e) {
            throw new RuntimeSQLException(e);
        }
    }

    public void template(Callback stmt) throws SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = dataSource.getConnection();
            pstmt = stmt.prepareStatement(c);
            rs = pstmt.executeQuery();
        } finally {
            close(c, pstmt, rs);
        }
    }

    public void templateUpdate(Callback stmt) throws SQLException {
        Connection c = dataSource.getConnection();
        c.setAutoCommit(false); // 트랜잭션 시작

        try {
            PreparedStatement pstmt1 = c.prepareStatement("update members set name='최승훈' where id=1");
            pstmt1.executeUpdate();
            PreparedStatement pstmt2 = c.prepareStatement("update members set name='훈승최' where id=1");
            pstmt2.executeUpdate();
            c.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            c.rollback();   // 트랜잭션 롤백
        }

        c.close();
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
