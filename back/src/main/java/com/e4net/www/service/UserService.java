package com.e4net.www.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.aspectj.weaver.ast.Instanceof;
import org.hibernate.annotations.Parent;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.e4net.www.domain.ListResultDTO;
import com.e4net.www.domain.ParentDTO;
import com.e4net.www.domain.ResultDTO;
import com.e4net.www.domain.member.MemberCountDTO;
import com.e4net.www.domain.member.MemberDTO;
import com.e4net.www.domain.member.MemberPointDTO;
import com.e4net.www.domain.point.PointDTO;
import com.e4net.www.entity.member.MemberEntity;
import com.e4net.www.entity.point.PointEntity;
import com.e4net.www.repository.member.MemberRepository;
import com.e4net.www.repository.point.PointRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {
	
	private final MemberRepository memberRepository;
	
	private final PointRepository pointRepository;
	
	public ResultDTO join(MemberDTO dto) {
		ResultDTO result = new ResultDTO();
		try {
			// 회원 가입
			MemberEntity entity = MemberEntity.builder()
					.dto(dto)
					.build();
			
			// 회원 가입후 고유 번호 가져오기
			MemberEntity save = memberRepository.save(entity);
			
			//회원 가입 처리후 포인트 저장소 만들기
			PointDTO pdto = new PointDTO();
			pdto.setPointMoney(0);
			MemberDTO mdto = new MemberDTO();
			mdto.setMembId(save.getMembId());
			mdto.setMembPwd(save.getMembPwd());
			mdto.setMembSn(save.getMembSn());
			pdto.setMdto(mdto);
			PointEntity pentity = PointEntity.builder()
					.dto(pdto)
					.build();
			pointRepository.save(pentity);
			result.setData(dto);
			result.setMessage("success");
			result.setStatus(HttpStatus.OK.value());
		} catch (Exception e) {
			result.setError("error");
			result.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return result;
	}
	
	public ListResultDTO userList() {
		ListResultDTO result = new ListResultDTO();
		List<MemberEntity> mEntity = memberRepository.findAll();
		List<ParentDTO> list = mEntity.stream().map(MemberDTO::new).collect(Collectors.toList());
		result.setData(list);
		return result;
	}
	
	public ResultDTO update(MemberDTO dto) {
		ResultDTO result = new ResultDTO();
		try {
			memberRepository.updateMemb(dto);
			result.setData(dto);
			result.setMessage("success");
			result.setStatus(HttpStatus.OK.value());
		} catch (Exception e) {
			result.setMessage("failure");
			result.setStatus(HttpStatus.NO_CONTENT.value());
			result.setError(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	public ListResultDTO findMemberPoint(Long membSn) {
		ListResultDTO result = new ListResultDTO();
		try {
			result.setData(pointRepository.findMemberPoint(membSn));
			result.setMessage("success");
			result.setStatus(HttpStatus.OK.value());
		} catch (Exception e) {
			result.setMessage("failure");
			result.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return result;
	}
	
	public ListResultDTO findMemberPointTest(Long membSn) {
		ListResultDTO result = new ListResultDTO();
		try {
			result.setData(pointRepository.findMemberPointTest(membSn));
			result.setMessage("success");
			result.setStatus(HttpStatus.OK.value());
		} catch (Exception e) {
			result.setMessage("failure");
			result.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return result;
	}
	
	public ResultDTO idCheck(MemberDTO dto) {
		ResultDTO result = new ResultDTO();
		try {
			MemberCountDTO count = new MemberCountDTO();
			count.setCount(memberRepository.idCheck(dto));
			result.setData(count);
			result.setMessage("success");
			result.setStatus(HttpStatus.OK.value());
		}catch (Exception e) {
			result.setMessage("failure");
			result.setStatus(HttpStatus.NO_CONTENT.value());
		}
		return result;
	}

}
