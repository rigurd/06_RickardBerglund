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
 * 
 * @author Rickard Berglund
 * @since 2016-10/27
 * @version 1.0
 * 
 */

public class ViewClass extends PlayerMethods{

	public JFrame frmMpPlayer;
	PlayerMethods pm = new PlayerMethods();


	/**
	 * This application is a simple Mp3 player that allows you to open .mp3 files
	 * and play them, also features a play, resume and a stop button so that you can pause
	 * resume and stop your music.
	 */
	public ViewClass() {
		initialize();
	}

	/**
	 * Within this method exists the GUI. It includes visual settings for the Application
	 * aswell as everything that is included in the user interface part of the .exe file
	 * 
	 */
	private void initialize() {
		
		// Settings for Application, i.e visual settings
		frmMpPlayer = new JFrame();
		frmMpPlayer.getContentPane().setBackground(new Color(0, 0, 0));
		frmMpPlayer.getContentPane().setForeground(Color.BLACK);
		frmMpPlayer.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerSoundOn.png")));
		frmMpPlayer.setTitle("Rickards Audio Player");
		frmMpPlayer.setBounds(100, 100, 400, 148);
		frmMpPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMpPlayer.getContentPane().setLayout(null);
		
		// "Now playing: " Label
		JLabel lblNewLabel = new JLabel("Now playing:");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setBounds(10, 26, 71, 14);
		frmMpPlayer.getContentPane().add(lblNewLabel);
		
		// Empty textField behind Label - Being given a value in openButton method.
		JLabel textField = new JLabel("");
		textField.setForeground(new Color(255, 140, 0));
		textField.setBounds(94, 26, 225, 14);
		frmMpPlayer.getContentPane().add(textField);
		
		
		// Open Button
		JButton openButton = new JButton("");
		openButton.setBackground(new Color(0, 0, 0));
		openButton.setForeground(new Color(255, 140, 0));
		openButton.setToolTipText("Open a mp3 file to play music");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open a file
				pm.open();
				// Setting filename as textField
				textField.setText(pm.getFileName());
			}
		});
		openButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerEject.png")));
		openButton.setBounds(20, 56, 65, 23);
		frmMpPlayer.getContentPane().add(openButton);
		
		
		// Play Button
		JButton playButton = new JButton("");
		playButton.setBackground(new Color(0, 0, 0));
		playButton.setForeground(new Color(255, 140, 0));
		playButton.setToolTipText("Play/Resume");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.play();
				textField.setText(pm.getFileName());
			}
		});
		playButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
		playButton.setBounds(114, 56, 65, 23);
		frmMpPlayer.getContentPane().add(playButton);
		
		
		// Pause Button
		JButton pauseButton = new JButton("");
		pauseButton.setBackground(new Color(0, 0, 0));
		pauseButton.setForeground(new Color(255, 140, 0));
		pauseButton.setToolTipText("Pause");
		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pm.pause();
			}
		});
		pauseButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPause.png")));
		pauseButton.setBounds(205, 56, 65, 23);
		frmMpPlayer.getContentPane().add(pauseButton);
		
		
		// Stop Button
		JButton stopButton = new JButton("");
		stopButton.setBackground(new Color(0, 0, 0));
		stopButton.setForeground(new Color(255, 140, 0));
		stopButton.setToolTipText("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pm.stop();
			}
		});
		stopButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerStop.png")));
		stopButton.setBounds(296, 56, 65, 23);
		frmMpPlayer.getContentPane().add(stopButton);
		
	}
}
