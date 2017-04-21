package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JList;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight()-104;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, (int)width, (int)height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea editorPane = new JTextArea();
		editorPane.setBounds(6, 6, (int)width-350, (int)height-100);
		contentPane.add(editorPane);
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setBounds(6, 6, (int)width-350, (int)height-100);
		contentPane.add(scrollPane);
		
		JButton btnProcess = new JButton("Process");
		btnProcess.setBounds(4, (int)height-95, (int)width-346, 70);
		contentPane.add(btnProcess);
		
		JPanel panel = new JPanel();
		panel.setBounds((int)width-340, 6, 335, (int)height-35);
		contentPane.add(panel);

		DefaultListModel<String> Status_ListModel=new DefaultListModel<>();
		JList<String> Status_list = new JList<String>(Status_ListModel);
		//Status_list.setFixedCellWidth(295);
		
		JScrollPane scrollPane2 = new JScrollPane(Status_list);
		//scrollPane2.setBounds((int)width-340, 6, 300, (int)height-35);
		scrollPane2.setPreferredSize(new Dimension(310, (int)height-40));
		
		panel.add(scrollPane2);
		//Status_ListModel.addElement("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");
		Status_ListModel.addElement("zzz");


		
	}
}
