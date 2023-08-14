package csh.studytobyspring;

import csh.studytobyspring.dao.MemberDao;
import csh.studytobyspring.exception.RuntimeConnectException;
import csh.studytobyspring.exception.RuntimeSQLException;
import org.springframework.beans.factory.annotation.Autowired;

public class Client {

    @Autowired
    MemberDao dao;


    void call() throws RuntimeSQLException, RuntimeConnectException {
        dao.deleteAll();
    }


}
