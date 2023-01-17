package com.e4net.www.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListResultDTO {
	List<ParentDTO> data;
	String message;
	int status;
	String error;
}
