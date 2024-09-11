package edu.mum.cs.cs525.labs.skeleton.command;

import java.util.Stack;

public class Invoker {

    private final Stack<Command> commandHistory = new Stack<>();
    private final Stack<Command> redoHistory = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        redoHistory.clear();
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
            redoHistory.push(lastCommand);
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            Command lastCommand = redoHistory.pop();
            lastCommand.execute();
            commandHistory.push(lastCommand);
        }
    }

}
