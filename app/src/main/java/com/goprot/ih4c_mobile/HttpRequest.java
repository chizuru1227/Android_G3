package com.goprot.ih4c_mobile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class HttpRequest {

//    private static Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("halnagoyha.ac.jp", 8080));
//    private static String proxySwitch = "0";



    public static String callPost(Map<String, String> requestParams) {

        HttpURLConnection con = null;
        StringBuffer result = new StringBuffer();


        String strPostUrl = "https://naruho-backend-01.azurewebsites.net";
//        String strPostUrl = "http://10.0.2.2:8888";


        try {

            URL url = new URL(strPostUrl);

            //プロキシの設定があったら
            //con = (HttpURLConnection) url.openConnection(proxy);
            con = (HttpURLConnection) url.openConnection();

            StringBuilder data = new StringBuilder();
            for (String key : requestParams.keySet()){
                data.append(String.format("%s=%s&", key, requestParams.get(key)));
            }

            final String dataString = data.toString();
            final String formData = dataString.substring(0, dataString.length() - 1);

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(formData);
            out.flush();

            //out.close();
            con.connect();

            // HTTPレスポンスコード
            final int status = con.getResponseCode();

            if (status == HttpURLConnection.HTTP_OK) {
                // 通信に成功した
                // テキストを取得する
                final InputStream in = con.getInputStream();
                String encoding = con.getContentEncoding();
                if (null == encoding) {
                    encoding = "UTF-8";
                }

                final InputStreamReader inReader = new InputStreamReader(in, encoding);
                final BufferedReader bufReader = new BufferedReader(inReader);
                String line = null;
                // 1行ずつテキストを読み込む
                while ((line = bufReader.readLine()) != null) {
                    result.append(line);
                }
                bufReader.close();
                inReader.close();
                in.close();
            } else {
                System.out.println("error");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            if (con != null) {
                // コネクションを切断
                con.disconnect();
            }
        }
        return result.toString();

    }


}

