package com.e4net.www.repository.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e4net.www.entity.member.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>,MemberRepositoryCustom {
	List<MemberEntity> findByMembId(String membId);
}
