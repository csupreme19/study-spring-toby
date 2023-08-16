package csh.studytobyspring.dao;

import csh.studytobyspring.constant.Level;
import csh.studytobyspring.model.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class MemberDaoTest {

    @Mock
    MemberDao dao;

    @Test
    @DisplayName("멤버 조회 테스트")
    void getMember() {
        Member member = new Member(1L, "최승훈", 10, Level.BRONZE);

        BDDMockito.given(dao.getAll()).willReturn(List.of(member));
        BDDMockito.given(dao.add(member)).willReturn(member);

        dao.add(member);
        Member foundMember = dao.getAll().get(0);

        Assertions.assertThat(member.getName()).isEqualTo(foundMember.getName());
        Assertions.assertThat(member.getAge()).isEqualTo(foundMember.getAge());

        BDDMockito.verify(dao, Mockito.times(1)).add(member);
        BDDMockito.verify(dao, Mockito.times(1)).getAll();
    }

}