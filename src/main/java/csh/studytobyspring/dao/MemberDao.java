package csh.studytobyspring.dao;

import csh.studytobyspring.config.JdbcTemplate;
import csh.studytobyspring.model.Member;

import javax.sql.DataSource;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcContext;

    public void setJdbcContext(DataSource dataSource) {
        this.jdbcContext = new JdbcTemplate();
        this.jdbcContext.setDataSource(dataSource);
    }

    public Member add(Member member) {
        return member;
    }

    public void deleteAll() {
        this.jdbcContext.query("delete from members");
    }

    public List<Member> getAll() {
        return null;
    }
}
