package com.satkarta.pmsudha.dao;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.ConcurrentNavigableMap;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

//import org.mapdb.*; // i am going to use mapdb to persist data, since it will be in the scale of few thousand records max
 
import com.satkarta.pmsudha.formbean.AppUserForm;
import com.satkarta.pmsudha.model.AppUser;
import com.satkarta.pmsudha.model.City;
import com.satkarta.pmsudha.model.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class AppUserDAO {
 
    // Config in WebSecurityConfig
    @Autowired
    
    private static final Map<String, AppUser> USERS_MAP = new HashMap<>();
    //private static  HashMap<String, AppUser> mapdb = new HashMap<>();
    private static int headerFlag = 0;
    static {
        initDATA();
    }
 
    private static void initDATA() {

		/*
		 * DB db = DBMaker.fileDB("D:/membersList.db").make(); ConcurrentMap<String,
		 * String> map = (ConcurrentMap<String, String>)
		 * db.hashMap("map").createOrOpen(); map.put("something", "here"); db.close();
		 */
    }
 
    public Long getMaxUserId() {
        long max = 0;
        int id;
        for (String sId : USERS_MAP.keySet()) {
        	id = sId.lastIndexOf('Y') + 1;
        	System.out.println(id);
        	id = Integer.parseInt(sId.substring(id));
            if (id > max) {
                max = id;
            }
        }
        return max;
    }
 
    //
 
    public AppUser findAppUserByUserName(String firstName, String lastName, String mobileNo) {
        Collection<AppUser> appUsers = USERS_MAP.values();
        for (AppUser u : appUsers) {
        	if(u.getMobileNo().equalsIgnoreCase(mobileNo) && u.getFirstName().equals(firstName) && u.getLastName().equals(lastName)) {
                return u;
            }
        }
        return null;
    }
 
    public List<AppUser> getAppUsers() throws IOException {
    //public ArrayList<String> getAppUsers() throws IOException {
        List<AppUser> list = new ArrayList<>();
 
        //list.addAll(USERS_MAP.values());
		/*
		 * try { DB db = DBMaker.fileDB("D:/membersList.db").make(); HTreeMap<String,
		 * AppUser> mapdb = (HTreeMap<String, AppUser>) db.hashMap("members").open();
		 * list.addAll(mapdb.values()); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
        
        list = csvReader();
        //ArrayList<String> members = (ArrayList<String>) new ArrayList();
        //return members;
        list.remove(0);
        return list;
    }
 
    public AppUser createAppUser(AppUserForm form) throws IOException {
        Long userId = this.getMaxUserId() + 1;
        //CountryDAO country = new CountryDAO();
        Map<String, City> map = CountryDAO.CITIES_MAP;
        Map<String, State> map1 = CountryDAO.STATES_MAP;
        String cityName = (map.get(form.getCityCode()).getCityName());
        String stateName = (map1.get(form.getStateCode()).getStateName());
        //Since subscription is changed to String from Int due to the jackson API issue of deserialisation i need to treat it as integer only. Hence following extra line
        String userid = form.getCityCode() + Integer.parseInt(form.getSubscriptionPeriod()) + "Y" + userId;
        System.out.println("new app userID created is:" + userid);
        System.out.println("information from form:\n1. username:" + form.getFirstName()
        					+ "\n2. lastname: " + form.getLastName()
        					+ "\n3. mobileNo: " + form.getMobileNo()
        					+ "\n4. Address: " + form.getAddress()
        					+ "\n5. City: " + cityName
        					+ "\n6. State " + form.getStateCode()
        					+ "\n7. Subscription: " + form.getSubscriptionPeriod()
        							+ "\n8. CityCode: " + form.getCityCode());
        AppUser user = new AppUser(userid, form.getFirstName(), form.getLastName(),//
        		                   form.getMobileNo(), form.getAddress(), //
        		                   form.getCityCode(), cityName, form.getStateCode(), stateName, form.getInputZip(), //
        		                   form.getSubscriptionPeriod());
 
        USERS_MAP.put(userid, user);
        
        //File file = new File("WEB-INF/classes/members.csv");
        File file = null;
        try {
	        file = getFileFromResource("members.csv");
        } catch(Exception e) {
            e.printStackTrace();
        }
        // Create a File and append if it already exists.
        Writer writer = new FileWriter(file, true);
        //Reader reader = new FileReader(file);
        //Copy List of Map Object into CSV format at specified File location.
        csvWriter(userid, user, writer);
        //Read CSV format from specified File location and print on console..
		/*
		 * try { DB db =
		 * DBMaker.fileDB("D:/membersList.db").closeOnJvmShutdown().make();
		 * HTreeMap<String, AppUser> mapdb = (HTreeMap<String, AppUser>)
		 * db.hashMap("members").create(); mapdb.put(userid, user); db.commit(); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
    	//db.close();
    	
        return user;
    }
 
    private File getFileFromResource(String fileName) throws URISyntaxException {
	    ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }
  
    public static  void csvWriter(String userid, AppUser user, Writer writer) throws IOException {
    	
            CsvMapper mapper = new CsvMapper();
            
            //Class type = user.getClass();
            if(headerFlag == 0 ) {
            	CsvSchema schema = mapper.schemaFor(AppUser.class).withHeader() ;
            mapper.writer(schema).writeValues(writer).write(user);
            headerFlag=1;
            } else {
            	CsvSchema schema = mapper.schemaFor(AppUser.class); 
            	mapper.writer(schema).writeValues(writer).write(user);
            }
        
        writer.flush();

    }
    
    public List csvReader() throws IOException {
    	//File file = new File("WEB-INF/classes/members.csv");
	    File file = null;
        try {
	        file = getFileFromResource("members.csv");
        } catch(Exception e) {
            e.printStackTrace();
        }

        //Reader reader = new FileReader(file);
        
    	MappingIterator<AppUser> personIter = new CsvMapper().readerWithTypedSchemaFor(AppUser.class).readValues(file);
		return personIter.readAll();
    	//Iterator<ArrayList<String>> iterator = new CsvMapper().readerFor(ArrayList.class).with(CsvSchema.emptySchema()).readValues(reader);
    	
        //Iterator<Map<String, String>> iterator = new CsvMapper()
               // .readerFor(Map.class)
                //.with(CsvSchema.emptySchema().withHeader())
                //.readValues(reader);
		/*
		 * while (iterator.hasNext()) { //Map<String, String> keyVals = iterator.next();
		 * ArrayList<String> keyVals = iterator.next(); System.out.println(keyVals); }
		 */
    }
}
