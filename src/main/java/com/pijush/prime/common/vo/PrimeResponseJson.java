package com.pijush.prime.common.vo;

import lombok.Data;

@Data
public class PrimeResponseJson implements PrimeResponseType {

	
	private String initial;
	private String primes;
	private String error;
	
	
}
