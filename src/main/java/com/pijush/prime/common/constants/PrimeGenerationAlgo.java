package com.pijush.prime.common.constants;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.util.StringUtils;

/**
 * Use this enum to decide 
 * prime numbers generation strategy.
 * 
 * @author Pijush Kanti Das
 *
 */
public enum PrimeGenerationAlgo {

	BRUTE_FORCE,/* Test if all the numbers are divisable 
	 			   by numbers from 2 till the number.*/
	ERATOSTHENES_SIEVE, /* Use Eratosthenes sieve algorythm. */
	
	SUNDARAM_SIEVE, /* Use Eratosthenes sieve algorythm. */
	;
	
	/**
	 * Use this method to get the <code>PrimeGenerationAlgo</code> from the request parameter.
	 * It mathces the enum name. If the enum is not found then it returns <code>PrimeGenerationAlgo.BRUTE_FORCE</code>
	 * enum.
	 * 
	 * @param algorithm
	 * @return : <code>PrimeGenerationAlgo</code>
	 */
	public static final PrimeGenerationAlgo getPrimeAlgoFromRequestParam(final String algorithm) {
		
		if ( !StringUtils.isEmpty(algorithm) ) {
			Optional<PrimeGenerationAlgo> optionalPrimeGenerationAlgo = 
					Stream.of(PrimeGenerationAlgo.values())
						  .filter(anAlgo -> anAlgo.name().equalsIgnoreCase(algorithm))
						  .findFirst();
					
					if ( optionalPrimeGenerationAlgo.isPresent() ) {
						return optionalPrimeGenerationAlgo.get();
					}
		}

		return BRUTE_FORCE;
		
	}
}
