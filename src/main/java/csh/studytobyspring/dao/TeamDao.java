package csh.studytobyspring.dao;

import csh.studytobyspring.model.Team;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeamDao {
    public void add(Team team) {
        log.info("add team = {}", team);
    }
}
