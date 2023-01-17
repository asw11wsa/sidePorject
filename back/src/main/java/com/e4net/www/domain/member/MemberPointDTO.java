package com.e4net.www.domain.member;

import com.e4net.www.domain.ParentDTO;
import com.e4net.www.entity.point.PointEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberPointDTO extends ParentDTO{
	private long membSn;
	private String membId;
	private long pointMoney;
	private long pointSn;
	
	public MemberPointDTO(PointEntity entity) {
		this.membSn = entity.getMemberEntity().getMembSn();
		this.membId = entity.getMemberEntity().getMembId();
		this.pointMoney = entity.getPointMoney();
		this.pointSn = entity.getPointSn();
	}
	
	public MemberPointDTO() {}
}
