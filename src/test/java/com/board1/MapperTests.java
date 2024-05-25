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
		m1.setName("i kim");
    	m1.setId("i1");
		m1.setPhone("90-232-2222");
	
		memberService.insertMember(m1);

}


	
	
	
}
