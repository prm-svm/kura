/**
 * Copyright (c) 2011, 2014 Eurotech and/or its affiliates
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Eurotech
 */
package org.eclipse.kura.net.route;

import org.eclipse.kura.net.IP4Address;
import org.eclipse.kura.net.IPAddress;

/**
 * Implementation of IPv4 route configurations
 */
public class RouteConfigIP4 extends RouteConfigIP<IP4Address> implements RouteConfig4 {

	public RouteConfigIP4(IP4Address destination, IP4Address gateway,
			IP4Address netmask, String interfaceName, int metric) {
		super(destination, gateway, netmask, interfaceName, metric);
	}

	@Override
	public boolean equals(RouteConfig route) {

	    if(!this.compareHostAddress(this.getDestination(), route.getDestination())) {
	        return false;
	    } else if(!this.compareHostAddress(this.getGateway(), route.getGateway())) {
	        return false;
	    } else if(!this.compareHostAddress(this.getNetmask(), route.getNetmask())) {
	        return false;
	    } else if(!this.getInterfaceName().equals(route.getInterfaceName())) {
	        return false;
	    } else if(this.getMetric() != route.getMetric()) {
	        return false;
	    }
	    
	    return true;
	}
	
	private boolean compareHostAddress(IPAddress adr1, IPAddress adr2) {
        String host1 = (adr1 == null || adr1.getHostAddress() == null) ? "" : adr1.getHostAddress();
        String host2 = (adr2 == null || adr2.getHostAddress() == null) ? "" : adr2.getHostAddress();
        
        return host1.equals(host2);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("destination: ")
		.append((this.getDestination() != null) ? this.getDestination().getHostAddress() : "null")
		.append(", gateway: ")
		.append((this.getGateway() != null) ? this.getGateway().getHostAddress() : "null")
		.append(", netmask: ")
		.append((this.getNetmask() != null) ? this.getNetmask().getHostAddress() : "null")
		.append(", interfaceName: ")
		.append(this.getInterfaceName())
		.append(", metric: ")
		.append(this.getMetric());
		
		return sb.toString();
	}
}
