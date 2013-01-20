package se.tarnowski.bootstrap.restlet.representation;

public class SimpleResponse {
    public String response;

    public SimpleResponse() {
        this("Default response");
    }

    public SimpleResponse(String response) {
        this.response = response;
    }
}
