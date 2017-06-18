package commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.IModel;

public class CommandSubmit extends Command{


		private IModel model;
		
		public CommandSubmit(IModel model) {
			   this.model=model;
		}
		@Override
		public void execute() throws FileNotFoundException, IOException, ClassNotFoundException {
		model.submitToDataBase(getParams().get(0));
		}
		
}
