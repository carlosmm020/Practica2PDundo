package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;
    private String originalText;

    public UpdateCommand(String text, int lineNumber) {
        this.text = text;
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        originalText = documentLines.get(lineNumber);
        documentLines.set(lineNumber, text);

    }

    @Override
    public void undo(ArrayList<String> documentLines) {
        documentLines.set(lineNumber, originalText);
    }
}
