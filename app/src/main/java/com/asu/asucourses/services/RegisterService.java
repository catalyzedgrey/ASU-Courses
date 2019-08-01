package com.asu.asucourses.services;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.asu.asucourses.application.User;
import com.asu.asucourses.interfaces.IService;
import com.asu.asucourses.models.AccountResult;
import com.asu.asucourses.models.NetworkResult;
import com.asu.asucourses.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RegisterService extends AsyncTask<String, Void, Void> {

    private String REGISTER_SERIVICE_TAG = "register_service";
    private IService iService;
    User user;

    public RegisterService(IService iService) {
        this.iService = iService;
    }

    @Override
    protected Void doInBackground(String... strings) {
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            int x = 10;
            url = new URL(strings[0]);
            String userString = strings[1];
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");

            urlConnection.setDoOutput(true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    urlConnection.getOutputStream()));
            writer.write(userString);
            writer.close();

            urlConnection.connect();

            int responseCode = urlConnection.getResponseCode();
            String responseMessage = urlConnection.getResponseMessage();

            if(responseCode == HttpURLConnection.HTTP_OK){


               String responseString = Constants.readStream(urlConnection.getInputStream());
                Gson gson = new Gson();
                Type type = new TypeToken<AccountResult>() {}.getType();
                AccountResult accountResult = (AccountResult) gson.fromJson(responseString, type);

                switch(accountResult.getResultstatus()){
                    case 0:
                        // "User created"
                        Log.d(REGISTER_SERIVICE_TAG, "user is correct");
                        // Todo: set User object, but should we make it static
                        // User.setUserId(accountResult.getUser().getUserId());
                        return null;
                    case 1:
                    case 2:
                        // "couldn't create user try again later" or "invalid or missing parameters"
                        // should probably make User object null and let them register again
                        return null;
                    case 3:
                        // "email already registered"
                        return null;
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        // Todo: CHANGE THIS
        return null;
    }

}
