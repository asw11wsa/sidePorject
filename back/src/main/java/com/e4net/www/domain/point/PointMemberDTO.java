package com.e4net.www.domain.point;

import com.e4net.www.domain.member.MemberDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PointMemberDTO {
	private long pointSn;
	private MemberDTO mdto;
	private long pointMoney;
}
