package graphics;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7929001871259770152L;
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
		Status_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem jmi1 = new  JMenuItem("Learn");
		jmi1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String word = Status_list.getSelectedValue();
				int index = Status_list.getSelectedIndex();
				word=word.substring(0, word.indexOf(" "));
				System.out.println(word);
				Status_ListModel.remove(index);

				FileWriter fw;
				try {
					fw = new FileWriter("dictionary.dat", true);
					fw.append(word+'\n');
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});
		popupMenu.add(jmi1);

		Status_list.addMouseListener(new MouseAdapter() {
		     public void mouseClicked(MouseEvent me) {
		       if (SwingUtilities.isRightMouseButton(me)
		           && !Status_list.isSelectionEmpty()
		           && Status_list.locationToIndex(me.getPoint())
		              == Status_list.getSelectedIndex()) {
		               popupMenu.show(Status_list, me.getX(), me.getY());
		               }
		           }
		        }
		     );
		
		JScrollPane scrollPane2 = new JScrollPane(Status_list);
		scrollPane2.setPreferredSize(new Dimension(310, (int)height-40));
		
		panel.add(scrollPane2);
		
		ImageIcon okIcon = new ImageIcon(this.getClass().getResource("/ok.png"));
		btnProcess.setIcon(okIcon);
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Status_ListModel.clear();
				processor.TextProcessor p = new processor.TextProcessor(editorPane.getText());
				p.process();
				
				String lastword="!!!!";
		        for (String key : p.words.keySet())
		        {
		        	Status_ListModel.addElement(key+" ("+ p.freq.get(key).toString() + ")" );
		        	lastword=key;
		        }
		        if (p.words.size()==1 && lastword.length()==0)
		        	Status_ListModel.clear();
			}
		});
	}
}
