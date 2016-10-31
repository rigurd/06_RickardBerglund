package classes;

import java.io.File;
import javax.swing.JFileChooser;
import interfaces.PlayerInterface;
import jaco.mp3.player.MP3Player;

	/**
	 * 
	 * @author Rickard Berglund
	 * @since 2016-10/27
	 * @version 1.0
	 */
	
public class PlayerMethods implements PlayerInterface{
	
	// Attributes, Mp3 instantiated as a new object
	private MP3Player mp3 = new MP3Player();
	private String fileName = "";


	/**
	 * This method requests you to open and choose an .mp3 file
	 * then automatically plays it 
	 */
	public void open() { 
		try{
		JFileChooser filechooser = new JFileChooser();
		filechooser.showOpenDialog(null);
		File selectedFile = filechooser.getSelectedFile();
		stop();
		this.fileName = selectedFile.getName().toString();
		setMp3(new MP3Player(selectedFile));
		getMp3().play();
		}catch (NullPointerException e){
			e.getMessage();	
		}	
		
	}

	/**
	 * This method requests you to open and choose a .mp3 file if none has been chosen yet
	 * If one is already chosen, it plays it.
	 */
	public void play() {
		if (fileName == ""){
			open();
		}else{
			mp3.play();
		}
	}

	/**
	 * This method pauses the ongoing .mp3 file
	 */
	public void pause() {	
		mp3.pause();
	}

	/**
	 * This methods stops the ongoing .mp3 file
	 */
	public void stop() {
		mp3.stop();
	}
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public MP3Player getMp3() {
		return mp3;
	}
	
	public void setMp3(MP3Player mp3) {
		this.mp3 = mp3;
	}

}
