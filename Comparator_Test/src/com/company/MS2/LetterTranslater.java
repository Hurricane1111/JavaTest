package com.company.MS2;

import java.security.Key;
import java.util.*;

public class LetterTranslater implements TerminalUI {
//How to launch command: Example -

    static String commandName = "lt";

    private static ArrayList<String> options = new ArrayList<String>();

    //Example
    String example = "lt [-options (-r) (-lc)] [-argument (\"String\")]";

    public LetterTranslater() {
        options.add("-r");
        options.add("-lc");

    }


    private HashMap<String,ArrayList<String>> parse(String inputCommand) {

        HashMap<String,ArrayList<String>>params = new HashMap<String,ArrayList<String>>();

        String[] separatedOption = inputCommand.split(" ");
        if (separatedOption.length > 1) {
            //Search for options
            for (int i = 1; i < separatedOption.length; i++) {
                String currentElement = separatedOption[i];
                if (currentElement.length() > 0) {
                    char suffix = currentElement.charAt(0);
                    if (suffix == '-') {
                        if (options.contains(currentElement)) {
                            ArrayList<String> option = params.get(Keys.OptionKey());
                            if (option == null) {
                                option = new ArrayList<String>();
                            }
                            option.add(currentElement);
                            params.put(Keys.OptionKey(), option);
                            System.out.println(currentElement);

                        } else {
                            this.example(currentElement);
                            return null;
                        }
                    }
                }
            }
            String[] separatedArgument;

            ArrayList<String> currentOptions = params.get(Keys.OptionKey());

            if (currentOptions != null && currentOptions.size() > 0) {
                separatedArgument = inputCommand.split(currentOptions.get(currentOptions.size() - 1));
            } else {
                String[] tempArgument = inputCommand.split(" ");
                    separatedArgument = new String[tempArgument.length];
                for (int i = 1; i < tempArgument.length; i++) {
                    separatedArgument[i - 1] = tempArgument[i];
                }
            }
// Здесь ошибка!
            String argument = ""; // Это начало исправления
                     separatedArgument.toString();
            ///// ???????
            if (argument.length() > 2 && argument.charAt(0) == '\"' && argument.charAt(argument.length() - 1) == '\"') {
                ArrayList<String> arguments = new ArrayList<String>();
                arguments.add(argument);
                params.put(Keys.ArgumentKey(), arguments);
            } else {
                this.example(argument);
                return  null;
            }


        }
        return params;
    }

    @Override
    public void execute(String command) {
        HashMap<String,ArrayList<String>> params = this.parse(command);
    if (params != null ) {
            System.out.println(params.toString());
        }
    }

    @Override
    public void example(String forCommand) {
        System.out.println("Uncknown parameter: " + forCommand);
        System.out.println("");
        System.out.println("");

        System.out.println(this.example);
        System.out.println("");
        System.out.println("");

    }

    @Override
    public void exit() {

    }
}



///          lt -r -lc "sfdfkslfgjd dfgdfg -lc sjg ss"

//          [Key.Options : [-r, -lc]];