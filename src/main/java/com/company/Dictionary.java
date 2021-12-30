package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * com.company
 * Created by thien
 * Date 12/30/2021 - 9:50 AM
 * Description: ...
 */
public class Dictionary implements Serializable {

    private HashMap<String, ArrayList<String>> dictionary = new HashMap<String, ArrayList<String>>();

    Dictionary(String serialFileName, String rawFileName) {
        dictionary = new HashMap<String, ArrayList<String>>();
    }

    public HashMap<String, ArrayList<String>> getDictionary() {
        return dictionary;
    }

    public void setDictionary(HashMap<String, ArrayList<String>> dictionary) {
        this.dictionary = dictionary;
    }

}
