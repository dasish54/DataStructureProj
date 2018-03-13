import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class layoutClass extends JPanel {
JPanel informationPanel, operationsPanel, dataStructurePanel ;
	public layoutClass() {

		/**
		 * informationPanel used to describe each data structure
		 */
		 informationPanel = new JPanel();
		 /**
		  * operationsPanel operations will have the data structures operations
		  */
		 operationsPanel = new JPanel();
		 /**
		  * dataStructurePanel will have the drawings
		  */
		 dataStructurePanel = new JPanel();
		

		
		operationsPanel.setBackground(Color.blue);
		JLabel operationsHeader = new JLabel();
		operationsHeader.setText("Operations");
		operationsPanel.add(operationsHeader);

		dataStructurePanel.setBackground(Color.red);
		JLabel dataHeader = new JLabel();
		dataHeader.setText("Data Structure Contents");
		dataStructurePanel.add(dataHeader);
		

		

		informationPanel.setBackground(Color.yellow);
		JLabel infoHeader = new JLabel();
		infoHeader.setText("Information");
		informationPanel.add(infoHeader);

		

		

	}
    /**
     * 
     * @return returns the information panel for information to be added
     */
	public JPanel getinformationPanel() {
		return informationPanel;
	}
	/**
	 * 
	 * @return returns the operations panel for the operations to be added
	 */
	public JPanel getoperationsPanel() {
		return operationsPanel;
	}
	/**
	 * 
	 * @return returns the data structure panel
	 */
	public JPanel getdataStructurePanel() {
		return dataStructurePanel;
	}

}