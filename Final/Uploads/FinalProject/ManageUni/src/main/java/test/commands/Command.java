package test.commands;

import services.UniManagement;

public abstract class Command {
    protected final UniManagement uniManagement;

    protected Command(UniManagement uniManagement) {
        this.uniManagement = uniManagement;
    }

    public abstract void execute();
}
