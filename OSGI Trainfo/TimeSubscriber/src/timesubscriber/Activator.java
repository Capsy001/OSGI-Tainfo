package timesubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import distancepublisher.DistancePublish;
import models.Train;
import timepublisher.TimePublish;
import trainidpublisher.TrainIDPublish;

public class Activator implements BundleActivator {


	ServiceReference timeReference;
	ServiceReference distanceReference;
	ServiceReference tidReference;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Time subscriber service started!");
		timeReference = context.getServiceReference(TimePublish.class.getName());
		TimePublish timePublish = (TimePublish)context.getService(timeReference);
		
		distanceReference = context.getServiceReference(DistancePublish.class.getName());
		DistancePublish distancePublish = (DistancePublish)context.getService(distanceReference);
		
		tidReference = context.getServiceReference(TrainIDPublish.class.getName());
		TrainIDPublish tidPublish = (TrainIDPublish)context.getService(tidReference);
		
		
		///
		Scanner input= new Scanner(System.in);
		
		char more= 'y';
		
		while(more!='n' && more!='N') {
			
		System.out.println("\nEnter the trip details to get average time!");
			
			
		System.out.println("\nEnter the Origin: ");
		String origin = input.next();
		
		System.out.println("Enter the Destination: ");
		String dest = input.next();
		
		Train matchedTrain = tidPublish.publishTID(origin, dest);
		
		if(matchedTrain!=null) {
			timePublish.publishTime(distancePublish.publishDistance(matchedTrain.getOrigin(), matchedTrain.getDest()), matchedTrain);
		
		}else {
			
			System.out.println("No Trains available for this Trip!\n");
		}
		
		
		
		System.out.println("Are there any other trips (y-yes, n-No): ");
		more = input.next().charAt(0);
		
		}
		///
		
		
		
	}

	public void stop(BundleContext context) throws Exception {
	
	}

}
