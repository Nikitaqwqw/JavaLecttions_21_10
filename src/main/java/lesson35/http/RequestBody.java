package lesson35.http;

// body: JSON.stringify({
//         title: 'foo',
//         body: 'bar',
//         userId: 1,
//         }),
public class RequestBody {
    private String title;
    private String body;
    private int userId;

    public RequestBody(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
