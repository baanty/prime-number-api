package com.pijush.prime.integrationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
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

@Ignore
@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimeApplicationIntegrationTestWithRestCallLoadTest implements Constants {

	@Autowired
	RestTemplate aRestTemplate;

	private static final int NUMBER_OF_CONCURRENT_CALLS = 1000;

	@Test
	public void testWithValidParametersWithJsonOutPut() {
		int callIndex = 1;

		while (callIndex <= NUMBER_OF_CONCURRENT_CALLS) {
			loadExecute();
			callIndex++;
		}
	}

	private void loadExecute() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("media-type", JSON);
		headers.add("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<PrimeResponseJson> response = aRestTemplate.exchange("http://localhost:8080/primes/10",
				HttpMethod.GET, entity, PrimeResponseJson.class);
		assertNotNull(response);
		PrimeResponseJson aPrimeResponseJson = response.getBody();
		assertNotNull(aPrimeResponseJson);
		assertNull(aPrimeResponseJson.getError());
		assertEquals("10", aPrimeResponseJson.getInitial());
		assertEquals("2,3,5,7", aPrimeResponseJson.getPrimes());
	}

}
