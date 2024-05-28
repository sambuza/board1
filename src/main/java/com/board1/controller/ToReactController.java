package com.board1.controller;


import com.board1.dto.MemberDTO;
import com.board1.service.MemberService;
import com.board1.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;


@RequiredArgsConstructor
@RequestScope
@RestController
public class ToReactController {


    private final HttpServletRequest request;
    private final HttpServletResponse response;

//    @Autowired
//    private MemberMapper memberMapper;

    @Qualifier("memberService")
    @Autowired
    private MemberService memberService;

    @Autowired
    private UserService userService;


    @GetMapping("/user/")
    public List<MemberDTO> findAll(Model model){

        List<MemberDTO> memberList = memberService.getMemberAll();
        return memberList;

    }

    @GetMapping("/user/{id}")
    public String getByID(@PathVariable int id){

        MemberDTO m1 = memberService.getMemberOne(id);
        System.out.println("name:"+m1.getName()+"Phone:"+m1.getPhone());

        return "id:"+m1.getId();

    }

    @PostMapping("/user")
    public String save(String username, String password, String email){

         return username+ password+ email;

    }


    @PutMapping("/user/{id}")
    public String update(@PathVariable int id){

        return null;

    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable String id){
        memberService.deleteMemberOne(id);
        System.out.println("id:"+id);
        return null;

    }


    @PostMapping("/user/login")
    public ResponseEntity<String> checkCredentials(@RequestBody List<String> valuesList1) {
        System.out.println(valuesList1);
        System.out.println(valuesList1.get(0));
        System.out.println(valuesList1.get(1));

    	int result = userService.authenticateUser(valuesList1.get(0), valuesList1.get(1));

        if (result == 1) {
            return ResponseEntity.ok("할렐루야");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디와 비밀번호가 일치하지 않습니다");
        }
    }


    @PostMapping("/user/login1")
    public ResponseEntity<String> checkCredentials1(@RequestBody List<String> valuesList1) {
//        System.out.println(valuesList1);
//        System.out.println(valuesList1.get(0));
//        System.out.println(valuesList1.get(1));





        HttpSession session = request.getSession(true);
        System.out.println(valuesList1);
        System.out.println(session.getId());
        int sessionTimeoutInSeconds = 60; // 1분
        session.setMaxInactiveInterval(sessionTimeoutInSeconds);

        int authenticationStatus = userService.authenticateUser(valuesList1.get(0), valuesList1.get(1));
        boolean isAuthenticated = (authenticationStatus == 1);
        System.out.println(isAuthenticated);

        if (isAuthenticated) {
             session.setAttribute("username", valuesList1.get(0));
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            String username = authentication.getName(); // anonymousUser
            String username = valuesList1.get(0);

            return ResponseEntity.ok(username+"님의 방문을 환영합니다");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디와 비밀번호가 일치하지 않습니다");
        }
    }




}




