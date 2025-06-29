package com.ambameow.meowmemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class diaryManagerClass {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // Register the JavaTimeModule to handle LocalDate and other Java 8 date/time types
        objectMapper.registerModule(new JavaTimeModule());
    }
    private static List<diaryClass> diaryList = new ArrayList<>();
    private static final String FILE_PATH = "diaries.json";

    // Method to load diaries from a JSON file
    public static void loadDiaries() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            diaryList = objectMapper.readValue(file, new TypeReference<List<diaryClass>>() {});
        }
    }

    // Method to save diaries to a JSON file
    public static void saveDiaries() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(FILE_PATH), diaryList);
    }

    // Method to add a new diary to the list
    public static void addDiary(diaryClass diary) {
        diaryList.add(diary);
    }

    // Getter for the diary list
    public static List<diaryClass> getDiaryList() {
        return diaryList;
    }
}
