package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
/**
 * com.company
 * Created by thien
 * Date 12/19/2021 - 9:27 AM
 * Description: ...
 */
public class SlangWord {
    private HashMap<String, String> dictionary;

    SlangWord() {
        dictionary = new HashMap<String, String>();

        dictionary.put(":)", "happy");
        dictionary.put(":((", "sad");
        dictionary.put("<3", "love");

        System.out.println("first element: " + dictionary.get(":)"));

        // traversing
        for (Map.Entry<String, String> word: dictionary.entrySet()) {
            System.out.println(word.getKey() + ": " + word.getValue());
        }

        String keyword = ":";
        for (Map.Entry<String, String> word: dictionary.entrySet()) {
            if (word.getKey().contains(keyword)) {
                System.out.println("found: " + word.getKey() + ": " + word.getValue());
            }
        }

    }

    public void loadFromTextFile(String filename) throws IOException {
        //this.dictionary.clear();
        BufferedReader br;

        try
        {
            br = new BufferedReader(new FileReader(filename));
        }
        catch(IOException exc)
        {
            System.out.println("Error opening file");
            return ;
        }
        String str ;
        while (true)
        {
            str = br.readLine();
            if (str==null)
                break;
            String[] temp = str.split("`");
            String key = temp[0];
            String[] def = temp[1].split("\\| ");

            System.out.println("Key: " + key);
            System.out.println("Value: ");
            for (String w: def) {
                System.out.print(w + ", ");
            }
            System.out.println("\n");

//            String sID = temp[0], tName = temp[1], sAge=temp[2], tGpa = temp[3], tImage = temp[4], tAddress = temp[5], tNote = temp[6];
//            int iID = Integer.parseInt(sID);
//            int iAge = Integer.parseInt(sAge);
//            double dGpa = Double.parseDouble(tGpa);
//            dGpa = (double) Math.round(dGpa * 100) / 100;
//            studentList.add(new Student(iID, tName, iAge, dGpa, tImage, tAddress, tNote));
        }
        System.out.println("Successful");
    }

    public static void main(String[] args) throws IOException {
        SlangWord dic = new SlangWord();
        String filename = "./src/main/java/com/company/slang.txt";

        dic.loadFromTextFile(filename);

    }
}
