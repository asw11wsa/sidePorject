package com.e4net.www.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.e4net.www.dto.MemberLoginDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@PostMapping(value = "/user/test")
	public ResponseEntity<Map<String, String>> test(@RequestBody MemberLoginDTO dto){
		Map<String, String> map = new HashMap<>();
		map.put("hello", dto.getMembId());
		map.put("bye", dto.getMembPwd());
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
}
