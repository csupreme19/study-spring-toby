package csh.studytobyspring.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface Callback {

    PreparedStatement prepareStatement(Connection conn) throws SQLException;

}
