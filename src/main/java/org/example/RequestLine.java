package org.example;

import java.util.Objects;

public class RequestLine {

    private final String method;
    private final String urlPath;

    private QueryStrings queryStrings;

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }

    // GET /calculate?operand1=11&operator=*&operand2=22 HTTP/1.1
    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPartTokens = tokens[1].split("\\?");
        this.urlPath = urlPartTokens[0];

        if(urlPartTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPartTokens[1]);
        }
    }

    public boolean isGetRequest() {
        return this.method.equals("GET");
    }

    public boolean matchPath() {
        return this.urlPath.equals("/calculate");
    }

    public QueryStrings getQueryStrings() {
        return queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath,
            that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

}
