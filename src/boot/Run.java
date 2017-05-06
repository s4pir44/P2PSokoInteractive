package boot;

import java.io.FileNotFoundException;
import java.io.IOException;

import controller.MyGameController;
import model.Model;
import view.Cli;
import view.GUI;

public class Run {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		GUI ui = new GUI();
		ui.bla(null);
		Model model = new Model();
		
 		Cli view = new Cli();
		MyGameController controller = new MyGameController(model, view);
		
		model.addObserver(controller);
		view.addObserver(controller);
		
		view.start();
	}

}
