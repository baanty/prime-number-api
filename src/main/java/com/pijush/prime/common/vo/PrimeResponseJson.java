package com.pijush.prime.common.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.StringUtils;

import com.pijush.prime.common.constants.Constants;

import lombok.Data;

@Data
public class PrimeResponseJson implements PrimeResponse, Constants {

	
	private String initial;
	private List<Integer> primes;
	private String error;
	
	@Override
	public void setPrimes(String primes) {
		
		if ( !StringUtils.isEmpty(primes) ) {
			
			if ( this.primes == null ) {
				this.primes = new ArrayList<Integer>();
			}
			this.primes.clear();
			this.primes.addAll(
						Stream.of(primes.split(COMMA))
							  .map(Integer::parseInt)
							  .collect(Collectors.toList())
					);
		}
	}
	
}
