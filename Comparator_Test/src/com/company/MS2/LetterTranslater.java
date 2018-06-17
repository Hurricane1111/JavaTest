package com.company.MS2;

import javax.lang.model.type.ArrayType;
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


    private HashMap<String, HashSet<String>> parse(String inputCommand) {

        HashMap<String, HashSet<String>> params = new HashMap<String, HashSet<String>>();

        String[] separatedCommand = inputCommand.split(" ");
        if (separatedCommand.length > 1) {
            //Search for options
            for (int i = 1; i < separatedCommand.length; i++) {
                String currentElement = separatedCommand[i];
                if (currentElement.length() > 0) {
                    char prefix = currentElement.charAt(0);
                    if (prefix == '-') {
                        if (options.contains(currentElement)) {
                            HashSet<String> option = params.get(Keys.OptionKey());
                            if (option == null) {
                                option = new HashSet<String>();
                            }
                            option.add(currentElement);
                            params.put(Keys.OptionKey(), option);

                        } else {
                            this.example(currentElement);
                            return null;
                        }
                    }
                }
            }
            HashSet<String> findedOptions;
            findedOptions = params.get(Keys.OptionKey());
            if (findedOptions == null) {
                findedOptions = new HashSet<String>();
            }

            String argumentStr = separatedCommand[findedOptions.size() + 1];

            for (int i = findedOptions.size() + 2; i < separatedCommand.length; i++) {
                argumentStr = argumentStr + " " + separatedCommand[i];
            }


            System.out.println(argumentStr + "My argument");
            if (argumentStr.length() > 2 && argumentStr.charAt(0) == '\"' && argumentStr.charAt(argumentStr.length() - 1) == '\"') {
                HashSet<String> arguments = new HashSet<String >();
                arguments.add(argumentStr);
                params.put(Keys.ArgumentKey(), arguments);
            } else {
                this.example(argumentStr);
                return null;
            }


        }
        return params;
    }

    private void translate(HashMap<String , HashSet<String>>params) {
        //Проверить наличие опций в params и в случае присутствия - подчинить строку правилам.

        String argument = (String) params.get(Keys.ArgumentKey()).toArray()[0];
        String[] options = (String[]) params.get(Keys.OptionKey()).toArray();


    }
    @Override
    public void execute(String command) {
        HashMap<String, HashSet<String>> params = this.parse(command);
        if (params != null) {
            this.translate(params);
        } else {
            example("");
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

//          [Key.Options : [-r, -lc], Key.Argument: ["Some string"]];