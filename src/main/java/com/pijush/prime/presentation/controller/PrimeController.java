/**
 * 
 */
package com.pijush.prime.presentation.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.constants.PrimeGenerationAlgo;
import com.pijush.prime.common.vo.ErrorCodeWrapper;
import com.pijush.prime.common.vo.PrimeResponseType;
import com.pijush.prime.service.PrimeGenerationService;
import com.pijush.prime.service.PrimeGenerationServiceFactory;
import com.pijush.prime.service.ResponseGenerationFactory;
import com.pijush.prime.service.ValidationService;

/**
 * Use this controller as the entry point to the prime number generator API.
 * This controller will give the prime number array back to the user.
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

	@Autowired
	private ResponseGenerationFactory aResponseGenerationFactory;

	@GetMapping(value = "/{anIntegerString}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public PrimeResponseType getPrimeNumbersInJsonFormat(final @PathVariable("anIntegerString") String anIntegerString,
			final @RequestParam("mediaType") String mediaType) {
		PrimeResponseType aPrimeResponseType = aResponseGenerationFactory
				.buildPrimeResponseTypeFromResponseTypeChoice(mediaType);
		ErrorCodeWrapper anErrorCodeWrapper = aValidationService.isValidInput(anIntegerString);

		PrimeGenerationService aPrimeGenerationService = aPrimeGenerationServiceFactory
				.getPrimeGenerationServiceFromAlgo(PrimeGenerationAlgo.ERATOSTHENES_SIEVE);

		if (!anErrorCodeWrapper.isValidInput()) {
			aPrimeResponseType.setError(anErrorCodeWrapper.getErrorCode());
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
