package commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.IModel;


public  class CommandSave extends Command {
	
	private IModel model;
	
  public CommandSave(IModel model) {
     
	  this.model=model;
	  
	} 
	@Override
	public void execute() throws FileNotFoundException, IOException, ClassNotFoundException {
//		SaveFactory fac=new SaveFactory();
//		OutputStream file=new FileOutputStream(args[1]);
//		Level(fac.createSaver(args[1]).saveLevel(theLavel.getLevel(),file );
//		level.setLevelName(args[1]);
		model.save1(params.get(0),params.get(1));		
				
	}
	

}
