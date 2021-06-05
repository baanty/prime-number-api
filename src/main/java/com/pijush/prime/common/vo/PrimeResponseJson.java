package com.pijush.prime.common.vo;

import org.springframework.http.MediaType;

import com.pijush.prime.common.constants.Constants;

import lombok.Data;

@Data
public class PrimeResponseJson implements PrimeResponseType, Constants {

	
	private String initial;
	private String primes;
	private String error;
	
	@Override
	public String getMediaType() {
		return MediaType.APPLICATION_JSON_VALUE;
	}
	
}
