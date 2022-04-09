package costsubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import costpublisher.CostPublish;
import models.Train;

import trainidpublisher.TrainIDPublish;

public class Activator implements BundleActivator {

	ServiceReference costReference;
	ServiceReference tidReference;


	public void start(BundleContext context) throws Exception {

		System.out.println("------Cost subscriber service started!");
		costReference = context.getServiceReference(CostPublish.class.getName());
		CostPublish costPublish = (CostPublish)context.getService(costReference);
		
		
		tidReference = context.getServiceReference(TrainIDPublish.class.getName());
		TrainIDPublish tidPublish = (TrainIDPublish)context.getService(tidReference);
		

		Train matchedTrain;
		int tid=0;
		int cls=0;
		double cost;
		

				Scanner input= new Scanner(System.in);
				
				char more= 'y';
				
				while(more!='n' && more!='N') {
					
				System.out.println("\nEnter the train details to get cost!");
					
					
				System.out.println("\nEnter the Train ID: ");
				tid = input.nextInt();
				
				cls=0;
				
				System.out.println("Enter the ticket class(1 2 3): ");
				cls = input.nextInt();
				
				while(cls<0 || cls>4) {
					
					System.out.println("Invalid class!");
				
					System.out.println("Enter the ticket class(1 2 3): ");
					cls = input.nextInt();
				
				}
				
				try {
				

				  matchedTrain = tidPublish.publishTrain(tid);
				
				}catch(Exception e) {
					
					System.out.println("Invalid input!");
					break;
					
				}
				
				if(matchedTrain != null) {
					
					try {
						

					cost=costPublish.publishCost(matchedTrain, cls);
					
					}catch (Exception e) {
						System.out.println("Invalid input!");
						break;
					}
					
					
					
					System.out.println("Cost for your trip is: Rs. "+ cost);
					
					
				
				}else {
					
					System.out.println("Invalid Train ID!\n");
				}
				
				
				
				System.out.println("Are there any other trips (y-yes, n-No): ");
				more = input.next().charAt(0);
				
				}
				///
		
	}

	public void stop(BundleContext context) throws Exception {

		System.out.println("------Cost subscriber service stopping!");
		
		context.ungetService(costReference);
		context.ungetService(tidReference);
		
		
	}

}
