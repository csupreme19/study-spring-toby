package csh.studytobyspring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    JdbcContext jdbcContext() {
        return new JdbcContext();
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new PostgresqlConnectionMaker();
    }

}
