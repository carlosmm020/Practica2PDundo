package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;
    private int lineNumber;

    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        lineNumber = documentLines.size();
        documentLines.add(text);
    }
    public void undo(ArrayList<String> documentLines){
        documentLines.remove(lineNumber);
    }
}
