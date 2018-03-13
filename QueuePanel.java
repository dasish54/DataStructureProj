/**
 * This class is responsible for implementing the functions of a Queue
 * @author John Sharp
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QueuePanel extends JPanel {
	JPanel innerPanel, operationsPanel, dataStructurePanel, informationPanel;
	/**
	 * The content set within the graphics panel, AN ARRAY OF STRING
	 */
	private static Queue<String> content = new LinkedList<String>();

	/**
	 * The demo graphics panel instance.
	 */
	private static QueueEngine panel = new QueueEngine();

	/**
	 * Main method entry point.
	 * 
	 * @param args
	 */
	
	/**
	 * The number of elements that have been DeQueued
	 */
	public static int numberElementsRemoved = 0;
	/**
	 * The number of elements that have been added to the queue
	 */
    public static int numberOfElements = 0;
	public QueuePanel() {

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
         * Button which adds elements onto the queue
         */
		JButton EnQueueBtn = new JButton("EnQueue");
		operationsPanel.add(EnQueueBtn);
		/**
         * Button which removes elements from the queue
         */
		JButton DeQueueBtn = new JButton("DeQueue");
		operationsPanel.add(DeQueueBtn);
		/**
         * Button which gets the contents of the first element from the queue
         */
		JButton FirstBtn = new JButton("First");
		operationsPanel.add(FirstBtn);
		/**
         * Button which checks whether the contents of the queue is null
         */
		JButton IsEmptyBtn = new JButton("IsEmpty");
		operationsPanel.add(IsEmptyBtn);
		/**
         * Button which calculates the size of the queue
         */
		JButton SizeBtn = new JButton("Size");
		operationsPanel.add(SizeBtn);
		/**
         * Button which prints the contents of the queue as a string
         */
		JButton ToStringBtn = new JButton("ToString");
		operationsPanel.add(ToStringBtn);
		/**
         * TextField which gets the content to add to the queue
         */
		JTextField EnQueuetextfield = new JTextField(8);
		operationsPanel.add(EnQueuetextfield);
		/**
         * Label that displays the first element in the queue
         */
		JLabel Firstlbl = new JLabel();
		operationsPanel.add(Firstlbl);
		/**
         * Label that displays the size of the queue
         */
		JLabel Sizelbl = new JLabel();
		operationsPanel.add(Sizelbl);
		/**
         * Label that displays whether the queue is empty
         */
		JLabel Emptylbl = new JLabel();
		operationsPanel.add(Emptylbl);
		/**
         * Label that displays the contents of the queue as a string
         */
		JLabel Stringlbl = new JLabel();
		operationsPanel.add(Stringlbl);

		JTextArea stackInformation = new JTextArea();
		informationPanel.add(stackInformation);
		stackInformation.setText("A Queue is a collection structure where elements are added at one end and removed from the other.\n This is very much like a queue at the supermarket where you join at one end and leave at the other. \nThis is therefore a FIFO (First In First Out) data structure, elements are removed in the same order \n  that they arrive in. \n \n Standard Queue Operations:\n EnQueue-  Adds an elements at the end of the queue \n DeQueue-  Removes elements from the beginning of the queue \n First-  Examines the element at the front of the queue \n IsEmpty-  Determines if the queue is empty \n Size-  Determines the number \n ToString-  Returns a string representation of the queue");
        /**
         * Action listener for adding an element onto the queue
         */
		EnQueueBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String text = EnQueuetextfield.getText();
				// extend array size by 1
				// content = Arrays.copyOf(content, content.length + 1);

				// add a new value to end of the array TEXTBOX
				content.add(text);
                numberOfElements = numberOfElements +1;
				// update the panel content
				panel.setContent(content);
			}
		});
		/**
         * Action listener for removing an element from the queue
         */
		DeQueueBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 if(content.size() == 0){
	            	  try {
						throw new DeQueueException("Cannot DeQueue an empty Queue");
					} catch (DeQueueException e1) {
						
						JOptionPane.showMessageDialog(topMiddlePanel, "Cannot DeQueue an empty Queue");
					}
				 }
				 else 
				{   
				content.remove();
				numberElementsRemoved = numberElementsRemoved + 1;

				panel.setContent(content);
			}
			}
		});
		/**
         * Action listener for getting the first value of the queue
         */
		FirstBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 if(content.size() == 0){
	            	  try {
						throw new FirstException("No first in an empty Queue");
					} catch (FirstException e1) {
						
						JOptionPane.showMessageDialog(topMiddlePanel, "No first in an empty Queue");
					}}
	            	  else	  {
				String first = content.peek();
				Firstlbl.setText(first);

				panel.setContent(content);
	            	  }
			}
		});
		/**
         * Action listener for calculating the size of the queue
         */
		SizeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int size = content.size();
				String sizeString = Integer.toString(size);
				Sizelbl.setText(sizeString);

			}
		});
       
		IsEmptyBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (content.size() == 0) {
					Emptylbl.setText("Queue is empty");
				} else {
					Emptylbl.setText("Queue is NOT empty");
				}

			}
		});

		ToStringBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(content.size() == 0){
	            	  try {
						throw new ToStringException("Cannot ToString an empty Queue");
					} catch (ToStringException e1) {
						
						JOptionPane.showMessageDialog(topMiddlePanel, "Cannot ToString an empty Queue");
					}}
	            	  else	  {
				String queueString = "";
				for (String item : content) {
					queueString = queueString + item.toString();

				}
				Stringlbl.setText(queueString);

			}}
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

