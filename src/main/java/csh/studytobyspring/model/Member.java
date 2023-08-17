package csh.studytobyspring.model;

import csh.studytobyspring.constant.Level;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    private Long id;
    private String name;
    private Integer age;
    private Level level;

    public Member(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void upgradeLevel() {
        this.level = level.getNext();
    }
}
