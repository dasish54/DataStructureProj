import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class stackPanel extends JPanel {
	JPanel innerPanel, operationsPanel, dataStructurePanel, informationPanel;
	/**
	 * The content set within the graphics panel, AN ARRAY OF STRING
	 */
	private static String[] content = new String[] {};

	/**
	 * The demo graphics panel instance.
	 */
	private static DemoPanel panel = new DemoPanel();

	/**
	 * Main method entry point.
	 * 
	 * @param args
	 */

	public stackPanel() {

		layoutClass layout = new layoutClass();
		// layout.add(layout.getoperationsPanel());

		operationsPanel = layout.getoperationsPanel();
		// dataStructurePanel = layout.getdataStructurePanel();
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

		JButton pushBtn = new JButton("Push");
		operationsPanel.add(pushBtn);
		JButton peekBtn = new JButton("Peek");
		operationsPanel.add(peekBtn);
		JButton popBtn = new JButton("Pop");
		operationsPanel.add(popBtn);
		JTextField textfield = new JTextField(8);
		operationsPanel.add(textfield);
		JTextField peektextfield = new JTextField(8);
		operationsPanel.add(peektextfield);
		JTextArea stackInformation = new JTextArea();
        informationPanel.add(stackInformation);
        stackInformation.setText("A stack is a data structure used to store a collection of objects, individual \n items can be added onto a stack from the top using a push operation and taken from the stack \n using a pop operation.  When an item is added (pushed) onto a stack it can only be added \n to the top and when an item is taken (popped) from the stack it can also only be taken \n from the top. A Stack is a FILO (First in Last Out) data structure. \n \n Stack Operations \n Push- Add an item to the stack \n Pop- Remove an item from the stack \n Peek- View the value of the item on top of the stack");
        
		pushBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String text = textfield.getText();
				// extend array size by 1
				content = Arrays.copyOf(content, content.length + 1);

				// add a new value to end of the array TEXTBOX
				content[content.length - 1] = text;

				// update the panel content
				panel.setContent(content);
			}

		});

		peekBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)  {
				
					String peekvalue = content[content.length - 1];

					peektextfield.setText(peekvalue);
				
				
			}
		});

		popBtn.addActionListener(new ActionListener() {

			public void actionPerformed (ActionEvent e) {
	
              if(content.length == 0){
            	  try {
					throw new popException("Cannot pop an empty stack");
				} catch (popException e1) {
					
					JOptionPane.showMessageDialog(topMiddlePanel, "Cannot pop an empty stack");
				}
              
              }
				content = Arrays.copyOf(content, content.length - 1);

				panel.setContent(content);
              
           
           
        	   
           
			
			}});
		
		
		
		

	}
    


	public JPanel getCpPanel() {
		return innerPanel;
	}
	
	

}
