package csh.studytobyspring;

import csh.studytobyspring.dao.Dao;
import csh.studytobyspring.dao.DaoFactory;

public class Client {

    void call() {

        Dao dao = new DaoFactory().dao();
        dao.getMembers();

    }


}
