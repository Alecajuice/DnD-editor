import java.awt.Graphics;

import javax.swing.JFrame;


public class Main
{
	static JFrame frame = new JFrame();
    static MenuScreen menu = new MenuScreen();
	public static void main(String[] args)
	{
		frame.setSize(500, 500);
		frame.setTitle("DnD Card Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(menu);
		frame.pack();
		frame.setVisible(true);
	}

	public static void openCardTypeSelection()
	{
		CardTypeSelection s = new CardTypeSelection();
	}

	public static void openFileSelection()
	{
		
	}
	
	public static void openCardEditor(Card card)
	{
		frame.remove(menu);
		frame.setSize(750, 750);
		frame.add(new CardEditorScreen(card));
		frame.validate();
	}
}
