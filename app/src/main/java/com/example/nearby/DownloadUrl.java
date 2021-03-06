package com.example.nearby;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadUrl {

    public String ReadTheUrl(String placeUrl) throws IOException {
        String Data = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        URL url = new URL(placeUrl);
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpURLConnection.connect();

        inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer =  new StringBuffer();
        String line = "";

        while ((line = bufferedReader.readLine() )!= null){
            stringBuffer.append(line);
        }

        Data = stringBuffer.toString();
        bufferedReader.close();
        return Data;
    }

}
