package com.e4net.www.domain.member;

import com.e4net.www.domain.ParentDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberLoginDTO extends ParentDTO{
	String MembId;
	String MembPwd;
}
