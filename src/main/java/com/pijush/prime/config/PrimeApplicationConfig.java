package com.pijush.prime.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pijush.prime.common.vo.PrimeNumberCache;

/**
 * Use this class to do normal application configuration for the
 * <code>PrimeApplication</code> related Code.
 * 
 * @author Pijush Kanti Das
 *
 */
@Configuration
public class PrimeApplicationConfig {

	@Bean
	public PrimeNumberCache buildApplicationCache() {
		return new PrimeNumberCache();
	}
}
