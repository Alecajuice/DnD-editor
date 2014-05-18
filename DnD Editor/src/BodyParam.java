import javax.swing.JTextField;
import javax.swing.JTextPane;

public class BodyParam
{
	private JTextField namef = new JTextField();
	private JTextPane bodyf = new JTextPane();
	private String name;
	private String body;
	
	public BodyParam()
	{
		
	}

	public JTextField getNamef()
	{
		return namef;
	}

	public void setNamef(JTextField namef)
	{
		this.namef = namef;
	}

	public JTextPane getBodyf()
	{
		return bodyf;
	}

	public void setBodyf(JTextPane bodyf)
	{
		this.bodyf = bodyf;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}
}
