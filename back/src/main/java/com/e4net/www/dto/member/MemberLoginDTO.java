package com.e4net.www.dto.member;

import com.e4net.www.dto.ParentDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberLoginDTO extends ParentDTO{
	String MembId;
	String MembPwd;
}
