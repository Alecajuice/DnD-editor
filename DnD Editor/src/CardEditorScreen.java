import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;


public class CardEditorScreen extends JPanel implements ActionListener
{
	private Card card;
	JPanel toolBar = new JPanel();
	JButton save = new JButton("Save");
	JButton back = new JButton("Back to Main Menu");
	String[] powerTypes = {"Power Type", "At-Will", "Encounter", "Daily"};
	JComboBox powerType = new JComboBox(powerTypes);
	String[] tiers = {"Power Tier", "Heroic", "Paragon", "Epic"};
	JComboBox tier = new JComboBox(tiers);
	String[] actionTypes = {"Action Type", "Standard Action", "Minor Action", "Free Action"};
	JComboBox actionType = new JComboBox(actionTypes);
	String[] attackTypes = {"Power Type", "At-Will", "Encounter", "Daily"};
	JComboBox attackType = new JComboBox(attackTypes);
	String[] classes = {};
	JComboBox classs = new JComboBox(classes);
	public CardEditorScreen(Card card)
	{
		this.card = card;
		this.setLayout(new BorderLayout());
		toolBar.setBackground(Color.WHITE);
		TitledBorder toolBarBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Toolbar");
		toolBarBorder.setTitleJustification(TitledBorder.RIGHT);
		toolBar.setBorder(toolBarBorder);
		toolBar.setLayout(new GridLayout(2, 5));
		switch(card.getType())
		{
		case POWER:
			setUpPowerEditor();
			break;
		case FEAT:
			
			break;
		case ITEM:
			
			break;
		}
		this.add(toolBar, BorderLayout.NORTH);
	}

	public void setUpPowerEditor()
	{
		toolBar.add(new JLabel());
		toolBar.add(new JLabel());
		toolBar.add(new JLabel());
		toolBar.add(save);
		toolBar.add(back);
		toolBar.add(powerType);
		toolBar.add(tier);
		toolBar.add(actionType);
		toolBar.add(attackType);
		toolBar.add(classs);
		powerType.addActionListener(this);
		tier.addActionListener(this);
		actionType.addActionListener(this);
		attackType.addActionListener(this);
		classs.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JComboBox c = (JComboBox)e.getSource();
		switch((String)c.getSelectedItem())
		{
		case "At-Will":
			card.
		}
		
	}
}

class CardPanel extends JPanel
{
	public CardPanel()
	{
		
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(375, 525);
    }
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}
