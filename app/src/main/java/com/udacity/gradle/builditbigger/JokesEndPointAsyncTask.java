package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by abdel on 12/21/2017.
 */

public class JokesEndPointAsyncTask extends AsyncTask<Context, Void, String> {

    MyApi backEndService;
    Context context;
    final String LOCAL_HOST_ADDRESS = "http://10.0.2.2:8080/_ah/api/";
    JokesInterface jokesInterface;
    public String result;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Context ... params) {

        if (backEndService == null) //to initialize the
        {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null);

            builder.setRootUrl(LOCAL_HOST_ADDRESS);
            builder.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                    request.setDisableGZipContent(true);
                }
            });

            backEndService = builder.build();
        }

        context = params[0];
        try {
            return backEndService.getJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @Override
    protected void onPostExecute(String s) {
        jokesInterface = (JokesInterface) context;
        result = "";
        jokesInterface.sendJoke(s);
        super.onPostExecute(s);
    }
}
