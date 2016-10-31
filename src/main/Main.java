package main;

import gui.ViewClass;

/**
 * This application is a simple Mp3 player that allows you to open .mp3 files
 * and play them, also features a play, resume and a stop button so that you can pause
 * resume and stop your music.
 * 
 * @author Rickard Berglund
 * @since 2016-10/27
 * @version 1.0
 */

public class Main extends ViewClass{

	public static void main(String[] args) {
		
				try {
					ViewClass window = new ViewClass();
					window.frmMpPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

}
