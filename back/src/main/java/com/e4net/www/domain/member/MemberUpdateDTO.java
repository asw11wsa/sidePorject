package com.e4net.www.domain.member;

import com.e4net.www.domain.ParentDTO;

import lombok.Data;

@Data
public class MemberUpdateDTO extends ParentDTO{
	private long membSn;
	private String membId;
	private String membPwd;

}
