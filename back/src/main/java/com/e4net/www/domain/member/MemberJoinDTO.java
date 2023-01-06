package com.e4net.www.domain.member;

import com.e4net.www.domain.ParentDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinDTO extends ParentDTO{
	String membId;
	String membPwd;
	String name;
	String phone;
	String email;
	String zipCode;
	String zipAddrs;
	String detailAddrs;
}
