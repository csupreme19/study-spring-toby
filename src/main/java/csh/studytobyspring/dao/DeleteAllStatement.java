package csh.studytobyspring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllStatement implements StatementStrategy {

    @Override
    public PreparedStatement prepareStatement(Connection conn) throws SQLException {
        return conn.prepareStatement("delete from members");
    }

}
