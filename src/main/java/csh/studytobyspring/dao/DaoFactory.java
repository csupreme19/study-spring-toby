package csh.studytobyspring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public MemberDeleteAll memberDao() {
        return new MemberDeleteAll(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new PostgresqlConnectionMaker();
    }

}
