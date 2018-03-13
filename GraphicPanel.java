import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class GraphicPanel {
	public JMenuBar menubar;
	public JMenuItem empty, about, exit;
	public JPanel topPanel, a;
	public JTabbedPane tabbedPane;
	
	public GraphicPanel() {
		
		
		menubar = new JMenuBar();
		
		
		JMenu file = new JMenu("Options");
		menubar.add(file);
		
        
		JMenuItem empty = new JMenuItem("Empty" );
		file.add(empty);
		empty.addActionListener(new EmptyApp());
		
		
		JMenuItem about = new JMenuItem("About");
		file.add(about);
		about.addActionListener(new AboutApp());
		
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		exit.addActionListener(new ExitApp());
		
		stackPanel stackPanel = new stackPanel();
		stackPanel.setLayout(new GridLayout(1, 1));
		stackPanel.add(stackPanel.getCpPanel());
		
		QueuePanel QueuePanel = new QueuePanel();
		QueuePanel.setLayout(new GridLayout(1, 1));
		QueuePanel.add(QueuePanel.getCpPanel());
		
		ListPanel ListPanel = new ListPanel();
		ListPanel.setLayout(new GridLayout(1, 1));
		ListPanel.add(ListPanel.getCpPanel());
		
	    SetPanel SetPanel = new SetPanel();
		SetPanel.setLayout(new GridLayout(1, 1));
		SetPanel.add(SetPanel.getCpPanel());
		
		TreePanel TreePanel = new TreePanel();
		TreePanel.setLayout(new GridLayout(1, 1));
		TreePanel.add(TreePanel.getCpPanel());
		
	    tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Stack", stackPanel);
		tabbedPane.addTab("Queue", QueuePanel);
        tabbedPane.addTab("List", ListPanel);
		tabbedPane.addTab("Set", SetPanel );
		tabbedPane.addTab("Tree", TreePanel );
		
		
		
	    topPanel = new JPanel();
	    topPanel.setLayout(new GridLayout(1, 1));
	    topPanel.add(tabbedPane);
	}
	    /**
	     * 
	     * @return returns the overall panel with the panels and tabbed pane
	     */
	    public JPanel getPanel(){
			return topPanel;
		}
		
	    /**
	     * 
	     * @return returns the menubar
	     */
		public JMenuBar getMenuBar()
		   {
		      return menubar;
		   }

	    /**
	     * 
	     * @author C3456595 Action Listener for the exit menu item to exit the application
	     *
	     */
		public class ExitApp implements ActionListener{
			
			public void actionPerformed (ActionEvent event){
				System.exit(0);
			}}
		/**
		 * 
		 * @author C3456595 Action Listener for the About menu item
		 *
		 */
        public class AboutApp implements ActionListener{
			
			public void actionPerformed (ActionEvent event){
				JOptionPane.showMessageDialog(topPanel, "This application is a tool to learn about different data structures");
			}}
        
       public class EmptyApp implements ActionListener{
			
			public void actionPerformed (ActionEvent event){
				
				// get current tab call empty method
				
				int index = tabbedPane.getSelectedIndex();
				
				switch(index){
				
				case 1: 
					QueuePanel.EmptyContent();
					break;
				case 2:
					ListPanel.EmptyContent();
					break;
				case 3:
					SetPanel.EmptyContent();
				    break;
							
				}
				
			}}
        
        
		
        
		
		
}
