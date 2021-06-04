/**
 * 
 */
package com.pijush.prime.common.vo;

import java.util.HashMap;
import java.util.List;

/**
 * Use this class to store prime numbers, which were already generated. This 
 * will increase heap memeory consumption. But it will reduce computational
 * cost.
 * 
 * @author Pijush Kanti Das
 * @param <V>
 *
 */
public class PrimeNumberCache extends HashMap<Integer, List<Integer>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1313880654533711253L;

}
