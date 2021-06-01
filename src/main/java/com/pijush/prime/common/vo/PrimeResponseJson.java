package com.pijush.prime.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class PrimeResponseJson implements PrimeResponseType {

	
	private String initial;
	private List<String> primesTillInput;
	private String error;
}
