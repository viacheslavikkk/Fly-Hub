package ua.slava.flyhub.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.slava.flyhub.domen.models.Member;
import ua.slava.flyhub.services.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(Member member, Model model) {
        if (!memberService.createUser(member)) {

            model.addAttribute("errorMessage", "User with email "
                    + member.getEmail() + " is already exists!");

            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/user-info/{member}")
    public String userInfo(@PathVariable("member") Member member, Model model) {
        model.addAttribute("member", member);
        model.addAttribute("plane", member.getPlanes());
        return "user-info";
    }

}
