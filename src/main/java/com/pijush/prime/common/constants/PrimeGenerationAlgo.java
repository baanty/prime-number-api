package com.pijush.prime.common.constants;

/**
 * Use this enum to decide 
 * prime numbers generation strategy.
 * 
 * @author Pijush Kanti Das
 *
 */
public enum PrimeGenerationAlgo {

	BRUTE_FORCE,/* Test if all the numbers are divisable 
	 			   by numbers from 2 till the number.*/
	ERATOSTHENES_SIEVE, /* Use Eratosthenes sieve algorythm. */
	;
}
