package csh.studytobyspring.dao;

import csh.studytobyspring.model.Member;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcContext;

    public void setJdbcContext(DataSource dataSource) {
        this.jdbcContext = new JdbcTemplate();
        this.jdbcContext.setDataSource(dataSource);
    }

    public void deleteAll() {
        this.jdbcContext.query("delete from members");
    }

    public void update(Connection c, Member member) {
        jdbcContext.query("update member set level=" + member.getLevel()
                + "where id=" + member.getId());
    }

    public List<Member> getAll() {
        return null;
    }
}
