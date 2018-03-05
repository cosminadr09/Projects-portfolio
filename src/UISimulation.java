import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UISimulation extends JFrame {

	private JPanel contentPane;
	private JLabel noOfClientsLabel = new JLabel("Nr taskuri:");
	private JLabel noOfServersLabel = new JLabel("Nr servere:");
	private final JTextField textField = new JTextField(" ");
	private final JTextField noOfClientstextField = new JTextField();
	private final JTextField noOfServerstextField = new JTextField();
	public String strServere = new String();
	public String strClienti = new String();
	public String strTimpMaxim = new String();
	private final JButton btnStartSimulation = new JButton("Start Simulation");
	public static int nrServere, nrClienti, timpMaxim;
	private final JLabel lblServer = new JLabel("Server 1");
	private final JLabel lblServer_1 = new JLabel("Server 2");
	private final JLabel lblServer_2 = new JLabel("Server 3");
	public static JTextArea textArea0 = new JTextArea();
	public static JTextArea textArea1 = new JTextArea();
	public static JTextArea textArea2 = new JTextArea();
	private final JLabel lblTaskuriProcesate = new JLabel("Taskuri procesate");
	public static JTextArea textAreaProcesate = new JTextArea();
	private JTextField timpMaximtextField = new JTextField();
	JLabel lblTimpulMaxim = new JLabel("Timpul maxim:");

	/**
	 * Create the frame.
	 */
	public UISimulation() {
		noOfServerstextField.setColumns(10);
		noOfClientstextField.setColumns(10);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnStartSimulation, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnStartSimulation, -161, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea2, 418,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea2, -23,
				SpringLayout.WEST, textAreaProcesate);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textAreaProcesate, 0,
				SpringLayout.NORTH, textArea0);
		sl_contentPane.putConstraint(SpringLayout.WEST, textAreaProcesate, 622,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textAreaProcesate, -10,
				SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea1, 16,
				SpringLayout.EAST, textArea0);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea1, -17,
				SpringLayout.WEST, textArea2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea0, 6,
				SpringLayout.SOUTH, lblServer);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea0, 5,
				SpringLayout.WEST, noOfClientsLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea0, 0,
				SpringLayout.EAST, noOfClientstextField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea2, 6,
				SpringLayout.SOUTH, lblServer_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea1, 6,
				SpringLayout.SOUTH, lblServer_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTaskuriProcesate,
				0, SpringLayout.SOUTH, lblServer);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTaskuriProcesate,
				-78, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblServer_2, 0,
				SpringLayout.NORTH, lblServer);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblServer_2, 147,
				SpringLayout.EAST, lblServer_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblServer_1, 0,
				SpringLayout.NORTH, lblServer);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblServer_1, 149,
				SpringLayout.EAST, lblServer);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblServer, 74,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblServer, 0,
				SpringLayout.WEST, noOfClientstextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, noOfServerstextField,
				0, SpringLayout.EAST, noOfClientstextField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, noOfClientstextField,
				-3, SpringLayout.NORTH, noOfClientsLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, noOfClientstextField,
				13, SpringLayout.EAST, noOfClientsLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6,
				SpringLayout.EAST, noOfServersLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, noOfClientsLabel, 15,
				SpringLayout.SOUTH, noOfServersLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, noOfClientsLabel, 0,
				SpringLayout.WEST, noOfServersLabel);
		contentPane.setLayout(sl_contentPane);

		contentPane.add(noOfClientsLabel);
		contentPane.add(noOfServersLabel);

		contentPane.add(noOfClientstextField);

		contentPane.add(noOfServerstextField);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTimpulMaxim, 4, SpringLayout.NORTH, btnStartSimulation);
		contentPane.add(lblTimpulMaxim);
		
		//timpMaximtextField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, timpMaximtextField, 308, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTimpulMaxim, -7, SpringLayout.WEST, timpMaximtextField);
		sl_contentPane.putConstraint(SpringLayout.NORTH, timpMaximtextField, 0, SpringLayout.NORTH, btnStartSimulation);
		contentPane.add(timpMaximtextField);
		timpMaximtextField.setColumns(10);

		btnStartSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				strClienti = noOfClientstextField.getText();
				nrClienti = Integer.parseInt(strClienti);

				strServere = noOfServerstextField.getText();
				nrServere = Integer.parseInt(strServere);
				
				strTimpMaxim = timpMaximtextField.getText();
				timpMaxim = Integer.parseInt(strTimpMaxim);

				System.out.println("Nr clienti " + nrClienti + " nr servere "
						+ nrServere + "timpul maxim "+ timpMaxim);

				TrySimulationManager gen = new TrySimulationManager();

				Thread t = new Thread(gen);
				t.start();

			}
		});

		contentPane.add(btnStartSimulation);

		contentPane.add(lblServer);

		contentPane.add(lblServer_1);

		contentPane.add(lblServer_2);

		contentPane.add(textArea0);

		contentPane.add(textArea1);

		contentPane.add(textArea2);

		contentPane.add(lblTaskuriProcesate);

		contentPane.add(textAreaProcesate);
		
		
		
		
		

	}
}
