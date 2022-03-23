package timepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;




public class Activator implements BundleActivator {

	ServiceRegistration timeServiceRegistration;
	

	public void start(BundleContext context) throws Exception {
		
		System.out.println("------Time publisher service started!");
		
		TimePublish timeService = new TimePublishImplementation();
		timeServiceRegistration = context.registerService(TimePublish.class.getName(), timeService, null);

	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Time publisher service Stopping!");
		
		timeServiceRegistration.unregister();

	}

}
