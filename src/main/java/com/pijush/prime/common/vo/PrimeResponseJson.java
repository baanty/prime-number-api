package com.pijush.prime.common.vo;

import com.pijush.prime.common.constants.Constants;

import lombok.Data;

@Data
public class PrimeResponseJson implements PrimeResponseType, Constants {

	
	private String initial;
	private String primes;
	private String error;
	
}
