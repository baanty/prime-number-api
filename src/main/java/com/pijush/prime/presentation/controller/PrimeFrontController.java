/**
 * 
 */
package com.pijush.prime.presentation.controller;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pijush.prime.common.constants.Constants;

/**
 * Use this controller as the entry point to the prime number generator API.
 * This controller will give the prime number array back to the user.
 * 
 * @author Pijush Kanti Das
 *
 */

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Controller
public class PrimeFrontController implements Constants {

	@GetMapping(value = "/{anIntegerString}")
	public ModelAndView getPrimeNumbersFrontController(
			final @PathVariable("anIntegerString") String anIntegerString,
			final @RequestHeader(name = "media-type", required = false, defaultValue = "json" ) String mediaTypeHeader,
			final @RequestParam( name = "algorithm", required = false, defaultValue = "BRUTE_FORCE" ) String algorithm
			) {
		return new ModelAndView(REDIRECTOR + mediaTypeHeader + FRONT_SLASH + anIntegerString + FRONT_SLASH + algorithm );
		
	}
}
