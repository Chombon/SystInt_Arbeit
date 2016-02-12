package com.systemintegration.projekt;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.mail.EmailException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;






//import com.systemeintegration.utils.Enums.Flugzeug_Zustand;


import com.systemintegration.beans.CodeVO;
import com.systemintegration.beans.Flug;
import com.systemintegration.beans.ModelVO;
import com.systemintegration.utils.Enums;
import com.systemintegration.utils.smtpTest;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("myRequestObject")
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws MessagingException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request, HttpSession session){
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		ModelVO m= new ModelVO(); 
		m.ReadFile();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		// Controle des Zustands der Flugzeuges
		ArrayList<Flug> ziele = new ArrayList<Flug>();
		ArrayList<Flug> dringend = new ArrayList<Flug>();
		ArrayList<Flug> inLB = new ArrayList<Flug>();
		int inc=0;
		String pass=null;
		for(Flug f: ModelVO._Data){
			switch( m.Flugzustand(f)){
			case notfall:  //Abschiken der E-Mail
											dringend.add(f);
											if (inc==0)  pass =m.readpass();
											model.addAttribute("dringend",dringend);
											try {
												smtpTest.sendMail(f.getFlightcode()+"- Code: "+f.getCodes().getQuawk(),pass);
											} catch (AddressException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (MessagingException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
											inc++;
											break;
			case normal:	// im Land brandenburg
											inLB.add(f);
											break;
											
			case ziel: 		// Abgabe der Ziels
											ziele.add(f);
											model.addAttribute("ziel",ziele);
											break;
		
			}
			
		}
		
		session.setAttribute("notfall",dringend );
		session.setAttribute("inLB",m.listFlightCode(inLB) );
		session.setAttribute("ziel",ziele);
		if (!inLB.isEmpty())
		m.SaveInFile(inLB);
		
		
		return "home";
	}
	
	
	
}
