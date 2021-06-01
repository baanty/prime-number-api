package com.pijush.prime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pijush.prime.common.constants.PrimeGenerationAlgo;
import com.pijush.prime.service.PrimeGenerationService.BruteForcePrimeGenerationService;

/**
 * Use this Factory service to decide the prime generation
 * algorythm.
 * @author Pijush Kanti Das
 *
 */
@Service
public class PrimeGenerationServiceFactory {

	@Autowired
	private BruteForcePrimeGenerationService aBruteForcePrimeGenerationService;
	
	/**
	 * Use this factory method to determine 
	 * the desired algorythm or implementation of prime number generation.
	 * 
	 * @param aPrimeGenerationAlgo
	 * @return
	 */
	public PrimeGenerationService getPrimeGenerationServiceFromAlgo(final PrimeGenerationAlgo aPrimeGenerationAlgo) {
		
		switch (aPrimeGenerationAlgo) {
			case BRUTE_FORCE :
				{
					return aBruteForcePrimeGenerationService;
				}
		}
		
		return aBruteForcePrimeGenerationService;
			
	}
}
