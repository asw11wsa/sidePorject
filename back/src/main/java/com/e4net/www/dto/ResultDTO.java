package com.e4net.www.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultDTO {
	ParentDTO data;
	String message;
	HttpStatus status;
	String error;
}
