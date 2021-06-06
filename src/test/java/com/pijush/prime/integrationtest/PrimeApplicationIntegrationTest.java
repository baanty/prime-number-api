package com.pijush.prime.integrationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.vo.PrimeResponse;
import com.pijush.prime.common.vo.PrimeResponseJson;
import com.pijush.prime.common.vo.jaxb.PrimeResponseXml;
import com.pijush.prime.presentation.controller.PrimeController;



@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimeApplicationIntegrationTest implements Constants {

	@Autowired
	PrimeController aPrimeController;
	
	@Test
	public void testWithValidParameters() {
		PrimeResponse aPrimeResponseType = aPrimeController.getPrimeNumbersXml("10", "BRUTE_FORCE");
		assertNotNull(aPrimeResponseType);
		assertTrue(aPrimeResponseType instanceof PrimeResponseXml);
		assertNull(aPrimeResponseType.getError());
		assertEquals("10", aPrimeResponseType.getInitial());
		assertEquals("2,3,5,7", aPrimeResponseType.getPrimes());
	}
	
	@Test
	public void testWithValidParametersJson() {
		PrimeResponse aPrimeResponseType = aPrimeController.getPrimeNumbersJson("10", "BRUTE_FORCE");
		assertNotNull(aPrimeResponseType);
		assertTrue(aPrimeResponseType instanceof PrimeResponseJson);
		assertNull(aPrimeResponseType.getError());
		assertEquals("10", aPrimeResponseType.getInitial());
		Object anObject = aPrimeResponseType.getPrimes();
		assertNotNull(anObject);
		assertTrue(anObject instanceof List);
		@SuppressWarnings("unchecked")
		List<Integer> primes = (List<Integer>) anObject;
		List<Object> expectedPrimes = Arrays.asList(new int[]{2, 3, 5, 7});
		
		for ( int index = 0 ; index < 4 ; index++ ) {
			assertEquals(expectedPrimes.get(index), primes.get(index));
		}
		
		
	}
	
	@Test
	public void testWithValidParametersJsonInvalidHttpHeader() {
		PrimeResponse aPrimeResponseType = aPrimeController.getResponseForInValidHeader("10", "BRUTE_FORCE", "XLM");
		assertNotNull(aPrimeResponseType);
		assertTrue(aPrimeResponseType instanceof PrimeResponseJson);
		assertNotNull(aPrimeResponseType.getError());
		assertEquals(String.format(INVALID_HTTP_HEADER, "XLM"), aPrimeResponseType.getError());
	}
}
