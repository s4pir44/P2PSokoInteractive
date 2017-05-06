package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import commands.Command;

public class Controller {
	private BlockingQueue<Command> queue;
	private boolean isStopped = false;
	
	public Controller() {
		queue = new ArrayBlockingQueue<Command>(10);		
	}
	
	public void insertCommand(Command command) {
		try {
			queue.put(command);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	public void start() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!isStopped) {
					try {
						Command cmd = queue.poll(1, TimeUnit.SECONDS);
						if (cmd != null)
							cmd.execute();						
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
	
	public void stop() {
		isStopped = true;
	}
	
}
