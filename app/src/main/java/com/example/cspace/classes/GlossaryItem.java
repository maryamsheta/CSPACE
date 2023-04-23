package com.example.cspace.classes;

public class GlossaryItem {

     String term;
     String definition;

    public GlossaryItem(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

}
