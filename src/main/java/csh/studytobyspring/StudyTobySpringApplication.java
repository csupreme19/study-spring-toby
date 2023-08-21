package csh.studytobyspring;

import csh.studytobyspring.model.MyBean;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileNotFoundException;

@SpringBootApplication
public class StudyTobySpringApplication {

    public static void main(String[] args) throws FileNotFoundException {
        ConfigurableApplicationContext ctx = SpringApplication.run(StudyTobySpringApplication.class, args);

        BeanFactory beanFactory = ctx.getBeanFactory();
        beanFactory.containsBean("myBean");
        MyBean bean = beanFactory.getBean(MyBean.class);

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public void com.my.app.Target.method(int) throws java.lang.RuntimeException)");
    }

}
