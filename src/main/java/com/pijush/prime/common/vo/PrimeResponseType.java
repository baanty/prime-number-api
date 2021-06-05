package com.pijush.prime.common.vo;

/**
 * Use this interface to abstract the response type. It can JSON
 * or XML or text or anything. It is determined by an incoming http 
 * header.
 * 
 * @author Pijush Kanti Das
 *
 */
public interface PrimeResponseType {
	
	
	public String getInitial() ;
	public void setInitial(String initial) ;
	public String getPrimes() ;
	public void setPrimes(String primes) ;
	public String getError() ;
	public void setError(String error) ;
	public String getMediaType();
	
}
