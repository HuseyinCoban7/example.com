package url_check.demo;

import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class UrlHealthTest {
    @Test
    void exampleDotComShouldBeReachable() throws Exception {
        String target = "https://example.com";
        HttpURLConnection conn = (HttpURLConnection) new URL(target).openConnection();
        conn.setRequestMethod("GET");
        conn.setInstanceFollowRedirects(true);
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        int code = conn.getResponseCode();
        assertTrue(code >= 200 && code < 400,
                "URL erişilemez. HTTP code=" + code + " target=" + target);
    }
}
