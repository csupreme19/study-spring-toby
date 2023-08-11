package csh.studytobyspring.dao;

public class PostgresqlConnectionMaker implements ConnectionMaker {

    @Override
    public Connection getConnection() {
        return new PostgresqlConnection();
    }

}
