package com.e4net.www.entity.point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.e4net.www.domain.point.PointDTO;
import com.e4net.www.entity.member.MemberEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "POINT")
@DynamicInsert
@NoArgsConstructor
public class PointEntity {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POINT_SN")
	private long pointSn;
	
	@OneToOne
	@JoinColumn(name = "POINT_OWNER",referencedColumnName = "MEMB_SN", nullable = false)
	private MemberEntity memberEntity;
	
	@Column(name = "POINT_MONEY")
	private long pointMoney;
	
	@Builder
	public PointEntity(PointDTO dto) {
		this.pointSn = dto.getPointSn();
		this.pointMoney = dto.getPointMoney();
		this.memberEntity = MemberEntity.builder()
				.dto(dto.getMdto())
				.build();
	}
}
