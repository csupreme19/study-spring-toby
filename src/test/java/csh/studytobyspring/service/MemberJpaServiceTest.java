package csh.studytobyspring.service;

import csh.studytobyspring.exception.RuntimeSQLException;
import csh.studytobyspring.model.Member;
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

    @Test
    @DisplayName("체크 예외는 롤백 안됨")
    void checkedExceptionShouldNotRollback() {
        Member member = new Member(999L, "최승훈", 28);
        assertThatThrownBy(() -> memberService.addChecked(member))
                .isInstanceOf(SQLException.class);
        assertThat(memberService.findAll()).isNotEmpty();
        memberService.clear();
    }

    @Test
    @DisplayName("언체크 예외는 롤백됨")
    void unCheckedExceptionShouldRollback() {
        Member member = new Member(999L, "abc", 28);
        assertThatThrownBy(() -> memberService.addUnchecked(member))
                .isInstanceOf(RuntimeSQLException.class);
        assertThat(memberService.findAll()).isEmpty();
    }

    @Test
    @DisplayName("프록시 내부 호출 미적용")
    void proxyInternalCall() {
        memberService.external();
    }

}
