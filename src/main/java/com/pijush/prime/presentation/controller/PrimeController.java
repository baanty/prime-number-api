/**
 * 
 */
package com.pijush.prime.presentation.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pijush.prime.common.vo.PrimeJsonRequest;
import com.pijush.prime.common.vo.PrimeJsonResponse;
import com.pijush.prime.common.vo.PrimeResponse;

/**
 * Use this controller as the entry point to the 
 * prime number generator API. This controller will give the 
 * prime number array back to the user. 
 * 
 * @author Pijush Kanti Das
 *
 */

@Controller
public class PrimeController {

	@GetMapping(value = "/{input}" , produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE })
	public PrimeResponse getPrimeNumbersInJsonormat(final @PathVariable String anIntegerString) {
		PrimeJsonResponse aPrimeJsonResponse = new PrimeJsonResponse();
		return aPrimeJsonResponse;
	}
}
