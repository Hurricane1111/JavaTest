package com.company.MS2;

import java.util.*;
import java.lang.*;

public class Formula {

    HashSet<String> elements = new HashSet<String>();
    String formula = "";

    public Formula(String formulaName) {
        this.formula = formulaName;
        this.parseFormula();
    }


    public void parseFormula() {

        char[] formulaByChars = formula.toCharArray();
        String elementName = "";

        for (char symbol: formulaByChars) {
            if (Character.isAlphabetic(symbol) && Character.isUpperCase(symbol)) {
                if (elementName.length() > 0) {
                    elements.add(elementName);
                    elementName = "";
                }

               elementName = String.valueOf(symbol);
            } else  if (Character.isAlphabetic(symbol) && Character.isLowerCase(symbol)){
                elementName = elementName.concat(String.valueOf(symbol));
                elements.add(elementName);
                elementName = "";
            }
        }

        if (elementName.length() > 0) {
            elements.add(elementName);
            elementName = "";
        }


    }


    public  void description() {
        for (String element : elements) {
            System.out.println(element);
        }
    }
}
