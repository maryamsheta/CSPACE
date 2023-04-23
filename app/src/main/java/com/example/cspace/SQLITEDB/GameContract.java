package com.example.cspace.SQLITEDB;

public final class GameContract {
    private GameContract() {}

    public static class UnscrambleTable {
        public static final String TABLE_NAME = "unscramble";
        public static final String COLUMN_ID  = "id";
        public static final String COLUMN_WORD  = "word";

        public static final String CREATE_TABLE =  "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_WORD + " TEXT NOT NULL" + " )";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class GuessTheLanguage {
        public static final String TABLE_NAME = "guessTheLanguage";
        public static final String COLUMN_ID  = "id";
        public static final String COLUMN_QUESTION  = "question";
        public static final String COLUMN_OPTIONA  = "optionA";
        public static final String COLUMN_OPTIONB  = "optionB";
        public static final String COLUMN_ANSWER  = "answer";

        public static final String CREATE_TABLE =   "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_QUESTION + " TEXT NOT NULL," + COLUMN_OPTIONA + " TEXT NOT NULL," + COLUMN_OPTIONB + " TEXT NOT NULL," + COLUMN_ANSWER + " TEXT NOT NULL)";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class GuessTheOutput {
        public static final String TABLE_NAME = "guessTheOutput";
        public static final String COLUMN_ID  = "id";
        public static final String COLUMN_QUESTION  = "question";
        public static final String COLUMN_OPTIONA  = "optionA";
        public static final String COLUMN_OPTIONB  = "optionB";
        public static final String COLUMN_ANSWER  = "answer";
        public static final String COLUMN_LANGUAGE  = "language";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_QUESTION + " TEXT NOT NULL," + COLUMN_OPTIONA + " TEXT NOT NULL," + COLUMN_OPTIONB + " TEXT NOT NULL," + COLUMN_ANSWER + " TEXT NOT NULL," + COLUMN_LANGUAGE + " TEXT NOT NULL)";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
