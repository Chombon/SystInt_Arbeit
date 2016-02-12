/**
 * 
 */
package com.systemintegration.projekt;

import static org.junit.Assert.*;

import org.junit.Test;

import com.systemintegration.beans.CodeVO;
import com.systemintegration.beans.Flug;
import com.systemintegration.beans.ModelVO;
import com.systemintegration.utils.Enums.Flugzeug_Zustand;

/**
 * @author OUMBE
 *
 */
public class TestZustand {

	@Test
	public void test() {
		ModelVO JUnit=new ModelVO();
		CodeVO c=new CodeVO("",49.6227,11.1887,106,45000,512,"7500","F-EDDE1","GLF5","GLF5",0);
		Flug f=new Flug("8377226",c);
		Flugzeug_Zustand result=JUnit.Flugzustand(f);
		assertEquals(Flugzeug_Zustand.notfall,result);
		
	}

}
