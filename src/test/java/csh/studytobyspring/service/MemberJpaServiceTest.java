package csh.studytobyspring.service;

import csh.studytobyspring.exception.RuntimeSQLException;
import csh.studytobyspring.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class MemberJpaServiceTest {

    @Autowired
    MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService.clear();
    }

    @Test
    @DisplayName("체크 예외는 롤백 안됨")
    void checkedExceptionShouldNotRollback() {
        assertThatThrownBy(() -> memberService.addChecked(new Member(999L, "최승훈", 28)))
                .isInstanceOf(SQLException.class);
        assertThat(memberService.findAll()).isNotEmpty();
    }

    @Test
    @DisplayName("언체크 예외는 롤백됨")
    void unCheckedExceptionShouldRollback() {
        assertThatThrownBy(() -> memberService.addUnchecked(new Member(999L, "최승훈", 28)))
                .isInstanceOf(RuntimeSQLException.class);
        assertThat(memberService.findAll()).isEmpty();
    }

}
