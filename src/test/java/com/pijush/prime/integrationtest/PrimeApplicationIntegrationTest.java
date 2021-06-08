package com.pijush.prime.integrationtest;

import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

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
	
	@Autowired
	ExecutorService executor;
	
	private static final int NUMBER_OF_CONCURRENT_RUNS = 100000 ;
	
	private void executeControllerTest() {
		PrimeResponse aPrimeResponseType = aPrimeController.getPrimeNumbersXml("10", "BRUTE_FORCE");
		assertNotNull(aPrimeResponseType);
		assertTrue(aPrimeResponseType instanceof PrimeResponseXml);
		assertNull(aPrimeResponseType.getError());
		assertEquals("10", aPrimeResponseType.getInitial());
		assertEquals("2,3,5,7", aPrimeResponseType.getPrimes());
	
	}
	
	@Test
	public void testWithValidParameters() {
		executeControllerTest();
	}
	
	@Test
	public void testWithValidParametersLoadTest() {
		List<Future<?>> futures = new ArrayList<Future<?>>();
		
		for ( int threadMark = 0 ; threadMark < NUMBER_OF_CONCURRENT_RUNS ; threadMark++ ) {
			Future<?> future = executor.submit(() -> executeControllerTest());
			futures.add(future);
		}
		
		try {
			futures.stream().map(f -> {
				try {
					return f.get();
				} catch (InterruptedException | ExecutionException anException) {
					fail("Test Failed");
					anException.printStackTrace();
				}
				return null;
			}).allMatch(Objects::nonNull);
		} catch ( Exception anException) {
			fail("Test Failed");
			anException.printStackTrace();
		}
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
