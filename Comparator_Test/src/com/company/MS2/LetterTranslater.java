package com.company.MS2;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.lang.model.type.ArrayType;
import java.security.Key;
import java.util.*;

public class LetterTranslater implements TerminalUI {
//How to launch command: Example -

    static String commandName = "lt";

    private static ArrayList<String> options = new ArrayList<String>();

    //Example
    String example = "lt [-options (-r) (-lc) (-f)] [-argument (\"String\") (\'String\')]";

    public LetterTranslater() {
        options.add("-r");
        options.add("-lc");
        options.add("-f");
    }

    private HashMap<Character,Character> characterMap() {
        HashMap<Character,Character> charDictionary = new HashMap<Character, Character>();
        charDictionary.put('1', '1');
        charDictionary.put('2', '2');
        charDictionary.put('3', '3');
        charDictionary.put('4', '4');
        charDictionary.put('5', '5');
        charDictionary.put('6', '6');
        charDictionary.put('7', '7');
        charDictionary.put('8', '8');
        charDictionary.put('9', '9');
        charDictionary.put('0', '0');
        charDictionary.put('-', '-');
        charDictionary.put('=', '=');
        charDictionary.put('q', 'й');
        charDictionary.put('w', 'ц');
        charDictionary.put('e', 'у');
        charDictionary.put('r', 'к');
        charDictionary.put('t', 'е');
        charDictionary.put('y', 'ё');
        charDictionary.put('u', 'г');
        charDictionary.put('i', 'ш');
        charDictionary.put('o', 'щ');
        charDictionary.put('p', 'з');
        charDictionary.put('[', 'х');
        charDictionary.put(']', 'ъ');
        charDictionary.put('\\', 'ё');
        charDictionary.put('a', 'ф');
        charDictionary.put('s', 'ы');
        charDictionary.put('d', 'в');
        charDictionary.put('f', 'а');
        charDictionary.put('g', 'п');
        charDictionary.put('h', 'р');
        charDictionary.put('j', 'о');
        charDictionary.put('k', 'л');
        charDictionary.put('l', 'д');
        charDictionary.put(';', 'ж');
        charDictionary.put('\'', 'э');
        charDictionary.put('z', 'я');
        charDictionary.put('x', 'ч');
        charDictionary.put('c', 'с');
        charDictionary.put('v', 'м');
        charDictionary.put('b', 'и');
        charDictionary.put('n', 'т');
        charDictionary.put('m', 'ь');
        charDictionary.put(',', 'б');
        charDictionary.put('.', 'ю');
        charDictionary.put('/', '/');

        return charDictionary;
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
// Изменить для нового функционала
           for (int i = findedOptions.size() + 2; i < separatedCommand.length; i++) {
                argumentStr = argumentStr + " " + separatedCommand[i];
            }


            System.out.println(argumentStr + "My argument");


           if (findedOptions.contains("-f")) {
               String[] arguments = argumentStr.split("\" '");
               if (arguments.length == 2) {
                   if (arguments[0].toCharArray()[0] == '\"') {
                       arguments[0] = arguments[0].concat("\"");
                   } else {
                       this.example(argumentStr);
                       return null;
                   }

                   if (arguments[1].toCharArray()[arguments[1].length() - 1] == '\'') {
                       arguments[1] = arguments[1];
                   } else {
                       this.example(argumentStr);
                       return null;
                   }

                   HashSet<String> strArguments = new HashSet<String>();
                   strArguments.add(arguments[0]);
                   strArguments.add(arguments[1]);
                   params.put(Keys.ArgumentKey(), strArguments);
               } else {
                   this.example(argumentStr);
                   return null;
               }
               } else if (argumentStr.length() > 2 && argumentStr.charAt(0) == '\"' && argumentStr.charAt(argumentStr.length() - 1) == '\"') {
                   HashSet<String> arguments = new HashSet<String>();
                   arguments.add(argumentStr);
                   params.put(Keys.ArgumentKey(), arguments);
               } else {
                   this.example(argumentStr);
                   return null;
               }

//Конец

        }
        return params;
    }

    private void translate(HashMap<String , HashSet<String>>params) {
        //Проверить наличие опций в params и в случае присутствия - подчинить строку правилам.
        Boolean isSearchNeeded = false;
        String argument = (String) params.get(Keys.ArgumentKey()).toArray()[0];
        for (Object element : params.get(Keys.OptionKey()).toArray()) {
            System.out.println(element);
        }
        Object[] optionElement = params.get(Keys.OptionKey()).toArray();
        for (Object option:optionElement) {
            if (option.equals("-r")) {
                argument = new StringBuilder(argument).reverse().toString();
            } else if (option.equals("-lc")) {
                argument = argument.toLowerCase();
            } else if (option.equals("-f")) {
               isSearchNeeded = true;
            }
        }

        char[] symbolStringArray = argument.toCharArray();
        HashMap<Character,Character> charMap = this.characterMap();

            for (char symbol : symbolStringArray) {
                boolean isLowerCase = Character.isLowerCase(symbol);
                char lowerCaseSymbol = Character.toLowerCase(symbol);
                if (charMap.get(lowerCaseSymbol) != null) {
                    char mappedChar = charMap.get(lowerCaseSymbol);
                    if (!isLowerCase) {
                        mappedChar = Character.toUpperCase(mappedChar);
                    }
                    System.out.println(symbol + " - " + mappedChar);

                } else {
                    System.out.println(symbol + " - " + "There is no such symbol in map");

                }
            }
        if (isSearchNeeded) {
            String searchArgument = (String) params.get(Keys.ArgumentKey()).toArray()[1];
            if (argument.contains(searchArgument)) {
                System.out.println(argument + ": contain - " + searchArgument);
            } else {
                System.out.println(argument + ": has no - " + searchArgument);
            }
            }

            this.exit();
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
        System.out.print("LetterTranslater was end at " );
        System.out.print(new Date());
        System.out.println();
        System.out.println();
    }
}


///          lt -r -lc "sfdfkslfgjd dfgdfg -lc sjg ss"

//          [Key.Options : [-r, -lc], Key.Argument: ["Some string"]];