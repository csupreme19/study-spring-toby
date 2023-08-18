package csh.studytobyspring.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyServiceImpl implements MyService {

    @Override
    public void call() {
        log.info("MyService 호출");
    }

}
