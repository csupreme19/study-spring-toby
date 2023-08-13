package csh.studytobyspring;

import csh.studytobyspring.dao.DaoFactory;
import csh.studytobyspring.dao.MemberDeleteAll;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    void call() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        MemberDeleteAll dao = ctx.getBean("memberDao", MemberDeleteAll.class);

    }


}
