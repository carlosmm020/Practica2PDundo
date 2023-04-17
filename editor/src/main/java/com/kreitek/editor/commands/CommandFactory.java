package com.kreitek.editor.commands;

import com.kreitek.editor.*;

import java.util.ArrayList;

public class CommandFactory {
    private static final CommandParser commandParser = new CommandParser();
    private Command previousCommand = null;


    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        return switch (args[0]) {
            case "a" -> createAppendCommand(args[1]);
            case "u" -> createUpdateCommand(args[1], args[2]);
            case "d" -> createDeleteCommand(args[1]);
            case "undo" -> createUndoCommand();
            default -> throw new ExitException();
        };
    }

    private Command createUndoCommand() throws BadCommandException {
        if (previousCommand == null) {
            throw new BadCommandException();
        }
        previousCommand.undo();
        Command undoCommand = previousCommand;
        previousCommand = null;
        return undoCommand;
    }


    private Command createAppendCommand(String text) {
        Command command = new AppendCommand(text);
        previousCommand = command;
        return command;
    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        Command command = new UpdateCommand(text, number);
        previousCommand = command;
        return command;
    }

    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        Command command = new DeleteCommand(number);
        previousCommand = command;
        return command;
    }


}
