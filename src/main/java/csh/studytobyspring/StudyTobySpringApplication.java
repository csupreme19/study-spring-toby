package csh.studytobyspring;

import csh.studytobyspring.service.MemberService;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileNotFoundException;

@SpringBootApplication
public class StudyTobySpringApplication {

    public static void main(String[] args) throws FileNotFoundException {
        ConfigurableApplicationContext run = SpringApplication.run(StudyTobySpringApplication.class, args);
        MemberService memberService = run.getBean(MemberService.class);
        memberService.upgradeLevels();

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public void com.my.app.Target.method(int) throws java.lang.RuntimeException)");
    }

}
