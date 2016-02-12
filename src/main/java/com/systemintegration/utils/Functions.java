package com.systemintegration.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.systemintegration.beans.CodeVO;
import com.systemintegration.beans.Flug;



public class Functions {
	
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String convertirDateToString(Date date){	
		return formatter.format(date);
	}
	
	
	public static Date convertirStringToDate(String s) throws ParseException {
		Date date=null;	
		date = formatter.parse(s);
		return date;
	}
	
	public static double Runden(double tonDouble){
		double d = (double) Math.round(tonDouble * 100) / 100;
		return d;
	}
	
	/**
	 * Shows an error message dialog
	 * @param message
	 */
	public static void ShowError(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Shows an information message dialog
	 * @param message
	 */
	public static void ShowInformation(String msg){
		JOptionPane.showMessageDialog(null, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Ausfüllung _Data
	public static Flug rem(String s){
		s=s.replace('"',' ');
		s=s.replaceAll(" ","");
		
		String[] sl=s.split(":");
		String e1=sl[0],e2=sl[1];
		if (e1.indexOf("\\{")!=-1) e1=e1.replaceAll("{", "");
		if (e1.indexOf(",")!=-1) e1=e1.replaceAll(",", "");
		e2=e2.replaceAll("\\[", "");
		e2=e2.replaceAll("\\]", "");
		String[] cod= e2.split(",");
		CodeVO c =new CodeVO(cod[0],Double.parseDouble(cod[1]),Double.parseDouble(cod[2]),Integer.parseInt(cod[3]),
				Integer.parseInt(cod[4]),Float.parseFloat(cod[5]),cod[6],
				cod[7],cod[8],cod[16],Integer.parseInt(cod[17]));
		Flug f=new Flug(e1,c);
		
		return f;
		
	}
	

		
	
}
