package com.board1.mapper;

import com.board1.dto.MemberDTO;

public interface MemberMapper {

	public void insertMember(MemberDTO memberDTO);
	public MemberDTO selectMemberOne(int num);
}
