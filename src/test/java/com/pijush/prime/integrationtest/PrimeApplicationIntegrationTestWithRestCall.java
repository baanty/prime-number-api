package com.pijush.prime.integrationtest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.vo.PrimeResponseJson;
import com.pijush.prime.common.vo.jaxb.PrimeResponseXml;



@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimeApplicationIntegrationTestWithRestCall implements Constants {

	@Autowired
	RestTemplate aRestTemplate;
	
	@Test
	public void testWithValidParametersWithJsonOutPut() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("media-type", JSON);
		headers.add("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<PrimeResponseJson>  response = aRestTemplate.exchange("http://localhost:8080/primes/10", HttpMethod.GET, entity, PrimeResponseJson.class);
		assertNotNull(response);
		PrimeResponseJson aPrimeResponseJson = response.getBody();
		assertNotNull(aPrimeResponseJson);
		assertNull(aPrimeResponseJson.getError());
		assertEquals("10", aPrimeResponseJson.getInitial());
		assertEquals( "2,3,5,7", aPrimeResponseJson.getPrimes());
	}
	
	@Test
	public void testWithValidParametersWithXmlOutPut() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("media-type", XML);
		headers.add("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<PrimeResponseXml>  response = aRestTemplate.exchange("http://localhost:8080/primes/10", HttpMethod.GET, entity, PrimeResponseXml.class);
		assertNotNull(response);
		PrimeResponseXml aPrimeResponseXml = response.getBody();
		assertNotNull(aPrimeResponseXml);
		assertNull(aPrimeResponseXml.getError());
		assertEquals("10", aPrimeResponseXml.getInitial());
		assertEquals( "2,3,5,7", aPrimeResponseXml.getPrimes());
	}
}
