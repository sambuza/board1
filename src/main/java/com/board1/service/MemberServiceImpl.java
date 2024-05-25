package com.board1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board1.dto.MemberDTO;
import com.board1.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void insertMember(MemberDTO memberDTO){
		
	memberMapper.insertMember( memberDTO );
	}
    public MemberDTO getMemberOne(int num){
    
    return memberMapper.selectMemberOne(num);
    }
    }
