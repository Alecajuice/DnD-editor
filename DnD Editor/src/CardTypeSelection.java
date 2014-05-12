import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CardTypeSelection extends JFrame implements ActionListener
{
	public CardTypeSelection()
	{
		JPanel panel = new JPanel();
		this.add(panel)
;		panel.setLayout(new GridLayout(1, 3));
		JButton power = new JButton("Power Card");
		JButton feat = new JButton("Feat Card");
		JButton item = new JButton("Item Card");
		power.setActionCommand("power");
		feat.setActionCommand("feat");
		power.addActionListener(this);
		feat.addActionListener(this);
		item.addActionListener(this);
		panel.add(power);
		panel.add(feat);
		panel.add(item);
		this.setSize(500, 500);
		this.setTitle("Card Type Selection");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ("power".equals(e.getActionCommand()))
		{
			Card card = new Card(Card.CardType.POWER);
			Main.openCardEditor(card);
        }
		else if ("feat".equals(e.getActionCommand()))
        {
			Card card = new Card(Card.CardType.FEAT);
			Main.openCardEditor(card);
        }
		else
		{
			Card card = new Card(Card.CardType.ITEM);
			Main.openCardEditor(card);
		}
		this.dispose();
	}
	
	
}
