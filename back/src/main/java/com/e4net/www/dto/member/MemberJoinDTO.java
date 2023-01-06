package com.e4net.www.dto.member;

import com.e4net.www.dto.ParentDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinDTO extends ParentDTO{
	String membId,membPwd,name,phone,email,zipCode,zipAddrs,detailAddrs;
}
