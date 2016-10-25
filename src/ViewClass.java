
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

public class ViewClass extends PlayerMethods{

	JFrame frmMpPlayer;
	private JTextField textField;
	PlayerMethods pm = new PlayerMethods();


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
		frmMpPlayer.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerSoundOn.png")));
		frmMpPlayer.setTitle("Mp3 Player");
		frmMpPlayer.setBounds(100, 100, 400, 150);
		frmMpPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMpPlayer.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Now playing:");
		lblNewLabel.setBounds(10, 26, 71, 14);
		frmMpPlayer.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		
		textField.setBounds(87, 23, 245, 20);
		frmMpPlayer.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton playButton = new JButton("Play");
		playButton.setToolTipText("Play/Resume button.");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.play();
				textField.setText(pm.getFileName());
			}
		});
		playButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
		playButton.setBounds(99, 69, 89, 23);
		frmMpPlayer.getContentPane().add(playButton);
		
		JButton pauseButton = new JButton("Pause");
		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pause
				pm.pause();
			}
		});
		pauseButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPause.png")));
		pauseButton.setBounds(196, 69, 89, 23);
		frmMpPlayer.getContentPane().add(pauseButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Stop
				pm.stop();
			}
		});
		stopButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerStop.png")));
		stopButton.setBounds(295, 69, 89, 23);
		frmMpPlayer.getContentPane().add(stopButton);
		
		JButton openButton = new JButton("Open");
		openButton.setToolTipText("Open a mp3 file to play music");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open a file
				pm.open();
				textField.setText(pm.getFileName());
			}
		});
		openButton.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerEject.png")));
		openButton.setBounds(0, 69, 89, 23);
		frmMpPlayer.getContentPane().add(openButton);
	}
}
