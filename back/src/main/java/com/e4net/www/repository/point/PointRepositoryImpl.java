package com.e4net.www.repository.point;

import java.util.List;
import java.util.stream.Collectors;

import com.e4net.www.domain.ParentDTO;
import com.e4net.www.domain.member.MemberPointDTO;
import com.e4net.www.domain.point.PointDTO;
import com.e4net.www.entity.member.QMemberEntity;
import com.e4net.www.entity.point.PointEntity;
import com.e4net.www.entity.point.QPointEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepositoryCustom {
	
	private final JPAQueryFactory jpaQueryFactory;
	
	private QMemberEntity qMemberEntity = QMemberEntity.memberEntity;
	
	private QPointEntity qPointEntity = QPointEntity.pointEntity;

	@Override
	public List<ParentDTO> findMemberPoint(Long membSn) {
		List<PointEntity> result = jpaQueryFactory.select(qPointEntity)
				.from(qPointEntity)
				.leftJoin(qPointEntity.memberEntity, qMemberEntity)
				.fetchJoin()
				.where(qPointEntity.memberEntity.membSn.eq(membSn))
				.fetch();
		List<ParentDTO> pointList = result.stream().map(PointDTO::new).collect(Collectors.toList());
		return pointList;
	}

	@Override
	public List<ParentDTO> findMemberPointTest(Long membSn) {
		List<PointEntity> result = jpaQueryFactory.select(qPointEntity)
				.from(qPointEntity)
				.leftJoin(qPointEntity.memberEntity, qMemberEntity)
				.fetchJoin()
				.where(qPointEntity.memberEntity.membSn.eq(membSn))
				.fetch();
		List<ParentDTO> pointList = result.stream().map(MemberPointDTO::new).collect(Collectors.toList());
		return pointList;
	}

}
