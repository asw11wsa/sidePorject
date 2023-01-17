package com.e4net.www.repository.member;

import com.e4net.www.domain.member.MemberDTO;
import com.e4net.www.entity.member.QMemberEntity;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;
	
	private QMemberEntity qMemberEntity = QMemberEntity.memberEntity;
	
	@Override
	public void updateMemb(MemberDTO dto) {
		UpdateClause<JPAUpdateClause> updateBuilder = jpaQueryFactory.update(qMemberEntity);
		System.out.println("break point");
		if(dto.getMembId() != null || !dto.getMembId().equals("")) {
			updateBuilder.set(qMemberEntity.membId, dto.getMembId());
		}
		
		if(dto.getMembPwd() != null || !dto.getMembPwd().equals("")) {
			updateBuilder.set(qMemberEntity.membPwd, dto.getMembPwd());
		}
		
		updateBuilder
		.where(qMemberEntity.membSn.eq(dto.getMembSn()))
		.execute();
	}

	@Override
	public Long idCheck(MemberDTO dto) {
		return jpaQueryFactory
				.select(qMemberEntity.count())
				.from(qMemberEntity)
				.where(qMemberEntity.membId.eq(dto.getMembId()))
				.fetchOne();
	}

}
