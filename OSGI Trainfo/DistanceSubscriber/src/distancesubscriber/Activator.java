package distancesubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import distancepublisher.DistancePublish;
import models.Train;
import trainidpublisher.TrainIDPublish;


public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	ServiceReference serviceReference2;

	public void start(BundleContext context) throws Exception {
		System.out.println("Distance subscriber service started!");
		
		//distance service
		serviceReference = context.getServiceReference(DistancePublish.class.getName());
		DistancePublish distancePublish = (DistancePublish)context.getService(serviceReference);
		
		//trainid service
		serviceReference2 = context.getServiceReference(TrainIDPublish.class.getName());
		TrainIDPublish trainIDPublish = (TrainIDPublish) context.getService(serviceReference2);
		
		Scanner input= new Scanner(System.in);
		
		///
		char more= 'y';
		
		while(more!='n' && more!='N') {
			
			System.out.println("\nEnter the trainID to get distance: ");
			int tid= input.nextInt();
			
			Train matchedTrain = trainIDPublish.publishTrain(tid);
			
			if(matchedTrain!=null) {
				System.out.println("Distance for your trip is : "+distancePublish.publishDistance(matchedTrain.getOrigin(), matchedTrain.getDest())+ " Km");
			}else {
				System.out.println("Invalid ID!\n");
			}
			
			
			
			System.out.println("Are there any other distnace checks? (y-yes, n-No): ");
			more = input.next().charAt(0);
		
		}
		
		///
		
	}

	public void stop(BundleContext context) throws Exception {
		
		
		System.out.println("Distance subscriber is Stopping!");
		context.ungetService(serviceReference);
	}

}
