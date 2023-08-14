package csh.studytobyspring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlConnection implements Connection {

    @Override
    public PreparedStatement prepareStatement(String stmt) {
        return null;
    }

    @Override
    public void close() throws SQLException {

    }
}
