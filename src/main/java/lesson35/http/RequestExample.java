package lesson35.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// fetch('https://jsonplaceholder.typicode.com/posts', {
//         method: 'POST',
//         body: JSON.stringify({
//         title: 'foo',
//         body: 'bar',
//         userId: 1,
//         }),
//         headers: {
//         'Content-type': 'application/json; charset=UTF-8',
//         },
//         })
public class RequestExample {

    public static void main(String[] args) throws JsonProcessingException {
        String apiUrl = "https://jsonplaceholder.typicode.com/posts";
        RequestBody body = new RequestBody(
                "foo", "bar", 1
        );
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInput = objectMapper.writeValueAsString(body);
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            try (OutputStream outputStream = connection.getOutputStream()) {
                byte[] input = jsonInput.getBytes();
                outputStream.write(input);
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response code = " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line).append("\n");
                    }
                    System.out.println("Response from typicode server");
                    System.out.println(response.toString());
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}


//    String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";
//  try {
//            URL url = new URL(apiUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setConnectTimeout(5000);
//
//            int responseCode = connection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(
//                                connection.getInputStream()
//                        )
//                );
//                StringBuilder response = new StringBuilder();
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    response.append(line).append("\n");
//                }
//                reader.close();
//
//                System.out.println("Response from typicode server");
//                System.out.println(response.toString());
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }

// HTTP //JSON

//HTTP - hyper text transfer protocol
//https://jsonplaceholder.typicode.com/posts/1
//Request // Response
//status code - 100,200,300,400,500
//200 - успіх
//400 - помилка клінєтська
//500 - помилка сервера

//        GET https://jsonplaceholder.typicode.com/posts/1?queryParams
//        GET https://jsonplaceholder.typicode.com/posts/1
//        Method HTTP запиту -  GET / POST / PUT / DELETE / OPTIONS / HEAD / PATCH
//        POST /posts/1   HTTP / 1.1
//        Host: jsonplaceholder.typicode.com
//        Headers - заголовки
//        Content - type:application / json, xml, text, img
//        Auturization:token
//        Content - Length:27
//        Accept: application/json, xml, text, img, video, audio
//        User-Agent : information about client
//        request body
//        {
//            "name":"John",
//            "age": 30
//        }
//
//        domen/host  - google.com - 10.46.15:12313
//        URL - uniform resource locator
//
//        Base URL schema
//        scheme://@host:port/path?query#fragment
//        scheme - https / https / ftp /file
//
//        host - www.google.com
//        host - www.youtube.com
//
//        port - :80 :443
//
//                www.jsonexmaple.com/jsonexample/jsonexample1
//                www.jsonexmaple.com/jsonexample/1024.jpeg
//        https://jsonplaceholder.typicode.com/posts/1
//        path(шлях) - шлях до ресурсу саме на сервері
//
//        query - cтрока запиту
//        ?key=value&key=value
//        GET https://jsonplaceholder.typicode.com/posts/1/?%20name=john%20&age=30&isActivated=true
//        {
//            "name":"John",
//                "age": 30
//        }
//        url - заледить від регістру
//                кодування символів
