package com.pijush.prime.factory;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.vo.PrimeResponseJson;
import com.pijush.prime.common.vo.PrimeResponseType;
import com.pijush.prime.common.vo.jaxb.PrimeResponseXml;

/**
 * Use this service to determine what kind of output 
 * format is expected.
 * 
 * @author Pijush Kanti Das
 *
 */

@Service
public class ResponseGenerationFactory implements Constants {

	/** 
	 * Use this method to get a concrete implementation instance of 
	 * the abstracted return type from  <code>PrimeResponseType</code>
	 * @param mediaType
	 * @return
	 */
	public PrimeResponseType buildPrimeResponseTypeFromResponseTypeChoice(final String mediaType) {
		
		if ( StringUtils.isEmpty(mediaType) || !mediaType.equalsIgnoreCase(XML)  ) {
			return new PrimeResponseJson();
		} else {
			return new PrimeResponseXml();
		}
	}
	
}
