package csh.studytobyspring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {

    PreparedStatement prepareStatement(Connection conn) throws SQLException;

}
