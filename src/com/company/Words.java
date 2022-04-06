package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Words {
    private final List<String> words;

    Words(String line) {
        words = new ArrayList<>();
        String[] str = Arrays.stream(line.split(" ")).toArray(String[]::new);
        words.addAll(Arrays.asList(str));
    }

    String getWord(int index){
        return words.get(index);
    }

    int getLength() {
        return words.size();
    }

    int match(Words another) {
        int count = 0;
        for (int i = 0; i < getLength(); i++) {
            for (int j = 0; j < another.getLength(); j++) {
                if (words.get(i).equals(another.getWord(j))) {
                    count++;
                }
            }
        }
        return count;
    }
}
