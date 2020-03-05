package stupid.simple;

public class SimpleResponse {
    private final long id;
    private final String content;
    private final String timeStamp;

    public SimpleResponse(long id, String content, String timeStamp) {
        this.id = id;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
