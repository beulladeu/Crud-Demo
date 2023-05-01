package com.verkhonina.crud.repository;

import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class JsonObjectSupport<T> {

    private final Gson GSON = new Gson();

    public String listToJson(List<T> objs) {
        return GSON.toJson(objs);
    }

    public List<T> jsonToList(String jsonObj, Type type) {
        T[] objs = GSON.fromJson(jsonObj, type);
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
