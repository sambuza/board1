package com.board1.service;

import org.springframework.stereotype.Service;

import com.board1.dto.MemberDTO;

import java.util.List;

@Service
public interface MemberService {

	public void insertMember(MemberDTO memberDTO);
	public MemberDTO getMemberOne(int num);
	public List<MemberDTO> getMemberAll();
	public void deleteMemberOne(String id);
}
