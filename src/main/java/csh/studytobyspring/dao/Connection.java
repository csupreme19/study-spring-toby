package csh.studytobyspring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface Connection {
    PreparedStatement prepareStatement(String stmt);

    void close() throws SQLException;
}
