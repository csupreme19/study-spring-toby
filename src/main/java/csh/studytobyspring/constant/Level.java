package csh.studytobyspring.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Level {

    GOLD(3, null),
    SILVER(2, GOLD),
    BRONZE(1, SILVER);

    private final int value;

    private final Level next;

}
