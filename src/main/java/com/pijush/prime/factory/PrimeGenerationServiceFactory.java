package com.pijush.prime.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pijush.prime.common.constants.PrimeGenerationAlgo;
import com.pijush.prime.service.primegeneration.BruteForcePrimeGenerationService;
import com.pijush.prime.service.primegeneration.EratosthenesSeivePrimeGenerationService;
import com.pijush.prime.service.primegeneration.PrimeGenerationService;
import com.pijush.prime.service.primegeneration.SundaramSievePrimeGenerationService;

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
	
	@Autowired
	private EratosthenesSeivePrimeGenerationService anEratosthenesSeivePrimeGenerationService;
	
	@Autowired
	private SundaramSievePrimeGenerationService aSundaramSievePrimeGenerationService;
	
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
			case ERATOSTHENES_SIEVE : 
				{
					return anEratosthenesSeivePrimeGenerationService;
				}
			case SUNDARAM_SIEVE : 
				{
					return aSundaramSievePrimeGenerationService;
				}
		default:
			break;
		}
		
		return aBruteForcePrimeGenerationService;
			
	}
}
