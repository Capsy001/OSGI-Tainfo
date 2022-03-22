package costpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration costRegistration;

	public void start(BundleContext context) throws Exception {
	
		System.out.println("Cost publisher service started!");
		
		CostPublish costService = new CostPublishImplementation();
		costRegistration = context.registerService(CostPublish.class.getName(), costService, null);

	}

	public void stop(BundleContext context) throws Exception {
	
		
		System.out.println("Cost publisher service Stopping!");
		
		costRegistration.unregister();
		
	}

}
