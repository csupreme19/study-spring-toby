package csh.studytobyspring.dao;

public class DaoFactory {

    public Dao dao() {
        return new Dao(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new PostgresqlConnectionMaker();
    }

}
