package com.harman.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HTTP_POST {

	public static void main(String[] args) {
		String requestURL = "http://www.google.com";
        try {
            HttpUtility.sendGetRequest(requestURL);
            String[] response = HttpUtility.readMultipleLinesRespone();
           /*
            for (String line : response) {
                System.out.println(line);
            }
            */
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HttpUtility.disconnect();
         
         
        System.out.println("=====================================");
         
        // test sending POST request
        Map<String, String> params = new HashMap<String, String>();
        requestURL = "https://accounts.google.com/ServiceLoginAuth";
        params.put("Email", "abciuu@gmail.com");
        params.put("Passwd", "123456");
         
        try {
            HttpUtility.sendPostRequest(requestURL, params);
            String[] response = HttpUtility.readMultipleLinesRespone();
           /*
            for (String line : response) {
                System.out.println(line);
            } */
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HttpUtility.disconnect();
	}
	
	public static void postMethod()
	{
		try
		{
		 URL url = new URL("http://example.net/new-message.php");
	        Map<String,Object> params = new LinkedHashMap<>();
	        params.put("name", "Freddie the Fish");
	        params.put("email", "fishie@seamail.example.com");
	        params.put("reply_to_thread", 10394);
	        params.put("message", "Shark attacks in Botany Bay have gotten out of control. We need more defensive dolphins to protect the schools here, but Mayor Porpoise is too busy stuffing his snout with lobsters. He's so shellfish.");

	        StringBuilder postData = new StringBuilder();
	        for (Map.Entry<String,Object> param : params.entrySet()) {
	            if (postData.length() != 0) postData.append('&');
	            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	            postData.append('=');
	            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	        }
	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);

	        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

	        for (int c; (c = in.read()) >= 0;)
	            System.out.print((char)c);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
