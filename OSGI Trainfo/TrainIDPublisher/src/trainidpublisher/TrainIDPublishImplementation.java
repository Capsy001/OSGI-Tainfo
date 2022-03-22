package trainidpublisher;

import java.util.HashMap;
import java.util.Map;

import models.Train;



public class TrainIDPublishImplementation implements TrainIDPublish {

	
	//Train(int tID, char[] facility, char crowd, String origin, String dest, char type)
	
	public static HashMap<Integer, Train> trains = new HashMap<Integer, Train>();
	
	
	
	public TrainIDPublishImplementation() {
		
		trains.put(100, new Train(100, "ABC".toCharArray(), 'N', "Kandy", "Colombo", 'E'));
		trains.put(200, new Train(200, "AB".toCharArray(), 'C', "Kandy", "Kurunegala", 'S'));
		trains.put(300, new Train(300, "N".toCharArray(), 'N', "Colombo", "Kurunegala", 'N'));
		trains.put(400, new Train(400, "ABC".toCharArray(), 'N', "Colombo", "Kandy", 'S'));
		trains.put(500, new Train(500, "AB".toCharArray(), 'C', "Kurunegala", "Colombo", 'S'));
		trains.put(600, new Train(600, "N".toCharArray(), 'N', "Kurunegala", "Kandy", 'N'));
		
		
		
	}

	@Override
	public Train publishTID(String origin, String dest) {
		
		
		
		for (Map.Entry<Integer, Train> set : trains.entrySet()) {

           if(set.getValue().getOrigin().equalsIgnoreCase(origin) && set.getValue().getDest().equalsIgnoreCase(dest)) {
        	  
        	   
        	   return set.getValue();
           }
			
        
       }
		
		return null;
		
	}

	@Override
	public Train publishTrain(int tid) {
		
		for (Map.Entry<Integer, Train> set : trains.entrySet()) {

	           if(set.getKey()==tid) {
	        	   return set.getValue();
	           }
	       }
		
		return null;
		
		
	}

}
