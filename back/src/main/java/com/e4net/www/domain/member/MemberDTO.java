package com.e4net.www.domain.member;

import com.e4net.www.domain.ParentDTO;
import com.e4net.www.entity.member.MemberEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO extends ParentDTO{
	private long membSn;
	private String membId;
	private String membPwd;
	
	public MemberDTO(MemberEntity entity) {
		this.membSn = entity.getMembSn();
		this.membId = entity.getMembId();
		this.membPwd = entity.getMembPwd();
	}
	
	public MemberDTO() {}
}
