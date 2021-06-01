package com.pijush.prime.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.vo.ErrorCodeWrapper;

/**
 * Use this service to validate the input. 
 * In our case we have a simple input. But If the input is a complicated 
 * POJO, then this validation can be handy.
 * 
 * @author Pijush Kanti Das
 *
 */
@Service
public class ValidationService implements Constants {

	/**
	 * Use this method to validate the input String.
	 * 
	 * @param input : The input String from User. This validation will check two 
	 * conditions of the input.
	 * 
	 * 1) If the input is not null.
	 * 2) If the Input is a valid integer.
	 * 
	 * @return : Return a <code>ErrorCodeWrapper</code> object.
	 * 
	 */
	public ErrorCodeWrapper isValidInput(final String input) {
		
		ErrorCodeWrapper anErrorCodeWrapper = new ErrorCodeWrapper(null, true);
		
		if ( StringUtils.isEmpty(input) ) {
			anErrorCodeWrapper.setErrorCode(NULL_INPUT);
			anErrorCodeWrapper.setValidInput(false);
		} 
		
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException aNumberFormatException) {
			anErrorCodeWrapper.setErrorCode(NULL_INPUT);
			anErrorCodeWrapper.setValidInput(false);
		}

		
		return anErrorCodeWrapper;
	}
}
