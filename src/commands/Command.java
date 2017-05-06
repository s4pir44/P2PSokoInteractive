
package commands;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public  abstract class Command {
	
	protected ArrayList<String> params;
	
	
	public abstract void execute() throws FileNotFoundException, IOException,ClassNotFoundException;
	
	
	public ArrayList<String> getParams() {
		return params;
	}
	
	
	
	public void setParams(ArrayList<String> params) {
		this.params = params;
	}



	
	

}
