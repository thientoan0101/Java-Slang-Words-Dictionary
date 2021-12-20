package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

/**
 * com.company
 * Created by thien
 * Date 12/19/2021 - 9:27 AM
 * Description: ...
 */
public class SlangWord {
    private HashMap<String, ArrayList<String>> dictionary;

    SlangWord() {
        dictionary = new HashMap<String, ArrayList<String>>();

//        dictionary.put(":)", "happy");
//        dictionary.put(":((", "sad");
//        dictionary.put("<3", "love");


        // traversing
//        for (Map.Entry<String, String> word: dictionary.entrySet()) {
//            System.out.println(word.getKey() + ": " + word.getValue());
//        }

//        String keyword = ":";
//        for (Map.Entry<String, String> word: dictionary.entrySet()) {
//            if (word.getKey().contains(keyword)) {
//                System.out.println("found: " + word.getKey() + ": " + word.getValue());
//            }
//        }

    }

    public HashMap<String, ArrayList<String>> loadFromTextFile(String filename) throws IOException {
        //HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        BufferedReader br;

        try
        {
            br = new BufferedReader(new FileReader(filename));
        }
        catch(IOException exc)
        {
            System.out.println("Error opening file");
            return dictionary;
        }
        String str ;
        int i = 0;
        int countDictionary = 0;
        HashSet<String> setSlang = new HashSet<String>();
        while (true)
        {
            i++;
            str = br.readLine();
            //System.out.println(i + ". " + str);
            if (str==null) break;
            String[] temp = str.split("`");
            String slang = temp[0];
            //String[] def = temp[1].split("\\| ");
            setSlang.add(slang);
            ArrayList<String> definitions = new ArrayList<String>(Arrays.asList(temp[1].split("\\| ")));
//            if (definitions.size()!=0) {
//                //System.out.println("\t\t\t\t" + i + ". " + slang);
//                System.out.println(slang);
//            } else {
//                System.out.println("\n\n\n\n\n\n\n\n");
//            }
            if (dictionary.containsKey(slang)==true) {
                ArrayList<String> oldDefinition = dictionary.get(slang);
                definitions.addAll(oldDefinition);
            }
            dictionary.put(slang, definitions);
        }
        System.out.println("\n\nSuccessful");
        System.out.println("\n\ndictionary: " + dictionary.size());
        System.out.println("\n\nset size: " + setSlang.size());
        //map.put("Numbers", list1);
//        Iterator<String> itr = setSlang.iterator();
//        int index = 0;
//        while (itr.hasNext()) {
//            index++;
//            System.out.println(itr.next());
//        }
        return dictionary;
    }

    public HashMap<String, ArrayList<String>> searchByDefinition(String value) {
//        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
//
//        ArrayList<String> list1 = new ArrayList<String>();
//        ArrayList<String> list2 = new ArrayList<String>();
//
//        list1.add("One");
//        list1.add("Two");
//        list1.add("Three");
//        list1.add("One 1");
//        list1.add("Two 2 2");
//        list1.add("Three 3 3 333");
//
//        list2.add("Cat meo");
//        list2.add("Dog cho cho go og");
//        list2.add("Fish anh fix");
//
//        map.put("Numbers", list1);
//        map.put("Animals", list2);
        String needle = value.toLowerCase();
        HashMap<String, ArrayList<String>> results = new HashMap<String, ArrayList<String>>();
//        ArrayList<String> tempDefi = new ArrayList<String>();
        for(Map.Entry<String, ArrayList<String>> entry : dictionary.entrySet())
        {

            //tempDefi.clear();
            boolean founded = false;
            ArrayList<String> tempDefi = new ArrayList<String>();
            ArrayList<String> values = entry.getValue();
            for (String e : values) {
                if (e.toLowerCase().contains(needle)) {
                    founded = true;
                    tempDefi.add(e);
                    System.out.println(entry.getKey() + ": founded value: " + e);
                }
            }
            if (founded) {
                results.put(entry.getKey(), tempDefi);
            }
        }
        return results;
    }

    public HashMap<String, ArrayList<String>> searchByKeySlang(String value) {
        String needle = value.toLowerCase();
        HashMap<String, ArrayList<String>> results = new HashMap<String, ArrayList<String>>();
        for(Map.Entry<String, ArrayList<String>> entry : dictionary.entrySet())
        {
            if (entry.getKey().toLowerCase().contains(needle)) {
                    results.put(entry.getKey(), entry.getValue());
            }
        }
        return results;
    }


    public void showDictionary() {
        HashMap<String, ArrayList<String>> results = new HashMap<String, ArrayList<String>>();
        int i = 0;
        for(Map.Entry<String, ArrayList<String>> entry : dictionary.entrySet())
        {
            i++;
            ArrayList<String> values = entry.getValue();
            System.out.print("\n" + i + ". " + entry.getKey() + ": ");
            for (String e : values) {
                    System.out.print(e + "|**|  ");

            }

        }
    }

    public static void main(String[] args) throws IOException {
        SlangWord dic = new SlangWord();
        String filename = "./src/main/java/com/company/slang.txt";

        dic.loadFromTextFile(filename);

        //dic.showDictionary();

        Scanner scan = new Scanner(System.in);

        System.out.print("\n\n\nEnter keyword to search: ");
        String value = scan.next();
//        HashMap<String, ArrayList<String>> results = dic.searchByDefinition(value);
        HashMap<String, ArrayList<String>> results = dic.searchByKeySlang(value);

        int i = 0;
        for(Map.Entry<String, ArrayList<String>> entry : results.entrySet())
        {
            i++;
            ArrayList<String> values = entry.getValue();
            System.out.print("\n" + i + ". " + entry.getKey() + ": ");
            for (String e : values) {
                System.out.print(e + "|**|  ");

            }

        }

    }
}
