package com.pijush.prime.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorCodeWrapper {

	private String errorCode;
	private boolean isValidInput;
}
