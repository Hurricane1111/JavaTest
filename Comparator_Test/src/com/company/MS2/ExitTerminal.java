package com.company.MS2;
import java.util.*;

public class ExitTerminal implements TerminalUI {

    @Override
    public void execute(String command) {
        System.out.println("Shuting down at: " + new Date() +  "\nUser: Graviton");
    }

    @Override
    public void example(String forCommand) {

    }

    @Override
    public void exit() {

    }
}
