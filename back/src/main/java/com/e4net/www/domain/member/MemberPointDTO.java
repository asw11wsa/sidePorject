package com.e4net.www.domain.member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberPointDTO {
	private long membSn;
	private String membId;
	private String membPwd;
	private long pointMoney;
}
