/**
 * 
 */
package com.pijush.prime.presentation.controller;

import java.math.BigInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.constants.PrimeGenerationAlgo;
import com.pijush.prime.common.vo.ErrorCodeWrapper;
import com.pijush.prime.common.vo.PrimeResponseJson;
import com.pijush.prime.common.vo.PrimeResponseType;
import com.pijush.prime.common.vo.jaxb.PrimeResponse;
import com.pijush.prime.service.PrimeGenerationService;
import com.pijush.prime.service.PrimeGenerationServiceFactory;
import com.pijush.prime.service.ValidationService;

/**
 * Use this controller as the entry point to the 
 * prime number generator API. This controller will give the 
 * prime number array back to the user. 
 * 
 * @author Pijush Kanti Das
 *
 */

@Controller
public class PrimeController implements Constants {
	
	@Autowired
	private ValidationService aValidationService;

	
	@Autowired
	private PrimeGenerationServiceFactory aPrimeGenerationServiceFactory;
	
	
	@GetMapping(value = "/{anIntegerString}" , produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public PrimeResponseType getPrimeNumbersInJsonFormat(final @PathVariable("anIntegerString") String anIntegerString,
														  final @RequestParam("mediaType") String mediaType) {
		PrimeResponseType aPrimeResponseType = null;
		ErrorCodeWrapper anErrorCodeWrapper = aValidationService.isValidInput(anIntegerString);
		
		PrimeGenerationService aPrimeGenerationService = aPrimeGenerationServiceFactory.getPrimeGenerationServiceFromAlgo(PrimeGenerationAlgo.BRUTE_FORCE);
		
		if ( StringUtils.isEmpty(mediaType) || mediaType.equalsIgnoreCase(JSON) ) {
			PrimeResponseJson aPrimeResponseJson = new PrimeResponseJson();
			
			if ( !anErrorCodeWrapper.isValidInput() ) {
				aPrimeResponseJson.setError(anErrorCodeWrapper.getErrorCode());
				return aPrimeResponseJson;
			}
			aPrimeResponseJson.setInitial(anIntegerString);
			aPrimeResponseJson.setPrimesTillInput(aPrimeGenerationService
													.generatePrimes(Integer.parseInt(anIntegerString))
													.stream()
													.map(String::valueOf)
													.collect(Collectors.toList()));
			return aPrimeResponseJson;
		} else if ( mediaType.equalsIgnoreCase(XML) ) {
			PrimeResponse aPrimeResponseXml = new PrimeResponse();
			
			if ( !anErrorCodeWrapper.isValidInput() ) {
				aPrimeResponseXml.setError(anErrorCodeWrapper.getErrorCode());
				return aPrimeResponseXml;
			}
			aPrimeResponseXml.setInitial(anIntegerString);
			aPrimeGenerationService
					.generatePrimes(Integer.parseInt(anIntegerString))
					.stream()
					.forEach(aPrime -> {
						aPrimeResponseXml.getPrimes().add(new BigInteger(String.valueOf(aPrime)));
					});
			return aPrimeResponseXml;
		}
		return aPrimeResponseType;
	}
	
}
