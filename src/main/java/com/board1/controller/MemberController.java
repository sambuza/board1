package com.board1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board1.dto.MemberDTO;
import com.board1.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String memberMethod() {
		
		return "index";
	}
	
	@GetMapping("member/memberWriteForm")
	public String memeberWirteForm(
			@RequestParam(value = "num", required=false) Integer num,//int 는 널이 허용안된다 그래서 Integer
			  Model model) {
		if(num != null) {
			
		System.out.println(num);

		MemberDTO m1 = memberService.getMemberOne(num);
	
		System.out.println(m1.getName());
		System.out.println(m1.getId());
		System.out.println(m1.getPhone());
	
		model.addAttribute("memberDTO", m1);
		model.addAttribute("formTitle", "Modification");
		}
		else {
			
			model.addAttribute("memberDTO",new MemberDTO());
			model.addAttribute("formTitle", "Registration");	
		System.out.println("null이무니니닌니다");
		}
		
		return "member/memberWriteForm";
	}
	
	
	
	
	@PostMapping("/member/memberWriteOk")
	public String insertMemeber(MemberDTO m1) {
		
		try {
			
			System.out.println(m1);
		   memberService.insertMember(m1);
		}
		catch( Exception e ){
		//err
			System.out.println(e);
		}
		
		return "index";
	}

}
