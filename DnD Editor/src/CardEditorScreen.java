import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;


public class CardEditorScreen extends JPanel
{
	private Card card;
	JPanel toolBar = new JPanel();
	public CardEditorScreen(Card card)
	{
		this.card = card;
		this.setLayout(new BorderLayout());
		toolBar.setBackground(Color.WHITE);
		TitledBorder toolBarBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "title");
		toolBarBorder.setTitleJustification(TitledBorder.RIGHT);
		toolBar.setBorder(toolBarBorder);
		toolBar.setLayout(new GridLayout(1, 5));
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
		String[] powerTypes = {"Power Type", "At-Will", "Encounter", "Daily"};
		JComboBox powerType = new JComboBox(powerTypes);
		String[] tiers = {"Power Tier", "Heroic", "Paragon", "Epic"};
		JComboBox tier = new JComboBox(tiers);
		String[] actionTypes = {"Action Type", "Standard Action", "Minor Action", "Free Action"};
		JComboBox actionType = new JComboBox(actionTypes);
		String[] attackTypes = {"Power Type", "At-Will", "Encounter", "Daily"};
		JComboBox attackType = new JComboBox(powerTypes);
		toolBar.add(powerType);
		toolBar.add(tier);
		toolBar.add(actionType);
	}
}
