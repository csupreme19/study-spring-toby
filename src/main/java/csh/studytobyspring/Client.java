package csh.studytobyspring;

import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.dao.DaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    void call() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        MemberDao dao = ctx.getBean("memberDao", MemberDao.class);

    }


}
