package csh.studytobyspring;

import csh.studytobyspring.dao.Dao;
import csh.studytobyspring.dao.DaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    void call() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        Dao dao = ctx.getBean("dao", Dao.class);

    }


}
