package com.BroncoRide;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.AsyncTask;

public class SendVCode extends AsyncTask<String, Void, String> {


    public String doInBackground(String... params) {
        
		String NAMESPACE = "http://Service.BroncoRide.com/";
		String SERVICEURL = "http://192.168.1.101:8080/BroncoRide_Backend/BroncoRideServicePort";
		
		String METHOD_NAME = "verifyCode";
		
		SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
		request.addProperty("arg0", params[0]);	// Verification Code
		request.addProperty("arg1", params[1]);	// Email
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.bodyOut = request;
		envelope.dotNet = false;
		
		HttpTransportSE ht = new HttpTransportSE(SERVICEURL);
        try {
            ht.call(NAMESPACE+METHOD_NAME, envelope);
            if (envelope.getResponse() != null) {
                return envelope.getResponse().toString();        
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            
        }
        
        return null;
    }

    protected void onPostExecute(String response) {
        // TODO: check this.exception 
        // TODO: do something with the feed
//    	if (response != null)
//    		System.out.println(response);
//    	else
//    		System.out.println("Null result");
//    	return response;
    }
}
