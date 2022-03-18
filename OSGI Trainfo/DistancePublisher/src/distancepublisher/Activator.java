package distancepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration distanceServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Distance publisher service started!");
		
		
		DistancePublish distanceService = new DistancePublishImplementation();
		distanceServiceRegistration = context.registerService(DistancePublish.class.getName(), distanceService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Distance publisher service Stopping!");
		
		distanceServiceRegistration.unregister();
	}

}
