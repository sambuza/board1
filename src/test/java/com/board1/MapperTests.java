package com.board1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board1.dto.MemberDTO;

import com.board1.service.MemberService;


@SpringBootTest
public class MapperTests {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void testInsert2() {
	
		MemberDTO m1 = new MemberDTO();
		m1.setName("new Borned");
    	m1.setId("sych21");
		m1.setPhone("900-232-2222");
	
		memberService.insertMember(m1);

}


	
	
	
}
