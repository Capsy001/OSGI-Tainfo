package costpublisher;

import models.Train;

public class CostPublishImplementation implements CostPublish {

	@Override
	public double publishCost(Train train, int cls) {
		
		double cost=20;
		
		if (new String(train.getFacility()).contains("A")) {

			cost+=5;
			
		}
		
		if (new String(train.getFacility()).contains("B")) {

			cost+=10;
			
		}
		
		if (new String(train.getFacility()).contains("C")) {

			cost+=15;
			
		}
		
		if (train.getType()=='E') {

			cost*=3;
			
		}
		
		if (train.getType()=='N') {

			cost*=2;
			
		}
		
		if (cls==1) {

			cost*=3;
			
		}
		
		if (cls==2) {

			cost*=2;
			
		}
		
		
		
		return cost;
	}

}
