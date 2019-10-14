package com.airwallex.shell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jline.reader.ParsedLine;
import org.springframework.shell.Input;

class ParsedLineInput implements Input {
    public final static String METHOD = "calculate";
    private final ParsedLine parsedLine;

    ParsedLineInput(ParsedLine parsedLine) {
        this.parsedLine = parsedLine;
    }

    @Override
    public String rawText() {
        return METHOD + " " + parsedLine.line();
    }

    @Override
    public List<String> words() {

        if (parsedLine == null) {
            return new ArrayList<>();
        }

        List<String> inputs = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        for (String word : parsedLine.words()) {
            sb.append(word);
            sb.append(" ");
        }

        inputs.add(METHOD + " ");
        inputs.add(sb.toString());

        return sanitizeInput(inputs);
    }

    static List<String> sanitizeInput(List<String> words) {
        words = words.stream()
                .map(s -> s.replaceAll("^\\n+|\\n+$", ""))
                .map(s -> s.replaceAll("\\n+", " "))
                .collect(Collectors.toList());
        
        return words;
    }
}
