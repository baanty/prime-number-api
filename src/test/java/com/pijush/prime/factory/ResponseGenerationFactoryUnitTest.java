package com.pijush.prime.factory;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.pijush.prime.common.vo.PrimeResponseJson;
import com.pijush.prime.common.vo.PrimeResponseType;
import com.pijush.prime.common.vo.jaxb.PrimeResponseXml;

@RunWith(MockitoJUnitRunner.class) 
public class ResponseGenerationFactoryUnitTest {


	@InjectMocks
	ResponseGenerationFactory aFactory ;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);		
	}
	
	
	@Test
	public void testXmlResponse() {
		PrimeResponseType aPrimeResponseType = aFactory.buildPrimeResponseTypeFromResponseTypeChoice("XML");
		assertTrue(aPrimeResponseType instanceof PrimeResponseXml);
	}
	
	
	@Test
	public void testJsonResponse() {
		PrimeResponseType aPrimeResponseType = aFactory.buildPrimeResponseTypeFromResponseTypeChoice("JSON");
		assertTrue(aPrimeResponseType instanceof PrimeResponseJson);
	}

}
