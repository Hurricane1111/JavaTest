package com.company.MS2;

import java.util.*;

public class Terminal  {

    HashMap<String,TerminalUI> programms = new HashMap<String, TerminalUI>();

    ArrayList<String> commandStack = new ArrayList<>();

    // SINGLE-TONE pattern
    static Terminal sharedTerminal = new Terminal();

    private Terminal() {
    }

    public void run() {

        String command = "";
        this.firstLaunch();
        while (!command.equals("exit")) {
            System.out.print("-executor [Graviton]: ");
            Scanner keyboardInput = new Scanner(System.in);
            command = keyboardInput.nextLine();
            this.performProgramm(command);
        }

    }

    private void performProgramm(String inputCommand) {
        String commandName = this.parseCommandName(inputCommand);
        TerminalUI programm = programms.get(commandName);

        if (programm == null) {
            System.out.printf("-executor: \"%s\" command not found\n", commandName);
        } else {
            programm.execute(inputCommand);
        }

    }

    private String parseCommandName(String command) {
        String split = command.replaceAll("\n", "");
        String[] linesArray = split.split(" ");

        return  linesArray.length > 0 ? linesArray[0] : "";
    }

    private void firstLaunch() {
        System.out.print("Terminal session started at " );
        System.out.print(new Date());
        System.out.println(": User Igor Polishchuk.");
        System.out.println("© Copyright by Igor Inc. at 2018 year.");

    }

    private void stop() {

    }

}
