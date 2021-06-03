package com.pijush.prime.integrationtest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.vo.PrimeResponseJson;
import com.pijush.prime.common.vo.PrimeResponseType;
import com.pijush.prime.common.vo.jaxb.PrimeResponseXml;
import com.pijush.prime.presentation.controller.PrimeController;



@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimeApplicationIntegrationTest implements Constants {

	@Autowired
	PrimeController aPrimeController;
	
	@Test
	public void testWithValidParameters() {
		PrimeResponseType aPrimeResponseType = aPrimeController.getPrimeNumbers("10", "XML", "BRUTE_FORCE");
		assertNotNull(aPrimeResponseType);
		assertTrue(aPrimeResponseType instanceof PrimeResponseXml);
		assertNull(aPrimeResponseType.getError());
		assertEquals("10", aPrimeResponseType.getInitial());
		assertEquals("2,3,5,7", aPrimeResponseType.getPrimes());
	}
	
	@Test
	public void testWithValidParametersJson() {
		PrimeResponseType aPrimeResponseType = aPrimeController.getPrimeNumbers("10", "JSON", "BRUTE_FORCE");
		assertNotNull(aPrimeResponseType);
		assertTrue(aPrimeResponseType instanceof PrimeResponseJson);
		assertNull(aPrimeResponseType.getError());
		assertEquals("10", aPrimeResponseType.getInitial());
		assertEquals("2,3,5,7", aPrimeResponseType.getPrimes());
	}
	
	@Test
	public void testWithValidParametersJsonInvalidHttpHeader() {
		PrimeResponseType aPrimeResponseType = aPrimeController.getPrimeNumbers("10", "XLM", "BRUTE_FORCE");
		assertNotNull(aPrimeResponseType);
		assertTrue(aPrimeResponseType instanceof PrimeResponseJson);
		assertNotNull(aPrimeResponseType.getError());
		assertEquals(String.format(INVALID_HTTP_HEADER, "XLM"), aPrimeResponseType.getError());
	}
}
