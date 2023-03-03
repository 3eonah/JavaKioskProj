
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import TermProject.Order.menuPanel;
import TermProject.Order.okBtnClicked;
import TermProject.Order.orderTable;
import TermProject.Order.selected;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KioskGUI extends JFrame {
	JPanel menup, orderp, buttonp;
	// components for menu panel
	ImageIcon[] images = { new ImageIcon("./Foodimg/tomatopasta.jpg"), new ImageIcon("./Foodimg/carbonara.jpg"),
			new ImageIcon("./Foodimg/margerita.jpg"), new ImageIcon("./Foodimg/veganpizza.jpg"),
			new ImageIcon("./Foodimg/sandwich.jpg") };
	String[] menuname = { "토마토 파스타", "까르보나라", "마르게리타", "비건피자", "샌드위치" };
	JButton select[] = new JButton[5];

	// JTable components for order panel
	Object ob[][] = new Object[0][1];
	String colname[] = { "주문목록" };
	DefaultTableModel model;
	JTable table;
	String defaultValue[] = { " " };
	JScrollPane scroll;

	// button for button panel
	JButton ok;
	String selected; // 선택된 menuname을 담을 String객체
	ArrayList<String> selecteditem = new ArrayList<String>(); // selected를 담을 String Array

	// Constructor
	public KioskGUI() {
		super("키오스크");

		menup = new menuPanel();
		orderp = new orderTable();
		buttonp = new JPanel();
		// add GUI into button panel
		ok = new JButton("주문하기");
		ok.addActionListener(new okBtnEvent());
		buttonp.add(ok);

		add(menup, BorderLayout.NORTH);
		add(orderp);
		add(buttonp, BorderLayout.SOUTH);

		setSize(600, 600);
		setVisible(true);
	}

	class menuPanel extends JPanel {
		public menuPanel() {
			// set menu panel layout
			GridLayout grid = new GridLayout(0, 4);
			grid.setVgap(5);
			setLayout(grid);

			for (int i = 0; i < images.length; i++) {
				// create panel for each grid
				JPanel gridpane = new JPanel();
				gridpane.setLayout(new BorderLayout());
				// resize the image
				Image img = images[i].getImage();
				Image resizedImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				images[i] = new ImageIcon(resizedImg);
				// add image, menu name and button into grid
				JLabel lb = new JLabel(images[i], JLabel.CENTER);
				gridpane.add("North", lb);
				JLabel name = new JLabel(menuname[i]);
				name.setHorizontalAlignment(JLabel.CENTER);
				gridpane.add("Center", name);
				select[i] = new JButton("선택");
				select[i].addActionListener(new selectedEvent());
				gridpane.add("South", select[i]);
				add(gridpane);
			}
		}

	}

	class orderTable extends JPanel {
		public orderTable() {
			// create JTable
			model = new DefaultTableModel(ob, colname);
			table = new JTable(model);
			scroll = new JScrollPane(table);
			add(scroll);
			// set Default value of the table
			model.addRow(defaultValue);
		}
	}

	// event handler for select button
	class selectedEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (model.getValueAt(0, 0) == " ") {
				//만약에 표에 아무것도 추가되지 않았다면
				//표의 빈칸을 지워라
				model.removeRow(0);
			}

			for (int i = 0; i < menuname.length; i++) {
				if (e.getSource() == select[i]) {
					selected = menuname[i];
					selecteditem.add(selected);

					// add table row
					String row[] = { selected };
					model.addRow(row);

				}

			}

		}
	}
	
	//event handler for ok button
		class okBtnEvent implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==ok) {
					JOptionPane.showMessageDialog(orderp, "주문을 완료했습니다.");
					for(int i=0; i<selecteditem.size(); i++) {
						OrderThread singleT=new OrderThread(selecteditem.get(i));
						Thread t=new Thread(singleT);
						t.setName(selecteditem.get(i));
						t.start();
						
					}
				}
				
			}
			
		}

}
