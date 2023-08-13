package csh.studytobyspring;

import csh.studytobyspring.dao.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

@Slf4j
public class Client {

    void call() throws SQLException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        MemberDao dao = ctx.getBean(MemberDao.class);

        // 삭제
        dao.jdbcContextWithStatementStrategy(new DeleteAllStatement());

        // 조회
        dao.jdbcContextWithStatementStrategy(new SelectStatement());

        // 저장
        dao.jdbcContextWithStatementStrategy(new SaveStatement());

        // 수정
        dao.jdbcContextWithStatementStrategy(new UpdateStatement());

    }


}
