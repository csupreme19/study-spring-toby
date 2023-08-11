package csh.studytobyspring;

import csh.studytobyspring.dao.ConnectionMaker;
import csh.studytobyspring.dao.Dao;
import csh.studytobyspring.dao.PostgresqlConnectionMaker;
import csh.studytobyspring.dao.PostgresqlDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyTobySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyTobySpringApplication.class, args);


        ConnectionMaker connectionMaker = new PostgresqlConnectionMaker();

        Dao dao = new PostgresqlDao(connectionMaker);


    }

}
