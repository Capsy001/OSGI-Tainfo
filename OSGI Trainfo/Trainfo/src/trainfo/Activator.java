package trainfo;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {

	ServiceReference serviceReferenceTID;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("\n\n-----Welcome to Trainfo !!!-----\n\n");
		
		System.out.println("Enter the service: ");
		
		int service=0;
		
		if(service==1) {
			
			
		}
		
	
	}

	public void stop(BundleContext context) throws Exception {
		
		
		
	}

}
