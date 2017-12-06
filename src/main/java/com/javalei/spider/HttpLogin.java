package com.javalei.spider;



import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
        import java.io.DataOutputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpLogin {
    public static final String urlString = "http://....?passport=...&password=...";  //先登录保存cookie
    public static final String urlString2 = "http://......";
    public String sessionId = "";


    public void doGet(String urlStr) throws IOException{
        String key = "";
        String cookieVal = "";
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect(); //到此步只是建立与服务器的tcp连接，并未发送http请求
        /**
         * 设置cookie
         */

        if(!sessionId.equals("")){
            connection.setRequestProperty("Cookie", sessionId);
        }

        for(int i=1;(key=connection.getHeaderField(i))!=null;i++){
            cookieVal = connection.getHeaderField(i);
            //System.out.println(cookieVal);
            cookieVal = cookieVal.substring(0,cookieVal.indexOf(";")>-1?cookieVal.indexOf(";"):cookieVal.length()-1);
            sessionId = sessionId + cookieVal + ";";
        }

        //保存session信息
//        connection.setRequestProperty("Cookie", sessionId[0]);
        //直到getInputStream()方法调用请求才真正发送出去
        System.out.println("sessionid"+sessionId);
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
       // System.out.println("sessionId:"+sessionId);
        //System.out.println(sb.toString());
        br.close();
        connection.disconnect();
    }

    public void doPost() throws IOException{
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true); //设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
        connection.setDoInput(true); // 设置连接输入流为true
        connection.setRequestMethod("POST"); // 设置请求方式为post
        connection.setUseCaches(false); // post请求缓存设为false
        connection.setInstanceFollowRedirects(true); //// 设置该HttpURLConnection实例是否自动执行重定向
        // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
        // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.connect();

        // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
        DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
        String parm = "storeId=" + URLEncoder.encode("32", "utf-8"); //URLEncoder.encode()方法  为字符串进行编码
        dataout.writeBytes(parm);
        dataout.flush();
        dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)
        // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder(); // 用来存储响应数据
        // 循环读取流,若不到结尾处
        while ((line = bf.readLine()) != null) {
            sb.append(bf.readLine());
        }
        bf.close();    // 重要且易忽略步骤 (关闭流,切记!)
        connection.disconnect(); // 销毁连接
        System.out.println(sb.toString());
    }


    public static String httpGet(String url,String encode,Map<String,String> headers){
        if(encode == null){
            encode = "utf-8";
        }
        String content = null;
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        //设置 header
        Header headerss[] = buildHeader(headers);
        if(headerss != null && headerss.length > 0){
            httpGet.setHeaders(headerss);
        }
        HttpResponse http_response;
        try {
            http_response = httpclient.execute(httpGet);
            HttpEntity entity = http_response.getEntity();
            content = EntityUtils.toString(entity, encode);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            httpGet.releaseConnection();
        }
        return content;
    }

    public static Header[] buildHeader(Map<String,String> params){
        Header[] headers = null;
        if(params != null && params.size() > 0){
            headers = new BasicHeader[params.size()];
            int i  = 0;
            for (Map.Entry<String, String> entry:params.entrySet()) {
                headers[i] = new BasicHeader(entry.getKey(),entry.getValue());
                i++;
            }
        }
        return headers;
    }

    public static  void test(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//get session info

        String session_value = urlConnection.getHeaderField("Set-Cookie");
        String[] sessionId = session_value.split(";");
//save session info
        //urlConnection.setRequestProperty("Cookie", sessionId[0]);
        System.out.println(sessionId[0]);

    }

    public static void main(String[] args) throws IOException {
        HttpLogin hcu = new HttpLogin();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        String url="http://www.e-cology.com.cn/mobile/plugin/login/QCLoginStatus.jsp?isie=false&langid=7&loginkey=51d25798-0108-4b90-abe7-cad35ed9ad12&rdm=1512494090428";
        //System.out.println(br.readLine());
        String ur2l="http://www.e-cology.com.cn/wui/main.jsp";
        Map<String,String> header = new HashMap<String,String>();
        header.put("Cookie", "JSESSIONID=a50a01acaae4ef610811e57a7c0002ff");
        //System.out.println(HttpLogin.httpGet(ur2l,null,header));
        test(ur2l);
        // /hcu.doGet(ur2l);
        //hcu.doGet(urlString2);
    }
}