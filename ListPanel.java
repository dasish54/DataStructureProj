/**
 * This class is responsible for implementing the functions of a List
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

public class ListPanel extends JPanel {
	JPanel innerPanel, operationsPanel, dataStructurePanel, informationPanel;
	/**
	 * The content set within the graphics panel, AN ARRAY OF STRING
	 */
	private static List<String> content = new LinkedList<String>();

	/**
	 * The demo graphics panel instance.
	 */
	private static ListEngine panel = new ListEngine();

	/**
	 * Main method entry point.
	 * 
	 * @param args
	 */
	Integer[] ComboElements = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	/**
	 * The number of elements that have been removed from the list
	 */
	public static int numberElementsRemoved = 0;
	/**
	 * The number of elements that have been added to the list
	 */
    public static int numberOfElements = 0;
	public ListPanel() {

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
        /**
         * Button to add an element to the list
         */
		JButton AddBtn = new JButton("Add");
		operationsPanel.add(AddBtn);
		/**
         * Button to add an element to the list at a specfic index
         */
		JButton AddAtPositionBtn = new JButton("Add at Position");
		operationsPanel.add(AddAtPositionBtn);
		/**
         * Button to get the value at a specfic index
         */
		JButton GetBtn = new JButton("Get");
		operationsPanel.add(GetBtn);
		/**
         * Button to remove an element at a specific element
         */
		JButton RemoveAtPositionBtn = new JButton("Remove At Position");
		operationsPanel.add(RemoveAtPositionBtn);
		/**
         * Button to replace an element
         */
		JButton SetBtn = new JButton("Set (Replace)");
		operationsPanel.add(SetBtn);
		/**
         * Button to display the size of the list
         */
		JButton SizeBtn = new JButton("Size");
		operationsPanel.add(SizeBtn);
		/**
         * Textfield that gets the value for the next element to be added
         */
		JTextField Addtextfield = new JTextField(8);
		operationsPanel.add(Addtextfield);
		/**
         * Combo box to decide the index for the element to be added at 
         */
		JComboBox AddCombo = new JComboBox(ComboElements);
		operationsPanel.add(AddCombo);
		/**
         * Combo box to decide the index to get the value from
         */
		JComboBox GetCombo = new JComboBox(ComboElements);
		operationsPanel.add(GetCombo);
		/**
         * Combo box to decide the index of the element to remove
         */
		JComboBox RemoveCombo = new JComboBox(ComboElements);
		operationsPanel.add(RemoveCombo);
		/**
         * TextBox to decide the value to replace
         */
		JTextField Replacetextfield = new JTextField(8);
		operationsPanel.add(Replacetextfield);
		/**
         * Combo box to decide the index of the element to be replaced
         */
		JComboBox ReplaceCombo = new JComboBox(ComboElements);
		operationsPanel.add(ReplaceCombo);

		/**
         * Label to display the get value 
         */
		JLabel Getlbl = new JLabel();
		operationsPanel.add(Getlbl);
		/**
         * Label to display the size of the list
         */
		JLabel Sizelbl = new JLabel();
		operationsPanel.add(Sizelbl);
		
		/**
         * TextArea to describe the list collection structure 
         */
		JTextArea stackInformation = new JTextArea();
		informationPanel.add(stackInformation);
		stackInformation.setText("A List is a collection structure similar to a Queue but is more flexible.\n Adding and removing of elements can occur at either end of the list or anywhere in the middle, \n this is done by specifying the index. List’s can be ordered by some characteristic of their contents \n such as alphabetical or numbered (Ascending or Descending).\n Unordered list (which are technically ordered) by the order in which the \n user adds the elements to the list. Indexed list where elements are referenced by their \n  numerical position in the list.\nStandard Queue Operations:\n Add-   Adds element at the end of the list\n Add at index-   Adds element at specific index of the list \n Get-  Returns the element at the specified index \n Remove-  Removes the element at the specific index \n Remove Object-  Removes the occurrence of a specified object \n Set-  Replaces the element at a specified index \n Size-   Returns the number of elements in the list");
        
		/**
         * Action Listener for adding an element into the list
         */
		AddBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String text = Addtextfield.getText();
				// extend array size by 1
				// content = Arrays.copyOf(content, content.length + 1);

				// add a new value to end of the array TEXTBOX
				content.add(text);
                numberOfElements = numberOfElements +1;
				// update the 
				panel.setContent(content);
			}
		});
		/**
         * Action Listener for adding an element at a specific position in the list
         */
		AddAtPositionBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String text = Addtextfield.getText();
				int comboboxposition = (int) AddCombo.getSelectedItem();
				
				if(content.size()+ 1 <= comboboxposition){
	            	  try {
						throw new AddAtPositionException("Not a valid index");
					} catch (AddAtPositionException e1) {
						
						JOptionPane.showMessageDialog(topMiddlePanel, "Not a valid index!, Can only add a element between index zero and 1 + current highest index ");
					}
				 }
				else{
				content.add(comboboxposition, text);
	            numberOfElements = numberOfElements +1;
				// update the panel content
				panel.setContent(content);
				}}
		});
		
		/**
         * Action Listener for getting a specific value for a specific index in the list
         */
		GetBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int value;
				 value = (int) GetCombo.getSelectedItem();
			    
				if(value  > content.size() - 1){
	            	  try {
						throw new GetException("Not a valid index");
					} catch (GetException e1) {
						
						JOptionPane.showMessageDialog(topMiddlePanel, "Not a valid index!, there is no element at that index in this List");
					}
				 }
				else{
					String stringvalue = content.get(value);
					Getlbl.setText(stringvalue);
					panel.setContent(content);
				}}
				
			
		});
		//REMOVE AT INDEX X
		RemoveAtPositionBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				int removevalue = (int) RemoveCombo.getSelectedItem();
				
				if(removevalue  > content.size()-1){
	            	  try {
						throw new RemoveAtPositionException("Index does not exist in this List");
					} catch (RemoveAtPositionException e1) {
						
						JOptionPane.showMessageDialog(topMiddlePanel, "Index does not exist in this List");
					}
				 }
				else{
				 content.remove(removevalue);
				 numberElementsRemoved = numberElementsRemoved + 1;
				 panel.setContent(content);
				}
				
			
		}});

		/**
         * Action Listener for replacing an index in a list
         */
		
		SetBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int replaceindex = (int)ReplaceCombo.getSelectedItem();
				
				if(replaceindex  > content.size()-1){
	            	  try {
						throw new SetException("Index does not exist in this List");
					} catch (SetException e1) {
						
						JOptionPane.showMessageDialog(topMiddlePanel, "Index does not exist in this List");
					}
				 }
				else{
				
				String replacestring = Replacetextfield.getText();
				content.set(replaceindex,replacestring);
				
				panel.setContent(content);
				}}
				
			
		});
		/**
         * Action Listener for getting the size of the list
         */
		SizeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int size = content.size();
				String sizestring = Integer.toString(size);
				Sizelbl.setText("Size of List is: "+ sizestring);
				panel.setContent(content);
				}
				
			
		});
		
		
	}
	/**
     * Method that empty's the contents of the list
     */ 
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