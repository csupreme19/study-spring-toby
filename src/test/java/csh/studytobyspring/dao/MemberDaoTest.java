package csh.studytobyspring.dao;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.model.Member;
import csh.studytobyspring.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MemberDaoTest {

    @Mock
    MemberRepository dao;

    @Test
    @DisplayName("멤버 조회 테스트")
    void getMember() {
        // given
        Member member = new Member(1L, "최승훈", 10, Level.BRONZE);
        given(dao.getAll()).willReturn(List.of(member));
        given(dao.add(member)).willReturn(member);

        // when
        dao.add(member);
        Member foundMember = dao.getAll().get(0);

        // then
        assertThat(member.getName()).isEqualTo(foundMember.getName());
        assertThat(member.getAge()).isEqualTo(foundMember.getAge());
        verify(dao, times(1)).add(member);
        verify(dao, times(1)).getAll();
    }

}