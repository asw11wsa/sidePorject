package com.e4net.www.repository.member;

import com.e4net.www.domain.member.MemberDTO;

public interface MemberRepositoryCustom {
	void updateMemb(MemberDTO dto);
	Long idCheck(MemberDTO dto);
}
