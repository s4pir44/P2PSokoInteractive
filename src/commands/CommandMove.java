package commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.IModel;




public class CommandMove extends Command {
	private IModel model;
	
	public CommandMove(IModel m) {
		this.model=m;
	}
	@Override
	public void execute() throws FileNotFoundException, IOException, ClassNotFoundException {
		model.move(getParams().get(0));
		
	}
}