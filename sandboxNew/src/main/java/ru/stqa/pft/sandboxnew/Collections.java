package ru.stqa.pft.sandboxnew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main (String[] args){
        String[] langs = {"Java", "C#", "Phyton", "PHP"};

        List<String>languages = Arrays.asList("Java", "C#", "Phyton", "PHP");

        for (String l : languages){
            System.out.println("Я хочуизучать " + l);
        }
    }

}
