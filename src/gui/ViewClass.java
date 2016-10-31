package gui;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import classes.PlayerMethods;


/**
 * This application is a simple Mp3 player that allows you to open .mp3 files
 * and play them, also features a play, resume and a stop button so that you can pause
 * resume and stop your music.
 * 
 * @author Rickard Berglund
 * @since 2016-10/27
 * @version 1.0
 */

public class ViewClass extends PlayerMethods implements ActionListener {

	// Instantiating everything needed for this Application
	
	public JFrame frmMpPlayer;
	PlayerMethods pm = new PlayerMethods();
	
	public JButton openButton = new JButton("Open");
	public JButton playButton = new JButton("Play");
	public JButton pauseButton = new JButton("Pause");
	public JButton stopButton = new JButton("Stop");
	
	public JLabel nowPlayingLabel = new JLabel("Now playing:");
	public JLabel songPlayingLabel = new JLabel("");
	
	


	/**
	 * This method creates the Application within ViewClass
	 */
	public ViewClass() {
		Gui();
		addComponents();
		addActionListeners();
	}

	/**
	 * Within this method exists the GUI. It includes visual settings for the Application
	 */
	private void Gui() {
		
		// Settings for Application, i.e visual settings
		frmMpPlayer = new JFrame();
		frmMpPlayer.getContentPane().setBackground(new Color(0, 0, 0));
		frmMpPlayer.getContentPane().setForeground(Color.BLACK);
		frmMpPlayer.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerSoundOn.png")));
		frmMpPlayer.setTitle("Rickards Audio Player");
		frmMpPlayer.setBounds(100, 100, 394, 148);
		frmMpPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMpPlayer.getContentPane().setLayout(null);
		
	}	
	
	/**
	 * This method adds Components to the framework
	 */
	public void addComponents(){	
		
		// Open Button
		frmMpPlayer.getContentPane().add(openButton);
		openButton.setBackground(new Color(0, 0, 0));
		openButton.setForeground(new Color(255, 140, 0));
		openButton.setToolTipText("Open a mp3 file to play music");
		openButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerEject.png")));
		openButton.setBounds(10, 56, 84, 23);
		
		
		// Play Button
		frmMpPlayer.getContentPane().add(playButton);
		playButton.setBackground(new Color(0, 0, 0));
		playButton.setForeground(new Color(255, 140, 0));
		playButton.setToolTipText("Play/Resume");
		playButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
		playButton.setBounds(104, 56, 81, 23);
		
		
		// Pause Button
		frmMpPlayer.getContentPane().add(pauseButton);
		pauseButton.setBackground(new Color(0, 0, 0));
		pauseButton.setForeground(new Color(255, 140, 0));
		pauseButton.setToolTipText("Pause");
		pauseButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPause.png")));
		pauseButton.setBounds(195, 56, 81, 23);
		
		
		// Stop Button
		frmMpPlayer.getContentPane().add(stopButton);
		stopButton.setBackground(new Color(0, 0, 0));
		stopButton.setForeground(new Color(255, 140, 0));
		stopButton.setToolTipText("Stop");
		stopButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerStop.png")));
		stopButton.setBounds(286, 56, 78, 23);
		
		// "Now playing: " Label
		nowPlayingLabel.setForeground(new Color(255, 140, 0));
		nowPlayingLabel.setBounds(10, 26, 71, 14);
		frmMpPlayer.getContentPane().add(nowPlayingLabel);
		
		// Empty textField behind Label - Being given a value in openButton method.
		songPlayingLabel.setForeground(new Color(255, 140, 0));
		songPlayingLabel.setBounds(94, 26, 225, 14);
		frmMpPlayer.getContentPane().add(songPlayingLabel);
		
	}
	
	/**
	 * This method adds ActionListeners to each button
	 */
	public void addActionListeners(){
		openButton.addActionListener(this);
		playButton.addActionListener(this);
		pauseButton.addActionListener(this);
		stopButton.addActionListener(this);
	}
	
	/**
	 * This method adds ActionPerformed to each button
	 */
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == openButton){
			// Open a file
			pm.open();
			// Setting filename as songPlayingLabel
			songPlayingLabel.setText(pm.getFileName());
			
		}
		if (e.getSource() == playButton){
			pm.play();
			songPlayingLabel.setText(pm.getFileName());
		}
		if (e.getSource() == pauseButton){
			pm.pause();
		}
		if (e.getSource() == stopButton){
			pm.stop();
		}
	}
		
}
