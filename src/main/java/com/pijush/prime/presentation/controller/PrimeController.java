/**
 * 
 */
package com.pijush.prime.presentation.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.pijush.prime.common.vo.Constants;
import com.pijush.prime.common.vo.PrimeJsonResponse;
import com.pijush.prime.common.vo.PrimeResponseMarker;
import com.pijush.prime.common.vo.jaxb.PrimeResponse;

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

	@GetMapping(value = "/{input}" , produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE })
	public PrimeResponseMarker getPrimeNumbersInJsonormat(final @PathVariable String anIntegerString,
														  final @RequestParam("mediaType") String mediaType) {
		PrimeJsonResponse aPrimeJsonResponse = new PrimeJsonResponse();
		
		if ( StringUtils.isEmpty(mediaType) || mediaType.equalsIgnoreCase(JSON) ) {
			return aPrimeJsonResponse;
		} else if ( mediaType.equalsIgnoreCase(XML) ) {
			PrimeResponse aPrimeResponseForXml = new PrimeResponse();
			return aPrimeResponseForXml;
		}
		return aPrimeJsonResponse;
	}
}
