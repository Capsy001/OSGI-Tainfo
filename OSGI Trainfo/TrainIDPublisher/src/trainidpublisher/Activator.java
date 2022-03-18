package trainidpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration trainIDServiceRegistration;
	

	public void start(BundleContext context) throws Exception {
		
		System.out.println("TrainID publisher service started!");
		
		TrainIDPublish trainIDService = new TrainIDPublishImplementation();
		trainIDServiceRegistration = context.registerService(TrainIDPublish.class.getName(), trainIDService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("TrainID publisher service Stopping!");
		
		trainIDServiceRegistration.unregister();
	}

}
