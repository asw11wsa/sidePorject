package com.e4net.www.domain.point;

import com.e4net.www.domain.ParentDTO;
import com.e4net.www.domain.member.MemberDTO;
import com.e4net.www.entity.point.PointEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PointDTO extends ParentDTO{
	
	private long pointSn;
	private MemberDTO mdto;
	private long pointMoney;
	
	public PointDTO(PointEntity entity) {
		this.pointSn = entity.getPointSn();
		this.pointMoney = entity.getPointMoney();
		MemberDTO mdto = new MemberDTO();
		mdto.setMembId(entity.getMemberEntity().getMembId());
		mdto.setMembPwd(entity.getMemberEntity().getMembPwd());
		mdto.setMembSn(entity.getMemberEntity().getMembSn());
		this.mdto = mdto;
	}
	
	public PointDTO() {}
}
