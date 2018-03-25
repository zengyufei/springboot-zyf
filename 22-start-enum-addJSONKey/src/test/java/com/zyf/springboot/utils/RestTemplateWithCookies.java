package com.zyf.springboot.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestTemplateWithCookies extends RestTemplate {

    private final List<HttpCookie> cookies = new ArrayList<>();

    public RestTemplateWithCookies() {
    }

    public RestTemplateWithCookies(ClientHttpRequestFactory requestFactory) {
        super(requestFactory);
    }

    public synchronized List<HttpCookie> getCoookies() {
        return cookies;
    }

    public synchronized void resetCoookies() {
        cookies.clear();
    }

    private void processHeaders(HttpHeaders headers) {
        final List<String> cooks = headers.get("Set-Cookie");
        if (cooks != null && !cooks.isEmpty()) {
            cooks.stream().map((c) -> HttpCookie.parse(c)).forEachOrdered((cook) -> {
                cook.forEach((a) -> {
                    HttpCookie cookieExists = cookies.stream()
                            .filter(x -> a.getName().equals(x.getName()))
                            .findAny()
                            .orElse(null);
                    if (cookieExists != null) {
                        cookies.remove(cookieExists);
                    }
                    cookies.add(a);
                });
            });
        }
    }

    @Override
    protected <T extends Object> T doExecute(URI url, HttpMethod method, final RequestCallback requestCallback, final ResponseExtractor<T> responseExtractor) throws RestClientException {
        final List<HttpCookie> cookies = getCoookies();

        return super.doExecute(url, method, chr -> {
            if (cookies != null) {
                StringBuilder sb = new StringBuilder();
                for (HttpCookie cookie : cookies) {
                    sb.append(cookie.getName()).append("=").append(cookie.getValue()).append(";");
                }
                chr.getHeaders().add("Cookie", sb.toString());
            }
            requestCallback.doWithRequest(chr);
        }, chr -> {
            processHeaders(chr.getHeaders());
            return responseExtractor.extractData(chr);
        });
    }

}