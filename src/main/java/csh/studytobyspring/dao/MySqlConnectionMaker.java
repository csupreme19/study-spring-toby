package csh.studytobyspring.dao;

public class MySqlConnectionMaker implements ConnectionMaker {

    @Override
    public Connection getConnection() {
        return new MySqlConnection();
    }
    
}
