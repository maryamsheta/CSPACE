package com.example.cspace.SQLITEDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GameDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "game.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public GameDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(GameContract.UnscrambleTable.CREATE_TABLE);
        db.execSQL(GameContract.GuessTheLanguage.CREATE_TABLE);
        db.execSQL(GameContract.GuessTheOutput.CREATE_TABLE);
        this.db = db;
        populate();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(GameContract.UnscrambleTable.DELETE_TABLE);
        db.execSQL(GameContract.GuessTheLanguage.DELETE_TABLE);
        db.execSQL(GameContract.GuessTheOutput.DELETE_TABLE);
        onCreate(db);
    }

    public void insertUnscrambleWord(String word) {
        ContentValues values = new ContentValues();
        values.put(GameContract.UnscrambleTable.COLUMN_WORD, word.toUpperCase());
        db.insert(GameContract.UnscrambleTable.TABLE_NAME, null, values);
    }

    public void insertGuessTheLanguage(String question,String optionA,String optionB,String answer) {
        ContentValues values = new ContentValues();
        values.put(GameContract.GuessTheLanguage.COLUMN_QUESTION, question);
        values.put(GameContract.GuessTheLanguage.COLUMN_OPTIONA, optionA);
        values.put(GameContract.GuessTheLanguage.COLUMN_OPTIONB, optionB);
        values.put(GameContract.GuessTheLanguage.COLUMN_ANSWER, answer);
        db.insert(GameContract.GuessTheLanguage.TABLE_NAME,null,values);
    }

    public void insertGuessTheOutput(String question,String optionA,String optionB,String answer,String language) {
        ContentValues values = new ContentValues();
        values.put(GameContract.GuessTheOutput.COLUMN_QUESTION, question);
        values.put(GameContract.GuessTheOutput.COLUMN_OPTIONA, optionA);
        values.put(GameContract.GuessTheOutput.COLUMN_OPTIONB, optionB);
        values.put(GameContract.GuessTheOutput.COLUMN_ANSWER, answer);
        values.put(GameContract.GuessTheOutput.COLUMN_LANGUAGE, language);
        db.insert(GameContract.GuessTheOutput.TABLE_NAME, null, values);
    }

    public void populate() {
        insertUnscrambleWord("Algorithm");
        insertUnscrambleWord("Programming");
        insertUnscrambleWord("Compiler");
        insertUnscrambleWord("Interpreter");
        insertUnscrambleWord("Debugger");
        insertUnscrambleWord("Recursion");
        insertUnscrambleWord("JavaScript");
        insertUnscrambleWord("React");
        insertUnscrambleWord("Laravel");
        insertUnscrambleWord("Malware");
        insertUnscrambleWord("Encryption");
        insertUnscrambleWord("Hashing");
        insertUnscrambleWord("Authentication");
        insertUnscrambleWord("Authorization");
        insertUnscrambleWord("Firewall");
        insertUnscrambleWord("Virtualization");
        insertUnscrambleWord("Polymorphism");
        insertUnscrambleWord("Refactoring");
        insertUnscrambleWord("Abstraction");
        insertUnscrambleWord("Multithreading");
        insertUnscrambleWord("Networking");
        insertUnscrambleWord("Assembly");
        insertUnscrambleWord("Asynchronous");
        insertUnscrambleWord("Loop");
        insertUnscrambleWord("Encapsulation");
        insertUnscrambleWord("inheritance");
        insertUnscrambleWord("Software");
        insertUnscrambleWord("Overloading");
        insertUnscrambleWord("Android");
        insertUnscrambleWord("Computer");

        insertGuessTheLanguage("int main() {\n" +
                "   printf(\"Hello World\");\n" +
                "   return 0;\n" +
                "}","C","C++","C");

        insertGuessTheLanguage("int main() {\n" +
                "    std::cout << \"Hello World\";\n" +
                "    return 0;\n" +
                "}","C","C++","C++");

        insertGuessTheLanguage("class HelloWorldApp {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World!\");\n" +
                "    }\n" +
                "}","Java","JavaScript","Java");

        insertGuessTheLanguage("print('Hello, world!');","Python","Dart","Dart");

        insertGuessTheLanguage("<?= 'Hello world';","Perl","PHP","PHP");

        insertGuessTheLanguage("namespace HelloWorld\n" +
                "{\n" +
                "    class Hello {        \n" +
                "        static void Main(string[] args)\n" +
                "        {\n" +
                "            System.Console.WriteLine(\"Hello World\");\n" +
                "        }\n" +
                "    }\n" +
                "}","Java","C#","C#");

        insertGuessTheLanguage("puts 'Hello World'","Ruby","Pascal","Ruby");

        insertGuessTheLanguage("cat('Hello World')","Ruby","R","R");

        insertGuessTheLanguage("print(\"Hello World\")","Python","Dart","Python");

        insertGuessTheLanguage("println(\"Hello World\")","Kotlin","Swift","Kotlin");

        insertGuessTheLanguage("console.log(\"Hello World\");","JavaScript","C#","JavaScript");

        insertGuessTheOutput("my_list = [1, 2, 3, 4, 5]\n" +
                "print(my_list[2:4])","[3, 4]","[3, 4, 5]","[3, 4]","Python");

        insertGuessTheOutput("int a = 5;\n" +
                "int b = 10;\n" +
                "int c = a + b;\n" +
                "Console.WriteLine(c++);","16","15","15","C#");

        insertGuessTheOutput("let x = 1;\n" +
                "let y = x++;\n" +
                "let z = ++x;\n" +
                "let a = x++ + ++x;\n" +
                "let b = ++x + x++;\n" +
                "console.log(y, z, a, b);\n" +
                "Option 1: 0 3 7 13","0 3 7 13","1 3 8 13","1 3 8 13","JavaScript");

        insertGuessTheOutput("public static void main(String[] args) {\n" +
                "        String s = \"Hello\";\n" +
                "        s.concat(\" World\");\n" +
                "        System.out.println(s);\n" +
                "    }","Hello World","Hello", "Hello","Java");

        insertGuessTheOutput("movie = \"The Godfather\"\n" +
                "puts movie.reverse.downcase.capitalize","RedroftoDdog eht","RedroftodG eht","RedroftodG eht","Ruby");

        insertGuessTheOutput("String song = \"Bohemian Rhapsody\";\n" +
                "System.out.println(song.toLowerCase().replace(\"o\", \"a\"));","Bahemian Rhapsady","Bahemian Rhapsada","Bahemian Rhapsady","Java");

        insertGuessTheOutput("let beachItems = ['Sunscreen', 'Towel', 'Flip flops'];\n" +
                "console.log(beachItems.sort().join(', '));","Flip flops, Sunscreen, Towel","Sunscreen, Flip flops, Towel","Flip flops, Sunscreen, Towel","JavaScript");

        insertGuessTheOutput("import re\n" +
                "phone = \"555-555-1234\"\n" +
                "if re.match(r\"\\d{3}-\\d{3}-\\d{4}\", phone):\n" +
                "    print(\"Valid phone number\")\n" +
                "else:\n" +
                "    print(\"Invalid phone number\")","Valid phone number","Invalid phone number","Valid phone number","Python");

        insertGuessTheOutput("my_dict = {\"Tom Hanks\": 64, \"Brad Pitt\": 57, \"Leonardo DiCaprio\": 47, \"Johnny Depp\": 58}\n" +
                "print(sorted(my_dict, key=my_dict.get, reverse=True)[0])","Johnny Depp","Tom Hanks","Tom Hanks","Python");


        insertGuessTheOutput("def sorting_hat(name):\n" +
                "    if name[0] in \"GgHhRrSs\":\n" +
                "        return \"Gryffindor\"\n" +
                "    elif name[0] in \"PpDdTt\":\n" +
                "        return \"Hufflepuff\"\n" +
                "    elif name[0] in \"LlEeNn\":\n" +
                "        return \"Ravenclaw\"\n" +
                "    else:\n" +
                "        return \"Slytherin\"\n" +
                "\n" +
                "print(sorting_hat(\"Harry\"))","Gryffindor","Slytherin","Gryffindor","Python");

        insertGuessTheOutput("spell = \"Wingardium Leviosa\"\n" +
                "new_spell = \"\"\n" +
                "for i in range(len(spell)):\n" +
                "    if i % 2 == 0:\n" +
                "        new_spell += spell[i].lower()\n" +
                "    else:\n" +
                "        new_spell += spell[i].upper()\n" +
                "print(new_spell)","wInGaRdIuM lEvIoSa","wInGaRdIuM LeViOsA","wInGaRdIuM LeViOsA","Python");
    }
}
