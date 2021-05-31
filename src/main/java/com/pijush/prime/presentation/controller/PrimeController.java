/**
 * 
 */
package com.pijush.prime.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.pijush.prime.common.vo.PrimeJsonRequest;
import com.pijush.prime.common.vo.PrimeJsonResponse;

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

	public PrimeJsonResponse getPrimeNumbersInJsonormat(final @RequestBody PrimeJsonRequest aPrimeJsonRequest) {
		PrimeJsonResponse aPrimeJsonResponse = new PrimeJsonResponse();
		return aPrimeJsonResponse;
	}
}
