package com.board1.controller;


import com.board1.dto.MemberDTO;
import com.board1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToReactController {

//    @Autowired
//    private MemberMapper memberMapper;

    @Qualifier("memberService")
    @Autowired
    private MemberService memberService;


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





}




