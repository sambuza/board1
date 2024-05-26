package com.board1.mapper;

import com.board1.dto.MemberDTO;

import java.util.List;

public interface MemberMapper {

	public void insertMember(MemberDTO memberDTO);
	public MemberDTO selectMemberOne(int num);
	public List<MemberDTO> getMemberAll();
	public MemberDTO deleteMemberOne(String id);
}
