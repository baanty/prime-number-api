package com.pijush.prime.service.primegeneration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Use this implementation of the <code>PrimeGenerationService</code> to
 * generate the prime number series in Eratosthenes Seive way. The algorythm
 * detail can be found here
 * </i>https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes</i> .
 * Time complexity : O(n*log(log(n))) for this algorythm.
 * 
 * @author Pijush Kanti Das
 *
 */
@Service
public class EratosthenesSeivePrimeGenerationService extends AbstractPrimeGenerationService {

	@Override
	public List<Integer> generatePrimes(final int initial) {
		List<Integer> prs = new ArrayList<>();
		boolean prime[] = new boolean[initial + 1];
		
		for (int i = 0; i <= initial; i++)
			prime[i] = true;

		for (int p = 2; p * p <= initial; p++) {
			
			if (prime[p] == true) {
				
				for (int i = p * p; i <= initial; i += p)
					prime[i] = false;
			}
		}

		for (int i = 2; i <= initial; i++) {
			
			if (prime[i] == true)
				prs.add(i);
		}
		return prs;
	}

}
