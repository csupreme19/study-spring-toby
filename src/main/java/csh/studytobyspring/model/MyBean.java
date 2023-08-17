package csh.studytobyspring.model;

import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private Long id;

    private String name;

    public MyBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
