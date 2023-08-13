package csh.studytobyspring;

import csh.studytobyspring.dao.DaoFactory;
import csh.studytobyspring.dao.DeleteAllStatement;
import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.dao.StatementStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

@Slf4j
public class Client {

    void call() throws SQLException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        MemberDao dao = ctx.getBean(MemberDao.class);

        StatementStrategy strategy = new DeleteAllStatement();
        dao.jdbcContextWithStatementStrategy(strategy);

    }


}
