package com.e4net.www.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.e4net.www.domain.ResultDTO;
import com.e4net.www.domain.member.MemberJoinDTO;
import com.e4net.www.domain.member.MemberLoginDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	/**
	 * for Login
	 * @author siuLee
	 * @param dto
	 * @throws Exception
	 * @date 2023. 01. 06.
	 * @see<pre></pre>
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody MemberLoginDTO dto){
		Map<String, String> map = new HashMap<>();
		map.put("hello", dto.getMembId());
		map.put("bye", dto.getMembPwd());
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
	
	@PostMapping(value = "/join")
	public ResponseEntity<ResultDTO> join(@RequestBody MemberJoinDTO dto){
		ResultDTO result = new ResultDTO();
		result.setData(dto);
		result.setMessage("join is Ok");
		result.setStatus(HttpStatus.NO_CONTENT);
		result.setError("no error");
		return new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
	}
}
