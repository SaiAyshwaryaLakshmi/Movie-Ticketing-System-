package org.projects.ThaliaUtility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.projects.Thalia.Donations;
import org.projects.Thalia.OrdersSectionReceipt;
import org.projects.Thalia.Report;
import org.projects.Thalia.Shows;
import org.projects.Thalia.TheatreSection;
import org.projects.Thalia.Tickets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

 
public class UtilityDataStore {

	public static Map<String,Shows> showsMap = new HashMap<String,Shows>();
	public static Map<String,TheatreSection> theatreSectionMap = new HashMap<String,TheatreSection>();
	public static Map<String,OrdersSectionReceipt> ordersSectionReceiptMap = new HashMap<String,OrdersSectionReceipt>();
	public static Map<String, Donations> donationsMap = new HashMap<String,Donations>();
	public static Map<String,Tickets> ticketsMap = new HashMap<String,Tickets>();
	public static List<String> subscriptionList = new ArrayList<String>();
	public static Map<String,Report> reportsMap = new HashMap<String,Report>();
    public static Map<String,String>responseMap = new HashMap<String,String>();
	
	 
	public static void initializeReportsMap()
	{
		if(UtilityDataStore.reportsMap.size()<1)
		{
		String[] reportNames = {"Theatre occupancy","Revenue from ticket sales","Donated tickets report"};
		for(String s :reportNames)
		{
			Report report = new Report();
			report.setMrid(UniqueIdGenerator.getReportId().toString());
			report.setName(s);
			report.setDonatedAndUsedTickets((long) 0);
			report.setDonatedAndUsedValue((long) 0);
			report.setDonatedTickets((long) 0);
			report.setSoldSeats((long) 0);
			report.setTotalSeats((long) 0);
			report.setOverallRevenue((long) 0);
			reportsMap.put(report.getMrid(), report);
		}
		}
	} 
	
	public static void initializeTheatreSection()
	{
		if(UtilityDataStore.theatreSectionMap.size()<1)
		{
		String json = null;
		try {
			File test = new File("./");
			ClassLoader classLoader = UtilityDataStore.class.getClassLoader();
			json = FileUtils.readFileToString(
					new File(classLoader.getResource("Theatre.JSON").getFile()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.lang.reflect.Type listType = new TypeToken<ArrayList<TheatreSection>>() {
		}.getType();
		Gson gson = new Gson();
		List<TheatreSection> theatreSectionList = gson.fromJson(json, listType);
	
		for (TheatreSection t : theatreSectionList) {
			t.setSid(UniqueIdGenerator.getUniqueID().toString());
			UtilityDataStore.theatreSectionMap.put(t.getSid(), t);
		}
	}
	
	}
}
