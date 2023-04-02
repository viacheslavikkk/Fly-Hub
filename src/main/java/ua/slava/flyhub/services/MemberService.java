package ua.slava.flyhub.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.slava.flyhub.domen.enums.Role;
import ua.slava.flyhub.domen.models.Member;
import ua.slava.flyhub.repositories.MemberRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(Member member) {

        String name = member.getName();

        if (memberRepository.findByName(name) != null) {
            return false;
        }

        member.setActive(true);
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.getRoles().add(Role.ROLE_ADMIN);

        memberRepository.save(member);

        return true;
    }

    public void banMember(Long id) {

        Member member = memberRepository.findById(id).orElse(null);

        if (member.isActive()) {
            member.setActive(false);
        }
        member.setActive(true);

        memberRepository.save(member);
    }

    public void setRole(Long id) {

        Member member = memberRepository.findById(id).orElse(null);

        Set<Role> roleSet = member.getRoles();

        Role adminRole = Role.ROLE_ADMIN;
        Role userRole = Role.ROLE_USER;

        if (roleSet.contains(adminRole)) {
            roleSet.remove(adminRole);
            roleSet.add(userRole);
        } else {
            roleSet.remove(userRole);
            roleSet.add(adminRole);
        }

        memberRepository.save(member);
    }


}
