package csh.studytobyspring;

import csh.studytobyspring.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class Client {

    @Autowired
    MemberDao dao;

    void call() {
        dao.deleteAll();
    }


}
