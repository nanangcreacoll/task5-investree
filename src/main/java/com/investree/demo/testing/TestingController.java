package com.investree.demo.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingController {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void restTemplateSave() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting =
                "{\n" +
                "   \"peminjam\":{\n" +
                        "\"id\":\"3\"\n" +
                        "},\n" +
                "   \"meminjam\":{\n" +
                        "\"id\":\"4\"\n" +
                        "},\n" +
                "   \"tenor\":\"12\",\n" +
                "   \"totalPinjaman\":\"120000\",\n" +
                "   \"bungaPersen\":\"3\",\n" +
                "   \"status\":\"pending\"\n" +
                "   \n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(
                "http://localhost:5000/api/v1/transaksi/save",
                HttpMethod.POST,
                entity,
                String.class
        );
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response =" + exchange.getBody());
    }

    @Test
    public void restTemplateUpdateStatus() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting =
                "{\n" +
                        "   \"id\":\"22\"\n" +
                        "   \n" +
                        "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(
                "http://localhost:5000/api/v1/transaksi/update-status",
                HttpMethod.PUT,
                entity,
                String.class
        );
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response =" + exchange.getBody());
    }

    @Test
    public void restTemplateList() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(
                "http://localhost:5000/api/v1/transaksi/list",
                HttpMethod.GET,
                entity,
                String.class
        );
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response =" + exchange.getBody());
    }
}
