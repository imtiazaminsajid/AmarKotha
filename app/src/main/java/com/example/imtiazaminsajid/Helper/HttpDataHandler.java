package com.example.imtiazaminsajid.Helper;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Imtiaz Amin Sajid on 3/14/2018.
 */

public class HttpDataHandler {
    static String stream = null;

    public HttpDataHandler() {
    }

    public String GetHTTPData(String urlString) {

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            if (urlConnection.getResponseCode()== HttpURLConnection.HTTP_OK){

                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null)
                    stringBuilder.append(line);
                stream = stringBuilder.toString();
                urlConnection.disconnect();

            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }

        catch (IOException e){
            e.printStackTrace();
        }
        finally {

        }

        return stream;
    }
}
