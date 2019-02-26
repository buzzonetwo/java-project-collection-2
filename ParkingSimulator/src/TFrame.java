import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TFrame frame = new TFrame();
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
	public TFrame() {
		final Accessor bridge = new Accessor(new DList<Database>());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][100px][][][][][][][][grow,fill][][43.00]", "[][60,grow][]"));
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, "cell 1 0 9 1");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 1 10 1,grow");
		contentPane.add(btnNewButton, "cell 0 2,growx");
		
		JButton btnDetailedInfo = new JButton("Detailed Info");
		contentPane.add(btnDetailedInfo, "cell 1 2");
		btnDetailedInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoFrame details = new InfoFrame();
				details.setVisible(true);
			}
		});

		final JButton btnNewButton_2 = new JButton("New Lot");
		contentPane.add(btnNewButton_2, "cell 2 2");
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt files", "txt");
		fc.setFileFilter(filter);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_2) {
					int returnVal = fc.showOpenDialog(TFrame.this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						try {
							bridge.addDB(Reader.createdbfromFile(file));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							System.out.println("Ds");
						}
					}			
				}
			}
		});
		
		
		JButton btnNewButton_1 = new JButton(">");
		contentPane.add(btnNewButton_1, "cell 11 2,growx");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

}
