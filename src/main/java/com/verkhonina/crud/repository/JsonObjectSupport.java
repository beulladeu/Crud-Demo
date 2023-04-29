package com.verkhonina.crud.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JsonObjectSupport<T> {


    public JsonObjectSupport() { }

    public String toJson(T obj) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(obj);
    }


    public String listToJson(List<T> objs) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(objs);
    }

    /*public T jsonToObject(String jsonObj) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.fromJson(jsonObj, T);
    }*/

    public List<T> jsonToList(String jsonObj, Class<T[]> clazz) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        T[] objs = gson.fromJson(jsonObj, clazz);
        if (objs == null) return null;
        else return new LinkedList(Arrays.asList(objs));
    }

    public void jsonWrite(String filename, String jsonObj) {
        try(FileWriter fileWriter = new FileWriter(filename)){
            fileWriter.write(jsonObj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readJson(String filename) {
        String json = "";
        Path path = Paths.get(filename);
        try {
            if (!Files.exists(path)) return "";
            json =  Files.readString(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return json;
    }

}
