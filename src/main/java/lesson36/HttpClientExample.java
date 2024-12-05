package lesson36;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson35.http.RequestBody;
import lesson35.http.models.PostModel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class HttpClientExample {

    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    static String apiKey = "qwewqewqeqweqweqweqweqeqeqweqweqweqweqw";

    public static void main(String[] args){
        String apiUrl = BASE_URL + "posts/1";
        String postUrl = BASE_URL + "posts";
        String getPostsUrl = BASE_URL + "posts";
        HttpClient httpClient = HttpClient.newHttpClient();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String result = getPosts(getPostsUrl,httpClient);
            System.out.println(result);
            List<PostModel> posts = objectMapper.readValue(result, new TypeReference<List<PostModel>>() {});
            List<String> titles = posts.stream().map(postModel -> postModel.getTitle()).collect(Collectors.toList());
            System.out.println(titles);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

//        try {
//            String result = getFirstPost(apiUrl,httpClient);
//            System.out.println(result);
//        } catch (URISyntaxException | IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            String result = makePostRequest(postUrl,httpClient);
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    public static String getFirstPost(String url, HttpClient client) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            return "Не вдалост виконати дію "+ response.statusCode() ;
        }
    }

    public static String getPosts(String url, HttpClient client) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 200){
            return response.body();
        } else {
            return "Не вдалост виконати дію "+ response.statusCode() ;
        }
    }

    public static String makePostRequest(String url, HttpClient client) throws IOException, URISyntaxException, InterruptedException {
        RequestBody body = new RequestBody(
                "foo", "bar", 1
        );
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInput = objectMapper.writeValueAsString(body);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(url))
                .POST(HttpRequest.BodyPublishers.ofString(jsonInput))
                .header("Content-type","application/json")
                .header("Autorization","Bearer token" + apiKey)
                .build();
        HttpResponse<String> response = client.send(postRequest,HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 200 || response.statusCode() == 201){
            return response.body();
        } else {
            return "Не вдалост виконати дію "+ response.statusCode() ;
        }
    }


}
