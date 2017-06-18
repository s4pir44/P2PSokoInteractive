package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import commands.Command;
import commands.CommandDisplay;
import commands.CommandExit;
import commands.CommandLoadFileName;
import commands.CommandMove;
import commands.CommandSave;
import commands.CommandSubmit;
import model.IModel;
import view.Cli;
import view.IView;

public class MyGameController implements Observer {
	private IModel model;
	private IView view;
	private Controller controller;
	private Map<String, Command> commands;
	private Cli cli;
	
	public MyGameController(IModel model, IView view) {
		this.model = model;
		this.view = view;
		initCommands();
		controller = new Controller(view);
		controller.start();
	}
	
	protected void initCommands() {
		commands = new HashMap<String, Command>();
		commands.put("move", new CommandMove(model));	
		commands.put("display", new CommandDisplay(model));
		commands.put("exit", new CommandExit(cli));
		commands.put("save", new CommandSave(model));
		commands.put("load", new CommandLoadFileName(model));
		commands.put("submit", new CommandSubmit(model));
	}	

	@Override
	public void update(Observable o, Object arg) {
		ArrayList<String> params = (ArrayList<String>) arg;
		String commandKey = params.remove(0);
	//	String commandKey = params.get(0);

		Command c = commands.get(commandKey);
		if (c == null) {
			view.displayError("Command " + commandKey + " not found");
			return;
		}
		c.setParams(params);
		controller.insertCommand(c);
	}
}
