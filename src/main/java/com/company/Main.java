package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        File inputFile  = new File("src/main/resources/input.text");
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader reader = new BufferedReader(fileReader);

        File outputFile  = new File("src/main/resources/output.text");
        FileWriter writer = new FileWriter(outputFile);

        Lines lines1 = readLines(reader);
        Lines lines2 = readLines(reader);
        fileReader.close();
        reader.close();

        Matrix matrix = new Matrix(lines1.getLength(), lines2.getLength());
        for (int i = 0; i < lines1.getLength(); i++) {
            for (int j = 0; j < lines2.getLength(); j++) {
                matrix.setCount(i, j, lines1.getWords(i).match(lines2.getWords(j)));
            }
        }

        List<Pair> pairs = new ArrayList<>();

        while (true) {
            Pair pair = matrix.findMax();

            if (pair.i == -1 && pair.j == -1) {
                break;
            }
            pairs.add(pair);
            matrix.setUnavailable(pair);
        }

        pairs.sort(Pair::compareTo);

        for (Pair pair : pairs) {
            String str;
            if (pair.i == -1) {
                str = lines2.getLine(pair.j) + ":?";
            } else if (pair.j == -1) {
                str = lines1.getLine(pair.i) + ":?";
            } else {
                str = lines1.getLine(pair.i) + ":" + lines2.getLine(pair.j);
            }
            writer.write(str);
            writer.append('\n');
            writer.flush();

        }
        writer.close();
    }

    private static Lines readLines(BufferedReader reader) throws IOException {
        String line = reader.readLine();

        if (line == null) {
            throw new IOException();
        }

        int n = Integer.parseInt(line);
        Lines lines = new Lines();

        for (int i = 0; i <n; i++) {
            line = reader.readLine();

            if (line == null) {
                throw new IOException();
            }
            lines.addLine(line);
        }
        return lines;
    }
}
