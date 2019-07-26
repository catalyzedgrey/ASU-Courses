package com.asu.asucourses.services;

import android.os.AsyncTask;

import com.asu.asucourses.interfaces.IService;
import com.asu.asucourses.models.NetworkResult;
import com.asu.asucourses.models.Track;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TrackService extends AsyncTask<String, Void, List<Track>> {

    private IService iService;

    public TrackService(IService iService) {
        this.iService = iService;
    }

    @Override
    protected List<Track> doInBackground(String... strings) {
        URL url;
        HttpURLConnection urlConnection = null;
        List<Track> tracks = new ArrayList<>();
        try {
//            int x = 10;
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            //HTTP method
            urlConnection.setRequestMethod("GET");
            //HTTP header
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("JsonStub-User-Key", "a5a3a085-c9bd-462a-83c5-77620f963745");
            urlConnection.setRequestProperty("JsonStub-Project-Key", "296b28d6-dd31-45c9-810d-cef77decfe75");

            int responseCode = urlConnection.getResponseCode();
            String responseMessage = urlConnection.getResponseMessage();

            if(responseCode == HttpURLConnection.HTTP_OK){
                String responseString = readStream(urlConnection.getInputStream());


                Gson gson = new Gson();
                Type type = new TypeToken<NetworkResult>() {}.getType();
                NetworkResult networkResult = (NetworkResult) gson.fromJson(responseString, type);
                tracks = networkResult.getTrackList();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
        }

        return tracks;
    }

    @Override
    protected void onPostExecute(List<Track> tracks) {
        super.onPostExecute(tracks);
        iService.onTaskCompleted(tracks);
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}
