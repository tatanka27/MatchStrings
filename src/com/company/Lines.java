package com.company;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Words> words;
    private final List<String> originalLines;

    public Lines() {
        words = new ArrayList<>();
        originalLines = new ArrayList<>();
    }

    void addLine(String line) {
        words.add(new Words(line));
        originalLines.add(line);
    }

    int getLength() {
        return words.size();
    }

    Words getWords(int index) {
        return words.get(index);
    }

    String getLine(int index) {
        return originalLines.get(index);
    }
}
