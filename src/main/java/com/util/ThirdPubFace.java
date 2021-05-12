package com.util;


import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *  第三方公用接口
 * @author cxh
 * @date 2021/5/8 17:05
 */
public class ThirdPubFace {
    public static String remoteJsonRequest (String url, int timeout, JSONObject object) {
        URL connect;
        StringBuffer data = new StringBuffer();
        try {
            connect = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) connect.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setReadTimeout(timeout);
            connection.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter paramout = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            paramout.write(object.toString());
            paramout.flush();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
            paramout.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    private static List<String> a=new ArrayList<>();

    public static void main (String[] args) {
        boolean flag=10%2==1 && 10/3==0&& 1/0==0;
        System.out.print(flag?'a':'b');
    }
}
