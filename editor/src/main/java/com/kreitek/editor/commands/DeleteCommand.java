package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;
    private String deletedLine;
    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        deletedLine = documentLines.get(lineNumber);
        documentLines.remove(lineNumber);
    }

    public void undo(ArrayList<String> documentLines) {
        documentLines.add(lineNumber, deletedLine);
    }
}
