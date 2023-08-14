package csh.studytobyspring.dao;

import jakarta.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.mybatis.spring.MyBatisSystemException;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MemberDao {

    private JdbcContext jdbcContext;

    public void setJdbcContext(DataSource dataSource) {
        this.jdbcContext = new JdbcContext();
        this.jdbcContext.setDataSource(dataSource);
    }

    public void deleteAll() {
        this.jdbcContext.executeSql("delete from members");
    }

    public void addJdbc() throws SQLException {
    }

    public void addJpa() throws PersistenceException {
    }

    public void addHibernate() throws HibernateException {
    }

    public void addMybatis() throws MyBatisSystemException {
    }

}
