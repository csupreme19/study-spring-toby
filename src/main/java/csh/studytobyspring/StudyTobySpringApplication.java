package csh.studytobyspring;

import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.dao.DaoFactory;
import csh.studytobyspring.model.Member;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class StudyTobySpringApplication {

    public static void main(String[] args) {
//        SpringApplication.run(StudyTobySpringApplication.class, args);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);
        MemberDao dao = ctx.getBean("memberDao", MemberDao.class);
        Member member = new Member(1L, "최승훈", 10);
        dao.saveMember(member);
        dao.getMember(member.getId());
        System.out.println(member.toString());
    }

}
