/**
 * 
 */
package com.pijush.prime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pijush.prime.common.vo.PrimeNumberCache;

/**
 * Use this class to store common functions
 * of all the different algorythm implementations of prime number generation.
 * 
 * @author Pijush Kanti Das
 *
 */
public abstract class AbstractPrimeGenerationService implements PrimeGenerationService {

	@Autowired
	private PrimeNumberCache aPrimeNumberCache;
	
	/**
	 * Use this method to check the application cache for already generated 
	 * primes. This will reduce computational cost.
	 * 
	 * @param initial
	 * @return
	 */
	public List<Integer> loadPrimeFromCache(final int initial) {
		List<Integer> answer = aPrimeNumberCache.get(initial);
		
		if ( answer == null ) {
			answer = this.generatePrimes(initial);
			aPrimeNumberCache.put(initial, answer);
		}
		return answer;
	}

}
