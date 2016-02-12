/**
 * 
 */
package com.systemintegration.projekt;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.systemintegration.beans.CodeVO;
import com.systemintegration.beans.Flug;
import com.systemintegration.beans.ModelVO;

/**
 * @author OUMBE
 *
 */
public class TestReadFile {

	@Test
	public void Rtest() {
		ModelVO m=new ModelVO();
		boolean result=m.ReadFile();
		assertEquals(true,result);
	}
	
	@Test
	public void Stest() {
		ModelVO m=new ModelVO();
		CodeVO c=new CodeVO("",49.6227,11.1887,106,45000,512,"7500","F-EDDE1","GLF5","GLF5",0);
		Flug f=new Flug("8377226",c);
		ArrayList<Flug> l=new ArrayList<Flug>();
		l.add(f);
;		boolean result=m.SaveInFile(l);
		assertEquals(true,result);
	}

}
