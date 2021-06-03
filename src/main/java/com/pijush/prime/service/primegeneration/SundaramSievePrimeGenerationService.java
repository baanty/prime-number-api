package com.pijush.prime.service.primegeneration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Use this implementation of the <code>PrimeGenerationService</code> to
 * generate the prime number series with a Sundaram Sieve algorithm. Test all
 * numbers with number till it. It is an expensive algo. But a very basic one.
 * 
 * @author Pijush Kanti Das
 *
 */
@Service
public class SundaramSievePrimeGenerationService extends AbstractPrimeGenerationService {

	@Override
	public List<Integer> generatePrimes(final int initial) {
		int n = initial / 2;
		boolean[] isPrime = new boolean[initial];
		Arrays.fill(isPrime, true);
		
		for (int i = 1; i < n; i++) {
			
			for (int j = i; j <= (n - i) / (2 * i + 1); j++) {
				isPrime[i + j + 2 * i * j] = false;
			}
		}
		
		int[] primes = new int[initial];
		int found = 0;

		if (initial > 2) {
			primes[found++] = 2;
		}
		
		for (int i = 1; i < n; i++) {
			
			if (isPrime[i]) {
				primes[found++] = i * 2 + 1;
			}
		}
		
		List<Integer> intList = new ArrayList<>();
		int[] resultArray = Arrays.copyOf(primes, found);
		Arrays.stream(resultArray).forEach(r -> intList.add(r));
		return intList;
	}
}
