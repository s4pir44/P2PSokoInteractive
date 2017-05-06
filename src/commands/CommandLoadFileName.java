package commands;

import java.io.IOException;

import model.IModel;

public class CommandLoadFileName extends Command {

	//private Model model;
	IModel model;
	public CommandLoadFileName(IModel model) {
		this.model=model;
	}
	
	@Override
	public void execute() throws IOException, ClassNotFoundException {

	model.load1(params.get(0));
	}

	}
	

