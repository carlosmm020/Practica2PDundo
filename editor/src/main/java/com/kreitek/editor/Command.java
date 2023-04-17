package com.kreitek.editor;

import java.util.ArrayList;

public interface Command {
    void execute(ArrayList<String> documentLines);
    void undo(ArrayList<String> documentLines);
}
