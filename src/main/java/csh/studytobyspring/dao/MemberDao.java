package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MemberDao {

    private final ConnectionMaker connectionMaker;

    public MemberDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public static Map<Long, Member> memberMap = new HashMap<>();

    public Member saveMember(Member member) {
        return memberMap.put(member.getId(), member);
    }

    public Member getMember(Long id) {
        return memberMap.get(id);
    }

    public List<Member> getMembers() {
        return memberMap.values().stream().toList();
    }

    public Member updateMember(Long id, Member updateMember) {
        return memberMap.put(id, updateMember);
    }

    public boolean deleteMember(Long id) {
        memberMap.remove(id);
        return true;
    }

    public Member findMember(Long id) {
        return getMember(id);
    }

    public List<Member> selectMembers() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectionMaker.getConnection();
            pstmt = conn.prepareStatement("delete from members");
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(conn, pstmt, rs);
        }

        return new ArrayList<>();
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
