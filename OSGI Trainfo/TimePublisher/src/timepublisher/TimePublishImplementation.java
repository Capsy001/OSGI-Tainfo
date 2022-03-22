package timepublisher;

import org.osgi.framework.ServiceReference;

import models.Train;

public class TimePublishImplementation implements TimePublish{

	@Override
	public void publishTime(int distance, Train train) {
		// TODO Auto-generated method stub
		
		double time=0;
		
		
		if(train.getType()=='E') {
			
			time = distance/80;
		}else if(train.getType()=='N') {
			
			time = distance/45;
		}else if(train.getType()=='S') {
			
			time = distance/25;
		}
		
		System.out.println("\nAverage time for this trip is: "+time+" hours\n");
		
		
	}

	

}
