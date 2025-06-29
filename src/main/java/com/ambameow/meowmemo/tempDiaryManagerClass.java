package com.ambameow.meowmemo;


public class tempDiaryManagerClass {
    private static tempDiaryClass tempDiary; // A single static instance to hold the temp diary

    // Getter for the temporary diary
    public static tempDiaryClass getTempDiary() {
        return tempDiary;
    }

    // Setter for the temporary diary
    public static void setTempDiary(tempDiaryClass diary) {
        tempDiary = diary;
    }

    // Method to reset the temporary diary
    public static void resetTempDiary() {
        tempDiary = null; // Clears the temp diary
    }

}
