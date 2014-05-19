import javax.swing.JFrame;
import javax.swing.JPanel;


public class FileChooserPanel extends JFrame
{
	public FileChooserPanel()
	{
		super();
		this.setSize(500, 500);
		this.setTitle("Choose A File");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}
