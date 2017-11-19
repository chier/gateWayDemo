package com.jhz.demo.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * httpUtil
 *
 * @author
 */

public class HttpUtil {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(HttpUtil.class);


    private static PoolingClientConnectionManager conMgr = null;

    static {
        HttpParams params = new BasicHttpParams();
        Integer CONNECTION_TIMEOUT = 2 * 1000; //设置请求超时2秒钟 根据业务调整
        Integer SO_TIMEOUT = 2 * 1000; //设置等待数据超时时间2秒钟 根据业务调整
        Long CONN_MANAGER_TIMEOUT = 500L; //该值就是连接不够用的时候等待超时时间，一定要设置，而且不能太大

        params.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, CONNECTION_TIMEOUT);
        params.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
        params.setLongParameter(ClientPNames.CONN_MANAGER_TIMEOUT, CONN_MANAGER_TIMEOUT);
        params.setBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true);

        conMgr = new PoolingClientConnectionManager();
        conMgr.setMaxTotal(2000);

        conMgr.setDefaultMaxPerRoute(conMgr.getMaxTotal());
    }

    public static String get(String url, String param) {

        DefaultHttpClient httpClient = new DefaultHttpClient(conMgr);

//        httpClient.setParams(params);

        httpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));

        HttpResponse httpResponse = null;

        // 发送get请求
        try {
            // 用get方法发送http请求
            HttpGet get = new HttpGet(url + URLEncoder.encode(param, "UTF-8"));
            get.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/51.0.2704.79 Chrome/51.0.2704.79 Safari/537.36");
            System.out.println("执行get请求, uri: " + get.getURI());
            httpResponse = httpClient.execute(get);
            // response实体
            HttpEntity entity = httpResponse.getEntity();
            if (null != entity) {
                String response = EntityUtils.toString(entity);
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode == HttpStatus.SC_OK) {
                    // 成功
                    return response;
                } else {
                    return null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("httpclient请求失败");
            return null;
        } finally {
            if (httpResponse != null) {
                try {
                    EntityUtils.consume(httpResponse.getEntity()); //会自动释放连接
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String post(String url, List<NameValuePair> nvps) throws Exception {

        // HttpClient httpclient = new DefaultHttpClient(); 已经过期采用新的类
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String str = "";
        try {

            HttpPost httpPost = new HttpPost(url);

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {

                HttpEntity entity = response.getEntity();
                str = EntityUtils.toString(entity);
                log.info("httpclient调用状态:" + response.getStatusLine());
                log.info("httpclient调用结果{}", str);
                // return EntityUtils.toString(response.getEntity());
                return str;
            } finally {
                response.close();
            }

        } finally {
            httpclient.close();
        }
    }


    public static String post(String url, Map<String,Object> params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response=null;
        String str = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for(String key : params.keySet()){
                list.add(new BasicNameValuePair(key,""+params.get(key)));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
                httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
            }
            response = httpclient.execute(httpPost);
            str = EntityUtils.toString(response.getEntity(), "UTF-8");
            return str;
        } finally {
            if(response!=null){
                response.close();
            }
            httpclient.close();
        }
    }


    public static String postRaw(String url, String json) throws Exception {

        // HttpClient httpclient = new DefaultHttpClient(); 已经过期采用新的类
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String str = "";
        try {

            HttpPost httpPost = new HttpPost(url);
            StringEntity postingString = new StringEntity(json);// json传递
            httpPost.setEntity(postingString);
            httpPost.setHeader("Content-type", "application/json");
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {

                HttpEntity entity = response.getEntity();
                str = EntityUtils.toString(entity);
                log.info("httpclient调用状态:" + response.getStatusLine());
                log.info("httpclient调用结果{}", str);
                // return EntityUtils.toString(response.getEntity());
                return str;
            } finally {
                response.close();
            }

        } finally {
            httpclient.close();
        }
    }

    public static String get(String url) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {

            HttpGet httpget = new HttpGet(url);
            // httpget.addHeader(new BasicHeader("", ""));
            // httpget.addHeader("", "");
            String str = "";
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取状态行
                HttpEntity entity = response.getEntity();
                str = EntityUtils.toString(entity);
                log.info("httpclient调用状态:" + response.getStatusLine());
                log.info("httpclient调用结果{}", str);
                return str;
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }

    }

    public static void main(String[] args) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        try {
            get("http://localhost:8080/website/index");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
