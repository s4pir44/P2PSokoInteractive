package commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.IModel;


public  class CommandDisplay extends Command{
	
	private IModel model;
	
   public CommandDisplay(IModel model) {
	   this.model=model;
	} 
	
	@Override
	public void execute() throws FileNotFoundException, IOException, ClassNotFoundException {
	 model.display1();
		
			
	
	}
}
