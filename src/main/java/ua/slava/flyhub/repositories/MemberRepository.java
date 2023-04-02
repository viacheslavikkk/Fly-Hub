package ua.slava.flyhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.slava.flyhub.domen.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(String name);
}
