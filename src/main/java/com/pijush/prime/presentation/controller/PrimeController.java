/**
 * 
 */
package com.pijush.prime.presentation.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.constants.PrimeGenerationAlgo;
import com.pijush.prime.common.vo.ErrorCodeWrapper;
import com.pijush.prime.common.vo.PrimeResponseType;
import com.pijush.prime.factory.PrimeGenerationServiceFactory;
import com.pijush.prime.factory.ResponseGenerationFactory;
import com.pijush.prime.service.primegeneration.PrimeGenerationService;
import com.pijush.prime.service.validationservice.ValidationService;

/**
 * Use this controller as the entry point to the prime number generator API.
 * This controller will give the prime number array back to the user.
 * 
 * @author Pijush Kanti Das
 *
 */


@Controller
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrimeController implements Constants {

	@Autowired
	private ValidationService aValidationService;

	@Autowired
	private PrimeGenerationServiceFactory aPrimeGenerationServiceFactory;

	@Autowired
	private ResponseGenerationFactory aResponseGenerationFactory;

	
	@ResponseBody
	@GetMapping(value = "/redirected/{mediaTypeHeader}/{anIntegerString}/{algorithm}", produces = MediaType.APPLICATION_JSON_VALUE )
	public PrimeResponseType getResponseForInValidHeader(final @PathVariable("anIntegerString") String anIntegerString,
										        final @PathVariable("algorithm") String algorithm,
										        final @PathVariable("mediaTypeHeader") String mediaTypeHeader) {
		return calculate(anIntegerString, mediaTypeHeader, algorithm);
	}
	
	@ResponseBody
	@GetMapping(value = "/redirected/xml/{anIntegerString}/{algorithm}", produces = MediaType.APPLICATION_XML_VALUE )
	public PrimeResponseType getPrimeNumbersXml(final @PathVariable("anIntegerString") String anIntegerString,
										        final @PathVariable("algorithm") String algorithm) {
		return calculate(anIntegerString, XML, algorithm);
	}
	
	@ResponseBody
	@GetMapping(value = "/redirected/json/{anIntegerString}/{algorithm}", produces = MediaType.APPLICATION_JSON_VALUE )
	public PrimeResponseType getPrimeNumbersJson(final @PathVariable("anIntegerString") String anIntegerString,
	        								     final @PathVariable("algorithm") String algorithm) {
		return calculate(anIntegerString, JSON, algorithm);
	}
	
	private PrimeResponseType calculate(final String anIntegerString,
										final String mediaTypeHeader,
										final String algorithm) {
		
		PrimeResponseType aPrimeResponseType = aResponseGenerationFactory.buildPrimeResponseTypeFromResponseTypeChoice(mediaTypeHeader);
	
		
		ErrorCodeWrapper inputValidationResult = aValidationService.isValidInput(anIntegerString);
		ErrorCodeWrapper httpHeaderValidationResult = aValidationService.isValidHttpHeader(mediaTypeHeader);

		PrimeGenerationService aPrimeGenerationService = aPrimeGenerationServiceFactory
				.getPrimeGenerationServiceFromAlgo(PrimeGenerationAlgo.getPrimeAlgoFromRequestParam(algorithm));

		
		if ( !inputValidationResult.isValidInput()) {
			aPrimeResponseType.setError(inputValidationResult.getErrorCode());
			return aPrimeResponseType;
		}
		
		if ( !httpHeaderValidationResult.isValidInput()) {
			aPrimeResponseType.setError(httpHeaderValidationResult.getErrorCode());
			return aPrimeResponseType;
		}
		
		
		aPrimeResponseType.setInitial(anIntegerString);
		aPrimeResponseType
				.setPrimes(String.join(COMMA, 
						 aPrimeGenerationService
						.loadPrimeFromCache(Integer.parseInt(anIntegerString))
						.stream()
						.map(String::valueOf)
						.collect(Collectors.toList())));
		return aPrimeResponseType;
		
	}
	

}
