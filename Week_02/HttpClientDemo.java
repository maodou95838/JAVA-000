package java0.nio01;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

/**
 * @author Jackie Hou
 * @date 2020/10/28 20:33
 */
public class HttpClientDemo {
	public static String getForObject() {
		BasicConfigurator.configure();
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet("http://localhost:8801");
			try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
				System.out.println(response1.getCode() + " " + response1.getReasonPhrase());
				HttpEntity entity1 = response1.getEntity();
				EntityUtils.consume(entity1);
			}
			return "ok";
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static void main(String[] args) {
		System.out.println(HttpClientDemo.getForObject());
	}
}
