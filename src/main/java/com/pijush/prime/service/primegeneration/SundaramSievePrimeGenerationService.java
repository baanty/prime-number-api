package com.pijush.prime.service.primegeneration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Use this implementation of the <code>PrimeGenerationService</code> to
 * generate the prime number series with a Sundaram Sieve algorithm. Test all numbers with
 * number till it. It is an expensive algo. But a very basic one.
 * 
 * @author Pijush Kanti Das
 *
 */
@Service
public class SundaramSievePrimeGenerationService extends AbstractPrimeGenerationService {

	@Override
	public List<Integer> generatePrimes(final int initial) {
		List<Integer> prs = new ArrayList<>();

		int n = initial / 2;
		boolean[] prime = new boolean[initial];

		for (int i = 1; i < n; i++) {

			for (int j = i; j <= (n - i) / (2 * i + 1); j++) {

				prime[i + j + 2 * i * j] = true;
			}

		}

		for (int i = 2; i < prime.length / 2; i++) {
			
			if (!prime[i]) {
				prs.add(i);
			}
		}
		return prs;
	}
}
