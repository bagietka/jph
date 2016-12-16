import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		contentPane = new JPanel();
		contentPane.setSize( Toolkit.getDefaultToolkit().getScreenSize());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 10));
		
		JButton btnNewButton = new JButton("ACO1");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ACO2");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("ACO3");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Wyczy��");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Autorzy");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authors a = new Authors();
				a.setVisible(true);
			}
		});
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
	}

}
