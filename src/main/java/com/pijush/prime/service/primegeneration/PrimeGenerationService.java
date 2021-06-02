package com.pijush.prime.service.primegeneration;

import java.util.List;

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

	/**
	 * This method should have the concrete implementation
	 * of prime number generation.
	 * @param initial
	 * @return <code>List</code>
	 */
	public List<Integer> generatePrimes(final int initial);
	
	/**
	 * This method should have the prime cache loading and reading mechanism.
	 * 
	 * @param initial
	 * @return <code>List</code>
	 */
	public List<Integer> loadPrimeFromCache(final int initial);
}
