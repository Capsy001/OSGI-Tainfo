package trainfo;


import distancepublisher.DistancePublish;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import timepublisher.TimePublish;
import trainidpublisher.TrainIDPublish;


public class Activator implements BundleActivator {

//	ServiceReference tidReference;
//	ServiceReference distanceReference;
//	ServiceReference timeReference;
//	ServiceReference costReference;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("------Trainfo core service starting!");
		
		
//		
//		tidReference = context.getServiceReference(trainidsubscriber.Activator.class.getName());
//		trainidsubscriber.Activator tidSubService = (trainidsubscriber.Activator)context.getService(tidReference);
//		

		
	
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("------Trainfo core service stopping!");
		
	}

}
