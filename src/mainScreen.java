import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.TextArea;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.AbstractListModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.Choice;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class mainScreen {

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_4;
	private Choice choice ;
	private JSpinner spinner;

	private JCheckBox chckbxYnet ;
	private JCheckBox chckbxTheMarker;
	private JCheckBox chckbxBloomberg;
	private JCheckBox chckbxReuters;
	private JCheckBox chckbxGlobes;
	private JTextPane txtpnStartDate;
	private JTextPane txtpnEndDate;
	private JTextField txtstart;
	private JTextField txtend;

	private static JButton btnStart;
	private JPanel panel_2;
	private JPanel panel_3;

	private static JTextArea log;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainScreen window = new mainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),}));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, "2, 2, fill, fill");
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),}));

		JTextPane txtpnTextToSearch_1 = new JTextPane();
		txtpnTextToSearch_1.setDisabledTextColor(Color.BLACK);
		txtpnTextToSearch_1.setCaretColor(Color.BLACK);
		txtpnTextToSearch_1.setBackground(new Color(255, 255, 255));
		txtpnTextToSearch_1.setForeground(new Color(0, 0, 0));
		txtpnTextToSearch_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnTextToSearch_1.setEditable(false);
		txtpnTextToSearch_1.setEnabled(false);
		txtpnTextToSearch_1.setText("Text to search");
		panel_1.add(txtpnTextToSearch_1, "2, 2, center, center");

		textField_4 = new JTextField();
		panel_1.add(textField_4, "4, 2, fill, default");
		textField_4.setColumns(10);

		JTextPane txtpnTextToCompare_1 = new JTextPane();
		txtpnTextToCompare_1.setDisabledTextColor(Color.BLACK);
		txtpnTextToCompare_1.setCaretColor(Color.BLACK);
		txtpnTextToCompare_1.setBackground(new Color(255, 255, 255));
		txtpnTextToCompare_1.setForeground(Color.BLACK);
		txtpnTextToCompare_1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnTextToCompare_1.setEditable(false);
		txtpnTextToCompare_1.setEnabled(false);
		txtpnTextToCompare_1.setText("Keywords");
		panel_1.add(txtpnTextToCompare_1, "2, 4, center, center");

		textField_2 = new JTextField();
		panel_1.add(textField_2, "4, 4, fill, default");
		textField_2.setColumns(10);

		JTextPane txtpnNumberOfReports = new JTextPane();
		txtpnNumberOfReports.setDisabledTextColor(Color.BLACK);
		txtpnNumberOfReports.setCaretColor(Color.BLACK);
		txtpnNumberOfReports.setBackground(new Color(255, 255, 255));
		txtpnNumberOfReports.setForeground(new Color(0, 0, 0));
		txtpnNumberOfReports.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnNumberOfReports.setEditable(false);
		txtpnNumberOfReports.setEnabled(false);
		txtpnNumberOfReports.setText("Number of reports");
		panel_1.add(txtpnNumberOfReports, "2, 6, center, center");

		spinner = new JSpinner();
		panel_1.add(spinner, "4, 6");

		txtpnStartDate = new JTextPane();
		txtpnStartDate.setDisabledTextColor(Color.BLACK);
		txtpnStartDate.setBackground(new Color(255, 255, 255));
		txtpnStartDate.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnStartDate.setForeground(Color.WHITE);
		txtpnStartDate.setEditable(false);
		txtpnStartDate.setEnabled(false);
		txtpnStartDate.setText("start date (dd/mm/yyyy)");
		panel_1.add(txtpnStartDate, "2, 10, center, center");

		txtstart = new JTextField();
		txtstart.setText("");
		panel_1.add(txtstart, "4, 10, fill, default");
		txtstart.setColumns(10);

		txtpnEndDate = new JTextPane();
		txtpnEndDate.setDisabledTextColor(Color.BLACK);
		txtpnEndDate.setBackground(new Color(255, 255, 255));
		txtpnEndDate.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnEndDate.setForeground(Color.WHITE);
		txtpnEndDate.setEditable(false);
		txtpnEndDate.setEnabled(false);
		txtpnEndDate.setText("end date (dd/mm/yyyy)");
		panel_1.add(txtpnEndDate, "2, 12, center, center");

		txtend = new JTextField();
		txtend.setText("");
		panel_1.add(txtend, "4, 12, fill, default");
		txtend.setColumns(10);


		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "4, 2, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
				new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,}));

		chckbxYnet = new JCheckBox("Ynet");
		chckbxYnet.setFocusable(false);
		chckbxYnet.setBackground(Color.WHITE);
		panel.add(chckbxYnet, "2, 2");

		chckbxTheMarker = new JCheckBox("The Marker");
		chckbxTheMarker.setFocusable(false);
		chckbxTheMarker.setBackground(Color.WHITE);
		panel.add(chckbxTheMarker, "2, 4");

		chckbxBloomberg = new JCheckBox("Bloomberg");
		chckbxBloomberg.setFocusable(false);
		chckbxBloomberg.setBackground(Color.WHITE);
		panel.add(chckbxBloomberg, "2, 6");

		chckbxReuters = new JCheckBox("Reuters");
		chckbxReuters.setFocusable(false);
		chckbxReuters.setBackground(Color.WHITE);
		panel.add(chckbxReuters, "2, 8");

		chckbxGlobes = new JCheckBox("Globes");
		chckbxGlobes.setFocusable(false);
		chckbxGlobes.setBackground(Color.WHITE);
		panel.add(chckbxGlobes, "2, 10");


		choice = new Choice();
		choice.setFocusable(false);
		choice.add("Regular");
		choice.add("Title");
		choice.add("Body");
		choice.add("Comments");
		panel.add(choice, "2, 14");

		btnStart = new JButton("Start");
		btnStart.setFocusable(false);


		btnStart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)  {

				btnStart.setEnabled(false);


				Thread thread = new Thread() {
					public void run(){

						String tts = textField_4.getText();
						//						String ttse = textField_3.getText();
						String ttc = textField_2.getText();
						//						String ttce = textField_1.getText();
						String sdt = txtstart.getText();
						String edt = txtend.getText();


						String selected = choice.getSelectedItem();

						int noa = (Integer) spinner.getValue();
						SearchState state = SearchState.regular;
						if(selected.equals("Regular"))
							state = SearchState.regular;
						if(selected.equals("Title"))
							state = SearchState.headline;
						if(selected.equals("Body"))
							state = SearchState.body;
						if(selected.equals("Comments"))
							state = SearchState.comment;

						boolean[] sites = {chckbxYnet.isSelected()
								,chckbxTheMarker.isSelected()
								,chckbxBloomberg.isSelected()
								,chckbxReuters.isSelected()
								,chckbxGlobes.isSelected()
						};


						System.out.println("tts: "+tts);
						//						System.out.println("ttse: "+ttse);
						System.out.println("ttc: "+ttc);
						//						System.out.println("ttce: "+ttce);
						System.out.println("stat: "+selected);
						System.out.println("sdt: "+sdt);
						System.out.println("edt: "+edt);
						System.out.println(Arrays.toString(sites));

						Main.starter(tts, "Trump", ttc, "Trump", state, sdt, edt, noa, sites);
					}
				};
				thread.start();
			}
		});

		panel.add(btnStart, "2, 18");



		panel_2 = new JPanel();
		panel_2.setFocusable(false);
		panel_2.setDoubleBuffered(false);
		panel_2.setEnabled(false);
		panel_2.setBackground(Color.WHITE);
		//		frame.getContentPane().add(panel_2, "2, 3, 1, 6, fill, fill");
		frame.getContentPane().add(panel_2, "2, 4, 1, 5, right, top");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {

				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
		},
				new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),

		}));


		JTextPane jtp = new JTextPane();
		jtp.setDisabledTextColor(Color.BLACK);
		jtp.setCaretColor(Color.BLACK);
		jtp.setBackground(new Color(255, 255, 255));
		jtp.setForeground(new Color(0, 0, 0));
		jtp.setFont(new Font("Arial", Font.PLAIN, 11));
		jtp.setEditable(false);
		jtp.setEnabled(false);
		jtp.setText("log:");
		panel_2.add(jtp, "2, 2, center, center");


		/////////////////////



		//		    JTextArea display = new JTextArea ( 16, 58 );
		//		    display.setEditable ( false ); // set textArea non-editable


		// My code
		//		    JFrame frame = new JFrame ();
		//		    frame.add ( panel_3 );
		//		    frame.pack ();
		//		    frame.setLocationRelativeTo ( null );
		//		    frame.setVisible ( true );



		panel_3 = new JPanel();
		//		frame.getContentPane().add(panel_2, "2, 3, 1, 6, fill, fill");
		frame.getContentPane().add(panel_3, "4, 4, 1, 2, left, top");
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),}));

		log = new JTextArea(3, 20 );
		log.setAlignmentY(Component.TOP_ALIGNMENT);
		log.setAlignmentX(Component.LEFT_ALIGNMENT);
		log.setDisabledTextColor(Color.BLACK);
		log.setFont(new Font("Arial", Font.PLAIN, 11));
		log.setWrapStyleWord(true);
		log.setFocusable(false);
		log.setEnabled(false);
		log.setEditable(false);
		log.setDisabledTextColor(SystemColor.activeCaption);
		log.setText("");
		panel_3.add(log, "2, 2, left, top");


		JScrollPane scroll = new JScrollPane ( log );
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		panel_3.add(scroll, "2, 2, left, top");
	}

	public static void addToLog(String message){
		if(log != null){
			String past = log.getText();
			String nm = past + '\n' + message;
			log.setText(nm);

			if(message.contains("Done"))
				btnStart.setEnabled(true);	
		}
	}



	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
