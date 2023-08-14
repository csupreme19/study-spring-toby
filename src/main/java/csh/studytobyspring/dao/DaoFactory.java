package csh.studytobyspring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate();
    }

}
