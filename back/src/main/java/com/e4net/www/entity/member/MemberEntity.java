package com.e4net.www.entity.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.e4net.www.domain.member.MemberDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBERS")
@DynamicInsert
@NoArgsConstructor
@Getter
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMB_SN")
	long membSn;
	
	@Column(name = "MEMB_ID")
	String membId;
	
	@Column(name = "MEMB_PWD")
	String membPwd;
	
	@Builder
	public MemberEntity(MemberDTO dto) {
		this.membSn = dto.getMembSn();
		this.membPwd = dto.getMembPwd();
		this.membId = dto.getMembId();
	}
}
