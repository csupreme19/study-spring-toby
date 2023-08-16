package csh.studytobyspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAccessConfig {

    @Bean
    JdbcTemplate myJdbcTemplate() {
        return new JdbcTemplate();
    }

//    @Bean
//    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        return new DefaultAdvisorAutoProxyCreator();
//    }

}
