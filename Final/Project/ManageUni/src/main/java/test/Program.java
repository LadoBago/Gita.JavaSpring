package test;

import services.UniManagement;
import services.UniManagementImpl;
import test.commands.Command;
import test.commands.CommandFactory;

import java.util.Scanner;

public class Program {
    private Scanner scanner;
    private CommandFactory commandFactory;

    public Program() {
        this.scanner = new Scanner(getClass().getClassLoader().getResourceAsStream("input.txt"));
        this.commandFactory = new CommandFactory(new UniManagementImpl());
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }

    void run() {
        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            lineNumber++;
            String line = scanner.nextLine();

            System.out.println(lineNumber + ". " + line);

            String[] args = line.split("\\s");
            Command command = commandFactory.createCommand(args);

            if (command == null) {
                System.out.println("Error: command is not correct.");
            }
            else {
                command.execute();
            }
        }
    }
}
