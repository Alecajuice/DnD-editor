import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MenuScreen extends JPanel implements ActionListener
{
	public MenuScreen()
	{
		this.setLayout(new GridLayout(3, 1));
		JLabel title = new JLabel("DnD Card Editor");
		JButton newC = new JButton("New Card");
		JButton open = new JButton("Open Card");
		newC.setActionCommand("new");
		newC.addActionListener(this);
		open.addActionListener(this);
		newC.setPreferredSize(new Dimension(300, 50));
		open.setPreferredSize(new Dimension(300, 50));
		this.add(title);
		this.add(newC);
		this.add(open);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ("new".equals(e.getActionCommand()))
		{
			Main.openCardTypeSelection();
        }
		else
        {
			Main.openFileSelection();
        }
	}
}
