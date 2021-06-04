package com.pijush.prime.service.primegeneration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.vo.PrimeNumberCache;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class EratosthenesSeivePrimeGenerationServiceUnitTest implements Constants {

	@Mock
	PrimeNumberCache aPrimeNumberCache;

	@InjectMocks
	EratosthenesSeivePrimeGenerationService aService ;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);		
		when(aPrimeNumberCache.get(10)).thenReturn(null);
	}
	
	
	@Test
	public void testValidResponse() {
		List<Integer> aListOfPrimes = aService.generatePrimes(10);
		String expected = "2,3,5,7";
		assertEquals(expected, Strings.join(aListOfPrimes, COMMA.toCharArray()[0]));
	}

}
