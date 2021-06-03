package com.pijush.prime.factory;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.pijush.prime.common.constants.PrimeGenerationAlgo;
import com.pijush.prime.service.primegeneration.BruteForcePrimeGenerationService;
import com.pijush.prime.service.primegeneration.EratosthenesSeivePrimeGenerationService;
import com.pijush.prime.service.primegeneration.PrimeGenerationService;
import com.pijush.prime.service.primegeneration.SundaramSievePrimeGenerationService;

@RunWith(MockitoJUnitRunner.class) 
public class PrimeGenerationServiceFactoryUnitTest {
	
	@Mock
	BruteForcePrimeGenerationService aBruteForcePrimeGenerationService;
	
	@Mock
	EratosthenesSeivePrimeGenerationService anEratosthenesSeivePrimeGenerationService;
	
	@Mock
	SundaramSievePrimeGenerationService aSundaramSievePrimeGenerationService;

	@InjectMocks
	PrimeGenerationServiceFactory aFactory ;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);		
	}
	
	
	@Test
	public void testGetPrimeGenerationServiceFromAlgoBruteForce() {
		PrimeGenerationService service = aFactory.getPrimeGenerationServiceFromAlgo(PrimeGenerationAlgo.BRUTE_FORCE);
		assertTrue(service instanceof BruteForcePrimeGenerationService);
	}
	
	
	@Test
	public void testGetPrimeGenerationServiceFromAlgoEratosthenes() {
		PrimeGenerationService service = aFactory.getPrimeGenerationServiceFromAlgo(PrimeGenerationAlgo.ERATOSTHENES_SIEVE);
		assertTrue(service instanceof EratosthenesSeivePrimeGenerationService);
	}
	
	@Test
	public void testGetPrimeGenerationServiceFromSundaramSieve() {
		PrimeGenerationService service = aFactory.getPrimeGenerationServiceFromAlgo(PrimeGenerationAlgo.SUNDARAM_SIEVE);
		assertTrue(service instanceof SundaramSievePrimeGenerationService);
	}

}
