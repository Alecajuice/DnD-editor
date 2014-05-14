import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	String[] actionTypes = {"Action Type", "Standard Action", "Minor Action", "Immediate Interrupt", "Free Action", "No Action"};
	JComboBox actionType = new JComboBox(actionTypes);
	String[] attackTypes = {"Power Type", "Personal", "Ranged", "Melee", "Close Burst", "Burst", "Touch", "Melee or Ranged"};
	JComboBox attackType = new JComboBox(attackTypes);
	String[] classes = {};
	JComboBox classs = new JComboBox(classes);
	JTextField name = new JTextField(40);
	CardPanel canvas = new CardPanel();
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
		JPanel center = new JPanel();
		center.add(canvas, BorderLayout.CENTER);
		this.add(toolBar, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
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
		if(c.equals(powerType))
		{
			card.setPowerType((String)c.getSelectedItem());
		}
		else if(c.equals(tier))
		{
			card.setTier((String)c.getSelectedItem());
		}
		else if(c.equals(actionType))
		{
			card.setActionType((String)c.getSelectedItem());
		}
		else if(c.equals(attackType))
		{
			card.setAttackType((String)c.getSelectedItem());
		}
		else if(c.equals(classs))
		{
			card.setClasss((String)c.getSelectedItem());
		}
		System.out.println((String)c.getSelectedItem());
		canvas.repaint();
	}
	class CardPanel extends JPanel
	{
		public CardPanel()
		{
			this.setBounds(0, 0, 375, 525);
			this.setLayout(null);
			name.setBounds(75, 30, 300, 20);
			this.add(name);
		}
		
		public Dimension getPreferredSize() {
	        return new Dimension(375, 525);
	    }
		
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			try {
				g.drawImage(ImageIO.read(new File("magic-missile.jpg")), 0, 0, null);
			} catch (IOException e) {
			}
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.setColor(Color.RED);
			try {
				g.drawString(card.getPowerType(), 90, 105);
			} catch(Exception e){
			}
		}
	}
}


