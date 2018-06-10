package com.company.MS2;

import java.util.*;

public class LetterTranslater implements TerminalUI {
//How to launch command: Example -

    static String commandName = "lt";

    String example = "lt [-options] [- argument]";

    private HashMap<String,String> parse(String inputCommand) {

        HashMap<String,String> params = new HashMap<String,String>();
        String options = "";
        String argument = "";

        params.put(Keys.OptionKey(),options);
        params.put(Keys.ArgumentKey(),argument);

        return params;
    }

    @Override
    public void execute(String command) {

    }

    @Override
    public void example(String forCommand) {
        System.out.println(this.example);
    }

    @Override
    public void exit() {

    }
}
