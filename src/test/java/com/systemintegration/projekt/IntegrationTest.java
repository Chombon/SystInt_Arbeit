/**
 * 
 */
package com.systemintegration.projekt;

import static org.junit.Assert.*;
import groovy.lang.Category;

import org.junit.BeforeClass;
import org.junit.Test;

import com.systemintegration.beans.CodeVO;
import com.systemintegration.beans.Flug;

/**
 * @author OUMBE
 *
 */
@Category(TestIntCodInFlug.class)
public class IntegrationTest {

		private static CodeVO code;
		private static Flug flug;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		code=new CodeVO("",49.6227,11.1887,106,45000,512,"7500","F-EDDE1","GLF5","GLF5",0);
		 flug=new Flug("8377226",code);
	}

	@Test
	public void testAssertEquals() {
		assertEquals(flug.getCodes(),code);
	}

	@Test
	public void testAssertEqualsWithMessage() {
		flug.setCodes(code);
		assertEquals("Same Flight",flug.getCodes(),code);
		
	}


}
