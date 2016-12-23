package com.example.woowahan.retrofitsample.domain;

import java.util.List;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class User {

    int id;
    String url;
    List<String> scopes;
    String token;
    String token_last_eight;
    String hashed_token;
    GitHubApp app;
    String note;
    String note_url;
    String updated_at;
    String created_at;
    String fingerprint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken_last_eight() {
        return token_last_eight;
    }

    public void setToken_last_eight(String token_last_eight) {
        this.token_last_eight = token_last_eight;
    }

    public String getHashed_token() {
        return hashed_token;
    }

    public void setHashed_token(String hashed_token) {
        this.hashed_token = hashed_token;
    }

    public GitHubApp getApp() {
        return app;
    }

    public void setApp(GitHubApp app) {
        this.app = app;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote_url() {
        return note_url;
    }

    public void setNote_url(String note_url) {
        this.note_url = note_url;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", scopes=" + scopes +
                ", token='" + token + '\'' +
                ", token_last_eight='" + token_last_eight + '\'' +
                ", hashed_token='" + hashed_token + '\'' +
                ", app=" + app +
                ", note='" + note + '\'' +
                ", note_url='" + note_url + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", created_at='" + created_at + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                '}';
    }
}
