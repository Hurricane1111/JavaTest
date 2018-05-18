package com.company.MS2;
// User interface
// Read commands from keyboard
// Contain othe programms
// Error handler
// Unified access protocol

import java.util.ArrayList;
import java.util.Scanner;

public class Terminal  {

    ArrayList<TerminalUI> programms = new ArrayList<TerminalUI>();

    ArrayList<String> commandStack = new ArrayList<>();

    // SINGLE-TONE pattern
    static Terminal sharedTerminal = new Terminal();

    private Terminal() {
    }

    public void run() {

        String command = "";

        while (!command.equals("exit")) {
            Scanner keyboardInput = new Scanner(System.in);
            command = keyboardInput.nextLine();
            System.out.println(command);
            this.performProgramm(command);
        }

    }

    private void performProgramm(String programmName) {
        for (TerminalUI programm : programms ){
            if (programm.name.equals(programmName)) {
                programm.execute(programmName);
            }
        }
    }

    private void stop() {

    }

}
