package csh.studytobyspring.repository;

import csh.studytobyspring.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
