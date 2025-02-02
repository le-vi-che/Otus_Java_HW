package ru.otus.jserver;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String rawRequest;
    private String uri;
    private HttpMethod method;
    private Map<String, String> parameters;

    public String getUri() {
        return uri;
    }

    public HttpRequest(String rawRequest) {
        this.rawRequest = rawRequest;
        this.parse();
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }

    private void parse() {
        this.parameters = new HashMap<>();
        int startIndex = rawRequest.indexOf(' ');
        int endIndex = rawRequest.indexOf(' ', startIndex + 1);
        this.method = HttpMethod.valueOf(rawRequest.substring(0, startIndex));
        this.uri = rawRequest.substring(startIndex + 1, endIndex);
        if (uri.contains("?")) {
            String[] tokens = uri.split("[?]");
            this.uri = tokens[0];
            String[] paramsPairs = tokens[1].split("[&]");
            for (String o : paramsPairs) {
                String[] keyValue = o.split("=");
                this.parameters.put(keyValue[0], keyValue[1]);
            }
        }
    }

    public void info(boolean showRawRequest) {
        System.out.println("METHOD: " + this.method);
        System.out.println("URI: " + this.uri);
        System.out.println("Parameters: " + this.parameters);
        if (showRawRequest) {
            System.out.println(rawRequest);
        }
    }
}
