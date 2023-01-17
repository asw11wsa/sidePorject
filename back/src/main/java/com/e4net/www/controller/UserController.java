package com.e4net.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.e4net.www.domain.ListResultDTO;
import com.e4net.www.domain.ResultDTO;
import com.e4net.www.domain.member.MemberDTO;
import com.e4net.www.domain.member.MemberPointDTO;
import com.e4net.www.domain.point.PointDTO;
import com.e4net.www.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	/**
	 * for Login
	 * @author siuLee
	 * @param dto
	 * @throws Exception
	 * @date 2023. 01. 06.
	 * @see<pre></pre>
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody MemberDTO dto){
		Map<String, String> map = new HashMap<>();
		map.put("hello", dto.getMembId());
		map.put("bye", dto.getMembPwd());
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
	
	@PostMapping(value = "/join")
	public ResponseEntity<ResultDTO> join(@RequestBody MemberDTO dto){
		ResultDTO result = userService.join(dto);
		return new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = "/update")
	public ResponseEntity<ResultDTO> update(@RequestBody MemberDTO dto){
		ResultDTO result = userService.update(dto);
		return new ResponseEntity<ResultDTO>(result,HttpStatus.OK);
	}
	
	@GetMapping(value = "/idcheck")
	public ResponseEntity<ResultDTO> idCheck(MemberDTO dto){
		System.out.println(dto.getMembId());
		ResultDTO result = userService.idCheck(dto);
		return new ResponseEntity<ResultDTO>(result,HttpStatus.OK);
	}
	
	@PostMapping(value = "/user/point")
	public ResponseEntity<ListResultDTO> userPoint(@RequestBody MemberDTO dto){
		ListResultDTO result = userService.findMemberPoint(dto.getMembSn());
		return new ResponseEntity<ListResultDTO>(result,HttpStatus.OK);
	}
	
	@PostMapping(value = "/user/point/test")
	public ResponseEntity<ListResultDTO> userPointTest(@RequestBody MemberDTO dto){
		ListResultDTO result = userService.findMemberPointTest(dto.getMembSn());
		return new ResponseEntity<ListResultDTO>(result,HttpStatus.OK);
	}
}
