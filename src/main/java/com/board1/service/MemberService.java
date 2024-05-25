package com.board1.service;

import org.springframework.stereotype.Service;

import com.board1.dto.MemberDTO;

@Service
public interface MemberService {

	public void insertMember(MemberDTO memberDTO);
	public MemberDTO getMemberOne(int num);
}
