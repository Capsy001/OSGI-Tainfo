package distancepublisher;

import java.util.HashMap;
import java.util.Map;





public class DistancePublishImplementation implements DistancePublish {

	

	@Override
	public int publishDistance(String origin, String dest) {
		
		HashMap<Trip, Integer> distance = new HashMap<Trip, Integer>();
		distance.put(new Trip("Kandy", "Colombo"), 75);
		distance.put(new Trip("Kandy", "Kurunegala"), 50);
		distance.put(new Trip("Colombo", "Kurunegala"), 100);
		distance.put(new Trip("Colombo", "Kandy"), 75);
		distance.put(new Trip("Kurunegala", "Colombo"), 100);
		distance.put(new Trip("Kurunegala", "Kandy"), 50);
		
		
		for (Map.Entry<Trip, Integer> set : distance.entrySet()) {

	           if(set.getKey().origin.equals(origin) && set.getKey().dest.equals(dest)) {
	        	   
	        	   return set.getValue();
	           }
				
	        
	       }
		
		return 0;
	}

}
