package csh.studytobyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootApplication
public class StudyTobySpringApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(StudyTobySpringApplication.class, args);

        // 데코레이터 패턴
        InputStream is = new BufferedInputStream(new FileInputStream("hello.txt"));

    }

}
