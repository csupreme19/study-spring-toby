package csh.studytobyspring;

import csh.studytobyspring.dao.Dao;
import csh.studytobyspring.dao.DaoFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyTobySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyTobySpringApplication.class, args);

        Dao dao = new DaoFactory().dao();
        dao.getMembers();


    }

}
