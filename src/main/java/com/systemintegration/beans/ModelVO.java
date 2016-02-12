package com.systemintegration.beans;



/*	import java.io.FileWriter;
	import java.io.IOException;

	import java.util.Collections;
	import java.util.Observable;
	*/
	import java.util.ArrayList;
import java.util.Collections;
import java.util.List;







import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import com.google.gson.Gson;
import com.systemintegration.utils.Functions;
import com.systemintegration.utils.Enums.Flugzeug_Zustand;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;

	
	//import Utils.Functions;

	public class ModelVO {
		public static ArrayList<Flug> _Data = new ArrayList<Flug>();
		
		Resource resource;

		
		public List<Flug> getData() {
			return Collections.unmodifiableList(_Data);
		}
		
		
		/**
		 * Save data in a json file
		 * @return success flag
		 */
		public boolean SaveInFile(ArrayList<Flug> f){
			Gson gson = new Gson();
		    Type type = new TypeToken<ArrayList<Flug>>() {}.getType();
		    String json = gson.toJson(f, type);
		    boolean success = false;
			
			try {
				FileWriter file = new FileWriter("Brand.json");
				file.write(json);
				file.flush();
				file.close();
				success = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return success;
		}
		
		@SuppressWarnings("resource")
		public String readpass(){
			BufferedReader fluxEntree = null;
			try {
				fluxEntree = new BufferedReader(new FileReader(getClass().getResource("/passwort.txt").getFile()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					 String ligne = null;
					try {
						ligne = fluxEntree.readLine( );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			return ligne;
			
		}
		/**
		 * Read data from a json file
		 * @return success flag
		 */
		public boolean ReadFile() {
		
			boolean success = false;
		    
			try {
				//List<String> lines = Files.readAllLines(Paths.get("data.json"), Charset.defaultCharset());
				
				InputStream ips=new FileInputStream(getClass().getResource("/data.json").getFile()); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String s;
				while ((s=br.readLine())!=null){
				
					if (s.length()>1)
					_Data.add(Functions.rem(s));
					//json = json + s;
				}
		
			
				success = true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return success;
		}
		
		
		public Resource getResource() {
			return resource;
		}


		public void setResource(Resource resource) {
			this.resource = resource;
		}


		public static Flugzeug_Zustand Flugzustand(Flug f){
				if (f.getCodes().getQuawk().equals("7500")|| f.getCodes().getQuawk().equals("7600") ||f.getCodes().getQuawk().equals("7700")){
					return Flugzeug_Zustand.notfall;
				}
				else{
					if(f.getCodes().getLatitude()==52.2732 && f.getCodes().getLongitude()==13.056){
						// Es ist im Land Brandenburg, also speichern
						return Flugzeug_Zustand.normal;
					}
					else return Flugzeug_Zustand.ziel;
					
				}
			
		}
	
		public static List<String> listFlightCode(ArrayList<Flug> f){
			List<String> fl=new ArrayList<String>();
			for (Flug i: f) fl.add(i.getFlightcode());
			return fl;
			
		}

}
