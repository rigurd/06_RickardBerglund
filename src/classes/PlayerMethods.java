package classes;

import java.io.File;
import javax.swing.JFileChooser;

import interfaces.PlayerInterface;
import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface{
	
	// Attributes, Mp3 instantiated as new object
	private MP3Player mp3 = new MP3Player();
	private String fileName = "";


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

	public void play() {
		if (fileName == ""){
			open();
		}else{
			mp3.play();
		}
	}

	public void pause() {	
		mp3.pause();
	}

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
