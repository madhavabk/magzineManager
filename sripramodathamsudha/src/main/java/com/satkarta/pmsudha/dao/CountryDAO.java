package com.satkarta.pmsudha.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.satkarta.pmsudha.model.City;
//import com.satkarta.pmsudha.model.City;
//import com.satkarta.pmsudha.model.Country;
import com.satkarta.pmsudha.model.State;

import org.springframework.stereotype.Repository;
 
@Repository
public class CountryDAO {
 
    //private static final Map<String, Country> COUNTRIES_MAP = new HashMap<>();
    static final Map<String, State> STATES_MAP = new HashMap<>();
    //private static final Map<String, City> CITIES_MAP = new HashMap<>();
    public static  Map<String, City> CITIES_MAP = new HashMap<>();
    //private static Map<String, String> CITIES_MAP = new HashMap<String, String>();
 
    static {
        initDATA();
    }
 
    private static void initDATA() {
 
		/*
		 * Country vn = new Country("KN", "Karnataka"); Country en = new Country("MH",
		 * "Maharastra"); Country fr = new Country("TN", "Tamil Nadu"); Country us = new
		 * Country("AP", "Andhra Pradesh"); Country ru = new Country("TN", "Telangana");
		 * 
		 * COUNTRIES_MAP.put(vn.getCountryCode(), vn);
		 * COUNTRIES_MAP.put(en.getCountryCode(), en);
		 * COUNTRIES_MAP.put(fr.getCountryCode(), fr);
		 * COUNTRIES_MAP.put(us.getCountryCode(), us);
		 * COUNTRIES_MAP.put(ru.getCountryCode(), ru);
		 */
        
		
		  Properties config = new Properties(); try {
		  config.load(CountryDAO.class.getResourceAsStream("/cities.properties"));
		  //exampl input stream
		  System.out.println("I am in initData of country");
		  //Map<String, String> CITIES_MAP = new HashMap<String, String>();
		  //City ct = new City();
		  for (final String name: config.stringPropertyNames()) {
			  //ct.setCityName(name);
			  //ct.setCityCode(config.getProperty(name));
			  CITIES_MAP.put(name, new City(name, config.getProperty(name)));
			  System.out.println("name:" + name);
			  System.out.println("code:" + config.getProperty(name));
		  }
		  
		  } catch(Exception e) { 
			  System.out.println(e); 
		  }
		 
        State ka = new State("KA", "Karnataka");
        STATES_MAP.put(ka.getStateCode(), ka);
        
    }
 
	/*
	 * public Country findCountryByCode(String countryCode) { return
	 * COUNTRIES_MAP.get(countryCode); }
	 * 
	 * public List<Country> getCountries() { List<Country> list = new ArrayList<>();
	 * list.addAll(COUNTRIES_MAP.values()); return list; }
	 */

	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> list = new ArrayList<>();
        list.addAll(STATES_MAP.values());
        return list;
	}
	
	public List<City> getCities() {
	//public List<String> getCities() {
		// TODO Auto-generated method stub
		List<City> list = new ArrayList<>();
		list.addAll(CITIES_MAP.values());
        return list;
	}
 
}