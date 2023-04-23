package com.example.cspace.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import com.example.cspace.adapters.GlossaryAdapter;
import com.example.cspace.classes.GlossaryItem;
import com.example.cspace.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class GlossaryActivity extends AppCompatActivity {

    GridView glossaryGridView;
    GlossaryAdapter adapter;
    static ArrayList<GlossaryItem> glossaryItems = new ArrayList<>();

    public void populateGlossary() {
        glossaryItems.clear();
        glossaryItems.add(new GlossaryItem("Algorithm", "A set of instructions or rules that a computer program follows to solve a problem or accomplish a task."));
        glossaryItems.add(new GlossaryItem("API", "The abbreviation \"API\" stands for \"Application Programming Interface\".An API is a set of protocols, routines, and tools for building software applications, which defines how different software components should interact with each other. APIs can be used to access and share data, services, and functionality between different software applications, and are often used to integrate different systems together."));
        glossaryItems.add(new GlossaryItem("Application", "A computer program designed to perform a specific function or set of functions for a user or organization."));
        glossaryItems.add(new GlossaryItem("Artificial Intelligence (AI)", "A field of computer science that aims to create intelligent machines that can perform tasks that typically require human intelligence, such as learning, problem-solving, and decision-making."));
        glossaryItems.add(new GlossaryItem("Augmented Reality (AR)", "A technology that overlays digital information (e.g., images, sounds, videos) onto the physical world in real time. It typically involves the use of a smartphone or tablet camera, and can be used in a variety of applications such as gaming, education, and marketing."));
        glossaryItems.add(new GlossaryItem("Binary", "A system of numerical notation that uses only two digits, typically 0 and 1, to represent data or instructions in a computer."));
        glossaryItems.add(new GlossaryItem("Cache", "A type of computer memory that stores frequently accessed data or instructions for faster access by the CPU."));
        glossaryItems.add(new GlossaryItem("Cloud Computing", "A model of computing that provides on-demand access to a shared pool of computing resources (e.g., servers, storage, applications) over the internet."));
        glossaryItems.add(new GlossaryItem("Compiler", "A software tool that translates source code written in a programming language into machine code that can be executed by a computer."));
        glossaryItems.add(new GlossaryItem("Cryptography", "The practice of securing communication and data using mathematical algorithms and techniques."));
        glossaryItems.add(new GlossaryItem("Data Mining", "The process of discovering patterns and insights in large datasets using machine learning, statistical analysis, and other techniques."));
        glossaryItems.add(new GlossaryItem("Database", "A structured collection of data that is organized and stored in a way that enables efficient retrieval, updating, and management of the data."));
        glossaryItems.add(new GlossaryItem("Debugging", "The process of finding and fixing errors or defects in a software program."));
        glossaryItems.add(new GlossaryItem("Firewall", "A security system that monitors and controls incoming and outgoing network traffic based on predetermined security rules.."));
        glossaryItems.add(new GlossaryItem("Graphical User Interface (GUI)", "A type of user interface that allows users to interact with a computer using graphical elements such as icons, buttons, and windows."));
        glossaryItems.add(new GlossaryItem("Interpreter", "A program that can execute code written in a high-level programming language without the need for compiling it into machine code first. It is slower than compiled code, but provides greater flexibility and ease of use in development and debugging."));
        glossaryItems.add(new GlossaryItem("JSON", "JSON (JavaScript Object Notation) is a lightweight data interchange format that is easy for humans to read and write, and easy for machines to parse and generate. It is commonly used for transmitting data between a web application and a server, as an alternative to XML."));
        glossaryItems.add(new GlossaryItem("Kernel", "The core component of an operating system that manages system resources and provides low-level services to other software components."));
        glossaryItems.add(new GlossaryItem("Machine Learning", "A type of artificial intelligence that enables computer systems to learn from experience and improve their performance without being explicitly programmed."));
        glossaryItems.add(new GlossaryItem("Network", "A group of interconnected devices (e.g., computers, servers, routers) that are used to share resources and exchange information."));
        glossaryItems.add(new GlossaryItem("Operating System (OS)", "A software system that manages computer hardware resources and provides common services to software programs."));
        glossaryItems.add(new GlossaryItem("Programming Language", "A formal language used to write software programs and communicate instructions to a computer."));
        glossaryItems.add(new GlossaryItem("Software", "Computer programs and associated data that provide instructions and functionality to a computer system."));
        glossaryItems.add(new GlossaryItem("Source code", "The human-readable form of a computer program that is written in a programming language before it is compiled into machine code."));
        glossaryItems.add(new GlossaryItem("User Interface (UI)", "The means by which a user interacts with a software application, including graphical elements and other forms of input and output."));
        glossaryItems.add(new GlossaryItem("Virtual Reality (VR)", " computer-generated simulation of a three-dimensional environment that can be experienced by a user through a special headset and other devices."));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glossary);

        glossaryGridView = findViewById(R.id.glossaryGridView);

        adapter = new GlossaryAdapter(this, glossaryItems);

        glossaryGridView.setAdapter(adapter);

        glossaryGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                GlossaryItem clickedItem = glossaryItems.get(position);
                Intent intent = new Intent(GlossaryActivity.this, GlossaryDetailsActivity.class);
                intent.putExtra("term", clickedItem.getTerm());
                intent.putExtra("definition", clickedItem.getDefinition());
                startActivity(intent);
            }
        });
    }
    public static GlossaryItem getRandomGlossaryItem() {
        Random random = new Random();
        int index = random.nextInt(glossaryItems.size());
        return glossaryItems.get(index);
    }
}