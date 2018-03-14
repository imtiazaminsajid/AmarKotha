package com.example.imtiazaminsajid.Models;

/**
 * Created by Imtiaz Amin Sajid on 3/14/2018.
 */

public class SimsimiModels {

    String response;
    String id;
    int result;
    String img;

    public SimsimiModels(String response, String id, int result, String img) {
        this.response = response;
        this.id = id;
        this.result = result;
        this.img = img;
    }

    public SimsimiModels() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
