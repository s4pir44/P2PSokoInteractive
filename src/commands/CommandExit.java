package commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import view.Cli;


public class CommandExit extends Command {
	private Cli myCli;

	public CommandExit(Cli cli)
	{
		myCli = cli;
	}

	@Override
	public void execute() throws FileNotFoundException, IOException, ClassNotFoundException {
		myCli.setIsRunning(false);
	}
}



