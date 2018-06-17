package com.harman.blockingQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IPAdressDemo {

	public static void main(String[] args) {

        try
        {
        	getIpAddress();
        	
        	// http://sims-mck-integration-3.int.hitwise.com 10.24.34.20  -- integration 
        	// http://sims-mck-stage-4.int.hitwise.com  10.24.34.5  -- staging 
        	// https://simmonsinsights.com  64.19.224.47  -- production 
        	//InetAddress address = InetAddress.getByName(new URL("https://simmonsinsights.com").getHost());
        	//System.out.println("address "+ address.getHostAddress());
        }	
        catch (Exception e)
        {
           e.printStackTrace();
        }
       
    }
	
	public static void getIpAddress() throws UnknownHostException, SocketException
	{
		// System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
		    Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
		    
		    outer:
		    for (; n.hasMoreElements();)
		    {
		        NetworkInterface e = n.nextElement();
		        System.out.println(" network interface "+e.getDisplayName());
		        Enumeration<InetAddress> a = e.getInetAddresses();
		        for (; a.hasMoreElements();)
		        {
		            InetAddress addr = a.nextElement();
		            String ipAddress = addr.getHostAddress();
		            if(ipAddress.equals("10.99.68.127"))
		            {
		            	
		            	System.out.println(addr.getHostName()+" conocial host "+addr.getCanonicalHostName() +"  " + addr.getHostAddress());
		            	 break outer;
		            }
		       	// 
		        }
		      
		    }
	}
	}

