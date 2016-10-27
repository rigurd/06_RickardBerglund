package main;

import java.awt.EventQueue;

import gui.ViewClass;

/**
 * 
 * @author Rickard Berglund
 * @since 2016-10/27
 * @version 1.0
 * 
 * This package includes the main methods where we run the program
 * 
 */

public class Main extends ViewClass{

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClass window = new ViewClass();
					window.frmMpPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
