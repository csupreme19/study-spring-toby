package csh.studytobyspring;

import csh.studytobyspring.dao.DaoFactory;
import csh.studytobyspring.dao.MemberDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Client {

    void call() throws SQLException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        MemberDao dao = ctx.getBean(MemberDao.class);

    }


}
