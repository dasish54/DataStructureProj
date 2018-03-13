/**
 * This class is responsible for implementing the functions of a Tree
 * @author John Sharp
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TreePanel extends JPanel {
	JPanel innerPanel, operationsPanel, dataStructurePanel, informationPanel;
	/**
	 * The content set within the graphics panel, AN ARRAY OF STRING
	 */
	private static List<String> content = new LinkedList<String>();

	/**
	 * The demo graphics panel instance.
	 */
	private static TreeEngine panel = new TreeEngine();

	/**
	 * Main method entry point.
	 * 
	 * @param args
	 */
	Integer[] ComboElements = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	/**
	 * The number of elements that have been removed from the tree
	 */
	public static int numberElementsRemoved = 0;
	/**
	 * The number of elements that have been added to the tree
	 */
    public static int numberOfElements = 0;
	public TreePanel() {

		layoutClass layout = new layoutClass();
		// layout.add(layout.getoperationsPanel());
        
		/**
         * Instance of the operations panel which will contain the buttons
         */
		operationsPanel = layout.getoperationsPanel();
		/**
         * Instance of the information panel, which contains text about the data structure
         */
		informationPanel = layout.getinformationPanel();

		innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(2, 1));
		layout.add(innerPanel);

		JPanel topMiddlePanel = new JPanel();

		topMiddlePanel.setLayout(new GridLayout(1, 2));
		topMiddlePanel.add(operationsPanel);
		topMiddlePanel.add(panel);
		JLabel dataStructurelbl = new JLabel("Data Structure Contents");
		panel.add(dataStructurelbl);

		innerPanel.add(topMiddlePanel);
		innerPanel.add(informationPanel);

		JButton InsertBtn = new JButton("Insert");
		operationsPanel.add(InsertBtn);
		JButton FindBtn = new JButton("Find");
		operationsPanel.add(FindBtn);
		JButton DeleteBtn = new JButton("Delete");
		operationsPanel.add(DeleteBtn);
		JButton DisplayBtn = new JButton("Display");
		operationsPanel.add(DisplayBtn);

		


		JLabel Displaylbl = new JLabel();
		operationsPanel.add(Displaylbl);
		
		JTextField Inserttextfield = new JTextField(8);
		operationsPanel.add(Inserttextfield);
		

		JTextArea stackInformation = new JTextArea();
		informationPanel.add(stackInformation);
		stackInformation.setText("A binary tree is a data structure made up of nodes where each node will \n usually have a left and right reference and a data element. The data element is the\n data held in itself. The node at the top of the tree is called the root node and the nodes \n branch down from the root node, like a tree. Every node apart from the root \nnode comes from another node (parent node), then a node can be connected\n to a node down a level (child nodes). \nBinary Tree Operations:\nInserting  and Searching- The process for inserting and sorting is very similar,\n it begins at the root node, if the key is not equal to that of the root node we go right \n of left depending on whether the key is greater or less the root node,  until we reach \n an external node and add it as a left of right child or in the case of searching we \n find a node equal to our key. There is a worst case runtime of O(n) where n is the height of \n the tree. For example is the height of the tree was 8, we would have to check a maximum \n of 8 nodes until we found the position to put the node or we didn’t find the node we\n were searching for. Inserting and searching have an average runtime of O(log n) where n \n is the height of the tree, base 10 is assumed.");

		
		
	}
		
	public static void EmptyContent() {
		content.clear();
		
		panel.setContent(content);
	}
	
	public JPanel getCpPanel() {
		return innerPanel;
	}

	public int getnumberElementsRemoved() {
		return numberElementsRemoved;

	}

	

}
