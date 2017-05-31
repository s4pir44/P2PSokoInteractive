package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import javafx.stage.Stage;
import model.IModel;

public class Cli extends Observable implements IView{


		boolean runORexit = true;
		IModel model;
		//MyView mv = new MyView();

		public Cli() 
		{
		}

		public void start() {
			Scanner scanner = new Scanner(System.in);
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						System.out.println("Enter command: ");
						String commandLine = scanner.nextLine();
						
						String[] arr = commandLine.split(" ");
						List<String> params = new ArrayList<String>();
						
						for (String s: arr) {
							params.add(s);
						}
						
						setChanged();
						notifyObservers(params);
						
						if (commandLine.equals("exit"))
							break;
					}				
				}
			});
			thread.start();
		}

		
		public void setIsRunning(boolean shouldRun) {
			runORexit = shouldRun;
		}
		public void displayError(String msg) {
			System.out.println("Error: " + msg);
	
		 }

		@Override
		public void start(Stage primaryStage) throws Exception {}

		@Override
		public void redraw() {
			// TODO Auto-generated method stub
			
		}
	}

