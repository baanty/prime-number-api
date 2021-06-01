package com.pijush.prime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Use this interface to generate prime numbers
 * range from a given right end. The user must pass the 
 * <code>PrimeGenerationAlgo</code> and the right end of the series.
 * 
 *  
 * @author Pijush Kanti Das
 *
 */

public interface PrimeGenerationService {

	public List<Integer> generatePrimes(final int initial);
	
	
	/**
	 * Use this implementation of the <code>PrimeGenerationService</code>
	 * to generate the prime number series in brute force way. Test all numbers with
	 * number till it. It is an expensive algo. But a very basic one.
	 * 
	 * @author Pijush Kanti Das
	 *
	 */
	@Service
	public static class BruteForcePrimeGenerationService implements PrimeGenerationService {

		@Override
		public List<Integer> generatePrimes(final int initial) {
			List<Integer> prs = new ArrayList<>();
			
			for ( int input = 2 ; input <= initial ; input++ ) {
				
				if ( isPrime(input) ) {
					prs.add(input);
				}
			}
			return prs;
		}
		
		private boolean isPrime(int number) {
			
			for ( int divisor = 2 ; divisor < number ; divisor++ ) {
				
				if ( number % divisor == 0 ) {
					return false;
				}
			}
			return true;
		}
		
	}
}
