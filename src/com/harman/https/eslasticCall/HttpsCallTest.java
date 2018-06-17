package com.harman.https.eslasticCall;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpsCallTest {

	public static  void testElasticNging()
	{
		HttpClient client = new HttpClient();
	    
	    client.getState().setCredentials( AuthScope.ANY,
	 		   new UsernamePasswordCredentials("nginx", "Cupertino1"));
	    String finalURL = "https://host1.mediainsiders-panel.com";
	    GetMethod httpget = new GetMethod(finalURL);
	     //httpget.get
	     try {
	         int status = client.executeMethod(httpget);
	          
	         
	         System.out.println("status "+status);
	     }catch(Exception ex)
	     {
	     	ex.printStackTrace();
	     }
	}
	public static void main(String args[])
	{
		testElasticNging();
	}
	
}
