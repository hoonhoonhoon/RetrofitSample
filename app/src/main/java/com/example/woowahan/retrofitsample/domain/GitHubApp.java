package com.example.woowahan.retrofitsample.domain;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class GitHubApp {

    String url;
    String name;
    String client_id;


    @Override
    public String toString() {
        return "GitHubApp{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", client_id='" + client_id + '\'' +
                '}';
    }
}
