package csh.studytobyspring.model;

import csh.studytobyspring.constant.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Member {

    private Long id;
    private String name;
    private Integer age;
    private Level level;

    public void updateLevel() {
        this.level = level.getNext();
    }
}
