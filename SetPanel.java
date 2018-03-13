/**
 * This class is responsible for implementing the functions of a Set
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

public class SetPanel extends JPanel {
	JPanel innerPanel, operationsPanel, dataStructurePanel, informationPanel;
	/**
	 * The content set within the graphics panel, AN ARRAY OF STRING
	 */
	private static List<String> content = new LinkedList<String>();

	/**
	 * The demo graphics panel instance.
	 */
	private static SetEngine panel = new SetEngine();

	/**
	 * Main method entry point.
	 * 
	 * @param args
	 */
	Integer[] ComboElements = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	/**
	 * The number of elements that have been removed from the set
	 */
	public static int numberElementsRemoved = 0;
	/**
	 * The number of elements that have been added to the set
	 */
    public static int numberOfElements = 0;
	public SetPanel() {

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

		JButton AddBtn = new JButton("Add");
		operationsPanel.add(AddBtn);
		JButton ClearBtn = new JButton("Clear");
		operationsPanel.add(ClearBtn);
		JButton ContainsBtn = new JButton("Contains");
		operationsPanel.add(ContainsBtn);
		JButton HashCodeBtn = new JButton("Hash Code");
		operationsPanel.add(HashCodeBtn);
		JButton EmptyBtn = new JButton("Is Empty?");
		operationsPanel.add(EmptyBtn);
		JButton SizeBtn = new JButton("Size");
		operationsPanel.add(SizeBtn);

		JTextField Addtextfield = new JTextField(8);
		operationsPanel.add(Addtextfield);
		
		JTextField Containstextfield = new JTextField(8);
		operationsPanel.add(Containstextfield);
		



		JLabel Hashlbl = new JLabel();
		operationsPanel.add(Hashlbl);
		JLabel IsEmptylbl = new JLabel();
		operationsPanel.add(IsEmptylbl);
		JLabel Sizelbl = new JLabel();
		operationsPanel.add(Sizelbl);
		JLabel Containslbl = new JLabel();
		operationsPanel.add(Containslbl);
		

		JTextArea stackInformation = new JTextArea();
		informationPanel.add(stackInformation);
		stackInformation.setText("A set is another collection structure which has no order or link between any elements.\n A set cannot have any duplicates, therefore the primary purpose of a set is to determine whether or not \n a particular element is a member.\n\nStandard set operations: \n Add-  Adds an element to the set if the element is not already present. \nClear- Removes all of the elements from the current set.\nContains- Evaluates whether the set contains the specified element.\nHash code-  Returns the hash code for the specified set.\nIs Empty-  Will determine whether the set is empty, returns true or false.\nRemove All- Removes from this set all the elements that are contained in specified collection.\nRetain All-  Retains all of the elements in this set that are contained in specified collection.\nSize- Returns the number of elements in the set.\n");
		
		AddBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String text = Addtextfield.getText();
				// extend array size by 1
				// content = Arrays.copyOf(content, content.length + 1);

				// add a new value to end of the array TEXTBOX
				content.add(text);
                numberOfElements = numberOfElements +1;
				// update the panel
				panel.setContent(content);
			}
		});
		
		ClearBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(content.size() == 0){
	            	  try {
						throw new ClearException("Cannot clear an empty set");
					} catch (ClearException e1) {
						
						JOptionPane.showMessageDialog(topMiddlePanel, "Cannot clear an empty set");
					}
				 }
				else{
				
				content.clear();
                
				// update the panel
				panel.setContent(content);
			}}
		});
		
		
		ContainsBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String text = Containstextfield.getText();
				

				if (true == content.contains(text)){
					Containslbl.setText("True");
					}
				else {
					Containslbl.setText("False");
				}
                
				// update the panel
				panel.setContent(content);
			}
		});
		
		HashCodeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String HashCode;
				
				HashCode = Integer.toString(content.hashCode());
				
				Hashlbl.setText(HashCode);
				// update the panel
				panel.setContent(content);
			}
		});
		
		EmptyBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(true == content.isEmpty()){
					IsEmptylbl.setText("True");
				}
				else {
					IsEmptylbl.setText("False");
				}
				// update the panel
				panel.setContent(content);
			}
		});
		
		SizeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String size = Integer.toString(content.size());
				
				Sizelbl.setText(size);
				// update the panel
				panel.setContent(content);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		

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
