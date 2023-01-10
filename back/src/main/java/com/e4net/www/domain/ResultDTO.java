package com.e4net.www.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultDTO {
	ParentDTO data;
	String message;
	int status;
	String error;
}
