package lesson35.http;

import lesson35.http.models.PostModel;

public class LombokExample {

    public static void main(String[] args) {
        PostModel model = new PostModel(
          "some title","body",1,1
        );
    }

}
