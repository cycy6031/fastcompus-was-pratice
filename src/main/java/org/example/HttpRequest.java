package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.http.HttpHeaders;

public class HttpRequest {

    private final RequestLine requestLine;
    //private final HttpHeaders httpHeaders;
    //private final Body body;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String s) {
        return requestLine.matchPath();
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }
}
