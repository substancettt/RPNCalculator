package com.airwallex.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.shell.InputProvider;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Order(InteractiveShellApplicationRunner.PRECEDENCE - 50)
public class CommandsRunner implements ApplicationRunner {

	@Lazy
	@Autowired
	private InputProvider inputProvider;

	@Lazy
	@Autowired
	private Shell shell;

	@Override
	public void run(ApplicationArguments args) throws Exception {
			shell.run(inputProvider);
	}
	
}
