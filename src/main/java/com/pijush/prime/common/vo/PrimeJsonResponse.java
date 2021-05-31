package com.pijush.prime.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class PrimeJsonResponse implements PrimeResponse {

	private List<String> primesTillInput;
}
