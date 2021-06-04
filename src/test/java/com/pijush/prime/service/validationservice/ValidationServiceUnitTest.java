package com.pijush.prime.service.validationservice;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.pijush.prime.common.constants.Constants;
import com.pijush.prime.common.vo.ErrorCodeWrapper;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class ValidationServiceUnitTest implements Constants {


	@InjectMocks
	ValidationService aService ;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);		
	}
	
	
	@Test
	public void testValidHttpHeader() {
		ErrorCodeWrapper anErrorCodeWrapper = aService.isValidHttpHeader("XML");
		assertNotNull(anErrorCodeWrapper);
		assertTrue(anErrorCodeWrapper.isValidInput());
		assertNull(anErrorCodeWrapper.getErrorCode());
	}
	
	@Test
	public void testInValidHttpHeader() {
		ErrorCodeWrapper anErrorCodeWrapper = aService.isValidHttpHeader("AHJGGJKHKJHKJ");
		assertNotNull(anErrorCodeWrapper);
		assertFalse(anErrorCodeWrapper.isValidInput());
		assertEquals(String.format(INVALID_HTTP_HEADER, "AHJGGJKHKJHKJ"), anErrorCodeWrapper.getErrorCode());
	}
	
	@Test
	public void testValidInput() {
		ErrorCodeWrapper anErrorCodeWrapper = aService.isValidInput("87");
		assertNotNull(anErrorCodeWrapper);
		assertTrue(anErrorCodeWrapper.isValidInput());
		assertNull(anErrorCodeWrapper.getErrorCode());
	}
	@Test
	public void testNullnput() {
		ErrorCodeWrapper anErrorCodeWrapper = aService.isValidInput(null);
		assertNotNull(anErrorCodeWrapper);
		assertFalse(anErrorCodeWrapper.isValidInput());
		assertEquals(NULL_INPUT, anErrorCodeWrapper.getErrorCode());
	}
	
	@Test
	public void testInValidInput() {
		ErrorCodeWrapper anErrorCodeWrapper = aService.isValidInput("YIUY");
		assertNotNull(anErrorCodeWrapper);
		assertFalse(anErrorCodeWrapper.isValidInput());
		assertEquals(INVALID_INTEGER, anErrorCodeWrapper.getErrorCode());
	}

}
