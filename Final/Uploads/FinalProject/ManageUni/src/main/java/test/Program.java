package test;

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
        int commandNumber = 0;
        boolean emptyLine = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.trim().isEmpty()) {
                if (!emptyLine) {
                    System.out.println();
                }

                emptyLine = true;
                continue;
            }
            emptyLine = false;
            commandNumber++;

            System.out.println(commandNumber + ". " + line);
            String[] args = line.split("\\s");

            try {
                Command command = commandFactory.createCommand(args);

                if (command == null) {
                    System.out.println("Error: command is not correct.");
                }
                else {
                    command.execute();
                }
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
