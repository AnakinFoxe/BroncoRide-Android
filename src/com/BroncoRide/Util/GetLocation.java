package com.BroncoRide.Util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

import com.google.android.gms.maps.model.LatLng;

public class GetLocation extends AsyncTask<String, Void, LatLng> {

    public LatLng doInBackground(String... address) {
        
    	StringBuilder stringBuilder = new StringBuilder();
    	double lng = 0;
    	double lat = 0;
	    try {
	    	String uri = "http://maps.google.com/maps/api/geocode/json?address=" 
					+ URLEncoder.encode(address[0], "UTF-8") + "&sensor=false";
	    	HttpGet httpGet = new HttpGet(uri);
		    HttpClient client = new DefaultHttpClient();
		    HttpResponse response;
	        response = client.execute(httpGet);
	        HttpEntity entity = response.getEntity();
	        InputStream stream = entity.getContent();
	        int b;
	        while ((b = stream.read()) != -1) {
	            stringBuilder.append((char) b);
	        }
	        
	        JSONObject jsonObject = new JSONObject();
		    jsonObject = new JSONObject(stringBuilder.toString());

		    lng = ((JSONArray) jsonObject.get("results")).getJSONObject(0)
		            .getJSONObject("geometry").getJSONObject("location")
		            .getDouble("lng");

		    lat = ((JSONArray) jsonObject.get("results")).getJSONObject(0)
		            .getJSONObject("geometry").getJSONObject("location")
		            .getDouble("lat");
	    } catch (ClientProtocolException e) {
	    } catch (IOException e) {
	    } catch (JSONException e) {
	    	
	    }

	    return new LatLng(lat, lng);
    }

    protected void onPostExecute(String response) {
        // TODO: check this.exception 
        // TODO: do something with the feed

    }

}
