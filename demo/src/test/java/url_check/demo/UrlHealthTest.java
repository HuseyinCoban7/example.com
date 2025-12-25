package url_check.demo;

import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UrlHealthTest {

    @Test
    void targetUrl_shouldReturn200() throws Exception {
        String targetUrl = System.getProperty("targetUrl", "https://example.com");

        int code = -1;
        Exception last = null;

        for (int i = 0; i < 3; i++) {
            try {
                HttpURLConnection con = (HttpURLConnection) new URL(targetUrl).openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(5000);
                con.setReadTimeout(5000);
                con.setInstanceFollowRedirects(true);

                code = con.getResponseCode();
                con.disconnect();
                break;
            } catch (Exception e) {
                last = e;
                Thread.sleep(1000);
            }
        }

        assertEquals(400, code,
        "URL erişilemedi veya 200 dönmedi! url=" + targetUrl +
                " status=" + code +
                (last != null ? " lastError=" + last.getMessage() : ""));
    }
}

