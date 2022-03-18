package trainidsubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import trainidpublisher.Train;
import trainidpublisher.TrainIDPublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	

	public void start(BundleContext context) throws Exception {
		
		System.out.println("TrainID subscriber service started!");
		serviceReference = context.getServiceReference(TrainIDPublish.class.getName());
		TrainIDPublish trainIDPublish = (TrainIDPublish)context.getService(serviceReference);
		
		Scanner input= new Scanner(System.in);
		
		char more= 'y';
		
		while(more!='n' && more!='N') {
			
		System.out.println("\n\n-----Welcome to Trainfo !!!-----\n\n");
		
		System.out.println("Enter the Origin: ");
		String origin = input.next();
		
		System.out.println("Enter the Destination: ");
		String dest = input.next();
		
		Train matchedTrain = trainIDPublish.publishTID(origin, dest);
		
		if(matchedTrain!=null) {
			System.out.println("Train ID number "+matchedTrain.getTID()+ " matches your trip!");
		}else {
			System.out.println("No Train available for this Trip!\n");
		}
		
		////////////////////////////////////////////
		
		
		
		///////////////////////////////////////////
		
		System.out.println("Are there any other trips (y-yes, n-No): ");
		more = input.next().charAt(0);
		
		}
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("TrainID subscriber is Stopping!");
		context.ungetService(serviceReference);
		
	}

}
