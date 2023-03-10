package com.e4net.www.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultDTO<T> {
	T data;
	String message;
	int status;
	String error;
}
