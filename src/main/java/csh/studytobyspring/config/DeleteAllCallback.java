package csh.studytobyspring.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllCallback implements Callback {
    @Override
    public PreparedStatement prepareStatement(Connection conn) throws SQLException {
        return conn.prepareStatement("delete from members");
    }
}
