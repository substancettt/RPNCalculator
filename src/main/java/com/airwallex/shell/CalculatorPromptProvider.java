package com.airwallex.shell;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class CalculatorPromptProvider implements PromptProvider {
    final static String  PROMOT = "CALCULATOR:> ";

    @Override
    public AttributedString getPrompt() {
        return new AttributedString(PROMOT, AttributedStyle.BOLD.foreground(AttributedStyle.CYAN));
    }

}