package csh.studytobyspring.repository;

import csh.studytobyspring.config.JdbcTemplate;
import csh.studytobyspring.model.Member;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemberRepository {

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
