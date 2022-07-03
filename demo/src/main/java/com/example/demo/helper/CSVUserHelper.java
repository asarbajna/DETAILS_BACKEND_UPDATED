package com.example.demo.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

//import com.example.demo.entity.Tutorial;
import com.example.demo.model.UserRegistrationModel;

public class CSVUserHelper {
	  public static String TYPE = "text/csv";
	  static String[] HEADERs = { "userId","email", "firstName", "lastName" };
	  public static boolean hasCSVFormat(MultipartFile file) {
	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }
	    return true;
	  }
	  public static List<UserRegistrationModel> csvToTutorials(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
	      List<UserRegistrationModel> userInfo = new ArrayList<UserRegistrationModel>();
	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      System.out.println("csv record: "+csvRecords);
	      
	      for (CSVRecord csvRecord : csvRecords) {
	    	  System.out.println("this is for loop"+csvRecord.get("email"));
	    	  //System.out.println("this is for loop"+csvRecord.get("userId"));
	    	  /*   UserRegistrationModel user = new UserRegistrationModel(
	             (long) Long.parseLong(csvRecord.get("userId")),
	              csvRecord.get("email"),
	              csvRecord.get("firstName"),
	              csvRecord.get("lastName")
	    		207,"abc662@mail.com","sankho2","mukh2"
	            );*/
	    	  UserRegistrationModel user = new UserRegistrationModel(null,
	    			  csvRecord.get("email"),
		              csvRecord.get("firstName"),
		              csvRecord.get("lastName")
	    			  );
	    	  System.out.println("user: "+user);
	        userInfo.add(user);
	      }
	      return userInfo;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
	}


