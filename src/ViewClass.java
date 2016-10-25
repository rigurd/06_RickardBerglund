
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class ViewClass extends PlayerMethods{

	JFrame frmMpPlayer;
	PlayerMethods pm = new PlayerMethods();
	private JTextField playlist;


	/**
	 * Create the application.
	 */
	public ViewClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMpPlayer = new JFrame();
		frmMpPlayer.getContentPane().setBackground(new Color(0, 0, 0));
		frmMpPlayer.getContentPane().setForeground(Color.BLACK);
		frmMpPlayer.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerSoundOn.png")));
		frmMpPlayer.setTitle("Rickards Audio Player");
		frmMpPlayer.setBounds(100, 100, 400, 299);
		frmMpPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMpPlayer.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Now playing:");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setBounds(10, 26, 71, 14);
		frmMpPlayer.getContentPane().add(lblNewLabel);
		
		JLabel lblPlaylist = new JLabel("Playlist:");
		lblPlaylist.setForeground(new Color(255, 140, 0));
		lblPlaylist.setBounds(10, 90, 71, 14);
		frmMpPlayer.getContentPane().add(lblPlaylist);
		
		JLabel textField = new JLabel("");
		textField.setForeground(new Color(255, 140, 0));
		textField.setBounds(94, 26, 225, 14);
		frmMpPlayer.getContentPane().add(textField);
		
		JButton playButton = new JButton("");
		playButton.setBackground(new Color(0, 0, 0));
		playButton.setForeground(new Color(255, 140, 0));
		playButton.setToolTipText("Play/Resume button.");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.play();
				textField.setText(pm.getFileName());
			}
		});
		
		playlist = new JTextField();
		playlist.setHorizontalAlignment(SwingConstants.LEFT);
		playlist.setEditable(false);
		playlist.setBounds(10, 115, 364, 135);
		frmMpPlayer.getContentPane().add(playlist);
		playlist.setColumns(10);
		playButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
		playButton.setBounds(114, 56, 65, 23);
		frmMpPlayer.getContentPane().add(playButton);
		
		JButton pauseButton = new JButton("");
		pauseButton.setBackground(new Color(0, 0, 0));
		pauseButton.setForeground(new Color(255, 140, 0));
		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pause
				pm.pause();
			}
		});
		pauseButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPause.png")));
		pauseButton.setBounds(205, 56, 65, 23);
		frmMpPlayer.getContentPane().add(pauseButton);
		
		JButton stopButton = new JButton("");
		stopButton.setBackground(new Color(0, 0, 0));
		stopButton.setForeground(new Color(255, 140, 0));
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Stop
				pm.stop();
			}
		});
		stopButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerStop.png")));
		stopButton.setBounds(296, 56, 65, 23);
		frmMpPlayer.getContentPane().add(stopButton);
		
		JButton openButton = new JButton("");
		openButton.setBackground(new Color(0, 0, 0));
		openButton.setForeground(new Color(255, 140, 0));
		openButton.setToolTipText("Open a mp3 file to play music");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open a file
				pm.open();
				textField.setText(pm.getFileName());
			}
		});
		openButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerEject.png")));
		openButton.setBounds(20, 56, 65, 23);
		frmMpPlayer.getContentPane().add(openButton);
		
	}
}
