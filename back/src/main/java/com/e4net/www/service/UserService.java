package com.e4net.www.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.e4net.www.domain.ResultDTO;
import com.e4net.www.domain.member.MemberDTO;
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
					/*
			 * Copyright 2023 the original author or authors.
			 *
			 * Licensed under the Apache License, Version 2.0 (the "License");
			 * you may not use this file except in compliance with the License.
			 * You may obtain a copy of the License at
			 *
			 *      https://www.apache.org/licenses/LICENSE-2.0
			 *
			 * Unless required by applicable law or agreed to in writing, software
			 * distributed under the License is distributed on an "AS IS" BASIS,
			 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
			 * See the License for the specific language governing permissions and
			 * limitations under the License.
			 */

			result.setData(dto);
			result.setMessage("join success");
			result.setStatus(200);
		} catch (Exception e) {
			result.setStatus(400);
			result.setError("error");
		}
		return result;
	}
	
	public ResultDTO update(MemberDTO dto) {
		ResultDTO result = new ResultDTO();
		try {
			System.out.println(dto.getMembId());
			System.out.println(dto.getMembPwd());
			memberRepository.updateMemb(dto);
			result.setData(dto);
			result.setMessage("update success");
			result.setStatus(200);
		} catch (Exception e) {
			result.setStatus(400);
			result.setMessage("make error doing update");
			result.setError(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	public List<PointDTO> findMemberPoint(Long membSn) {
		// 미완성
		
		//List<Tuple> test = memberRepository.findMemberPoint(4l);
		//System.out.println(test);
		return pointRepository.findMemberPoint(4l);
	}

}
