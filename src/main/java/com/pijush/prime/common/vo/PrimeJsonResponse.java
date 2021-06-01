package com.pijush.prime.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class PrimeJsonResponse implements PrimeResponseMarker {

	private List<String> primesTillInput;
}
