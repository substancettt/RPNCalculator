package com.airwallex.shell;

import org.jline.reader.LineReader;
import org.jline.reader.UserInterruptException;
import org.jline.utils.AttributedString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.ExitRequest;
import org.springframework.shell.Input;
import org.springframework.shell.InputProvider;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component("inputProvider")
public class CalculatorInputProvider implements InputProvider {

	@Lazy
	@Autowired
	private LineReader lineReader;

	@Lazy
	@Autowired
    private PromptProvider promptProvider;

    @Override
    public Input readInput() {
        try {
            AttributedString prompt = promptProvider.getPrompt();
            lineReader.readLine(prompt.toAnsi(lineReader.getTerminal()));
        } catch (UserInterruptException e) {
            if (e.getPartialLine().isEmpty()) {
                throw new ExitRequest(1);
            } else {
                return Input.EMPTY;
            }
        }

        return new ParsedLineInput(lineReader.getParsedLine());
    }

}
