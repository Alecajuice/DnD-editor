import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class CardEditorScreen extends JPanel implements ActionListener
{
	private Card card;
	Font font;
	Font titleFont;
	JPanel toolBar = new JPanel();
	JButton save = new JButton("Save");
	JButton back = new JButton("Back to Main Menu");
	String[] powerTypes = {"Power Type", "At-Will", "Encounter", "Daily"};
	JComboBox powerType = new JComboBox(powerTypes);
	String[] tiers = {"Power Tier", "Heroic", "Paragon", "Epic"};
	JComboBox tier = new JComboBox(tiers);
	String[] actionTypes = {"Action Type", "Standard Action", "Minor Action", "Immediate Interrupt", "Free Action", "No Action"};
	JComboBox actionType = new JComboBox(actionTypes);
	String[] attackTypes = {"Power Type", "Personal", "Ranged", "Melee Weapon", "Ranged Weapon", "Close Burst", "Area", "Melee Touch", "Melee or Ranged Weapon"};
	JComboBox attackType = new JComboBox(attackTypes);
	String[] classes = {"Classes", "Ardent", "Artificer", "Assassin", "Avenger", "Barbarian", "Bard", "Battlemind", "Bladesinger", "Cleric", "Druid", "Fighter", "Invoker", "Monk", "Paladin", "Psion", "Ranger", "Rogue", "Runepriest", "Seeker", "Shaman", "Sorceror", "Swordmage", "Vampire", "Warden", "Warlock", "Warlord", "Wizard"};
	JComboBox classs = new JComboBox(classes);
	JTextField name = new JTextField();
	JTextField keywords = new JTextField();
	JTextField attackTypeParameter1 = new JTextField();
	JTextField attackTypeParameter2 = new JTextField();
	JTextField typeLevel = new JTextField();
	JTextPane flavor = new JTextPane();
	CardPanel canvas = new CardPanel();
	public CardEditorScreen(Card card)
	{
		this.card = card;
		this.setLayout(new BorderLayout());
//		URL fontURL;
		try {
//			fontURL = new URL("http://www.webpagepublicity.com/free-fonts/a/Airacobra%20Condensed.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, new File("Amigo.ttf"));
			titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("MORPHEUS.TTF"));
			titleFont = titleFont.deriveFont(30.0f);
//			font = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(font);
		    font = font.deriveFont(20.0f);
		    name.setFont(titleFont);
		    keywords.setFont(font);
		    attackTypeParameter1.setFont(font);
		    attackTypeParameter2.setFont(font);
		    typeLevel.setFont(font);
		    name.setOpaque(false);
		    keywords.setOpaque(false);
		    attackTypeParameter1.setOpaque(false);
		    attackTypeParameter2.setOpaque(false);
		    typeLevel.setOpaque(false);
		    flavor.setOpaque(false);
		    name.setBackground(new Color(0, 0, 0 ,0));
		    keywords.setBackground(new Color(0, 0, 0 ,0));
		    attackTypeParameter1.setBackground(new Color(0, 0, 0 ,0));
		    attackTypeParameter2.setBackground(new Color(0, 0, 0 ,0));
		    typeLevel.setBackground(new Color(0, 0, 0, 0));
//		    flavor.setBackground(new Color(0, 0, 0 ,0));
		    flavor.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		    name.setForeground(new Color(239, 237, 217));
		    typeLevel.setForeground(new Color(239, 237, 217));
		    keywords.setForeground(new Color(95, 8, 14));
		    setJTextPaneFont(flavor, font.deriveFont(Font.ITALIC, 15.0f), new Color(115, 131, 255));
		    name.setHorizontalAlignment(JTextField.CENTER);
		    SimpleAttributeSet attribs = new SimpleAttributeSet();  
		    StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER);  
		    flavor.setParagraphAttributes(attribs,true);  
		    name.addActionListener(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			name.setBounds(75, 20, 300, 40);
			this.add(name);
			this.add(keywords);
			this.add(attackTypeParameter1);
			this.add(attackTypeParameter2);
			this.add(typeLevel);
			this.add(flavor);
		}
		
		public Dimension getPreferredSize() {
	        return new Dimension(375, 525);
	    }
		
		
		public void paintComponent(Graphics g1d)
		{
			Graphics2D g = (Graphics2D)g1d; 
			super.paintComponent(g);
			FontMetrics metricst = g.getFontMetrics(titleFont);
			if(metricst.stringWidth(name.getText()) > 300)
			{
				titleFont = titleFont.deriveFont((float)(titleFont.getSize() - 1));
				name.setFont(titleFont);
				metricst = g.getFontMetrics(titleFont);
			}
			if(metricst.stringWidth(name.getText()) < 285 && titleFont.getSize() < 30)
			{
				titleFont = titleFont.deriveFont((float)(titleFont.getSize() + 1));
				name.setFont(titleFont);
				metricst = g.getFontMetrics(titleFont);
			}
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			try {
				g.drawImage(card.getBgImage(), 0, 0, null);
			} catch (Exception e) {
			}
			try {
				g.drawImage(card.getPowerTypeImage(), 0, 0, null);
			} catch (Exception e) {
			}
			try {
				g.drawImage(card.getTierImage(), 0, 0, null);
			} catch (Exception e) {
			}
			try {
				g.drawImage(card.getActionTypeImage(), 21, 51, null);
			} catch (Exception e) {
			}
			try {
				g.drawImage(card.getAttackTypeImage(), 296, 428, null);
			} catch (Exception e) {
			}
			try {
//				g.drawImage(ImageIO.read(new File("img/magic-missile.jpg")), 0, 0, null);
				g.setFont(font.deriveFont(Font.BOLD, 20.0f));
			} catch (Exception e) {
			}
			g.setColor(new Color(95, 8, 14));
			try {
				g.setFont(font.deriveFont(Font.BOLD));
				g.drawString(card.getPowerType(), 85, 105);
			} catch(Exception e){
			}
			FontMetrics metrics = g.getFontMetrics(font.deriveFont(20.0f));
			FontMetrics metricsb = g.getFontMetrics(font.deriveFont(Font.BOLD, 20.0f));
			try {
				g.drawImage(ImageIO.read(new File("img/dot.png")).getScaledInstance(15, 15, Image.SCALE_SMOOTH), 95 + metrics.stringWidth(card.getPowerType()), 90, null);
				keywords.setBounds(110 + metrics.stringWidth(card.getPowerType()), 88, 375 - (100 + metrics.stringWidth(card.getPowerType())), 20);
			} catch (Exception e) {
				try {
					g.drawImage(ImageIO.read(new File("img/dot.png")).getScaledInstance(15, 15, Image.SCALE_SMOOTH), 95, 90, null);
				} catch (IOException e1) {
				}
				keywords.setBounds(110, 88, 375 - 100, 20);
			}
			g.setColor(Color.BLACK);
			try {
				g.drawString(card.getActionType(), 10, 135);
			} catch(Exception e){
			}
			try {
				if(card.getAttackType().equals("Ranged") || card.getAttackType().equals("Close Burst"))
				{
					g.setFont(font.deriveFont(Font.BOLD));
					g.drawString(card.getAttackType(), 330 - metricsb.stringWidth(card.getAttackType()), 135);
					g.setFont(font);
					attackTypeParameter1.setBounds(332, 118, 40, 20);
					attackTypeParameter2.setBounds(0, 0, 0, 0);
				}
				else if (card.getAttackType().equals("Area"))
				{
					g.setFont(font.deriveFont(Font.BOLD));
					g.drawString(card.getAttackType() + " ", 330 - metricsb.stringWidth(card.getAttackType() + "burst"), 135);
					g.setFont(font);
					g.drawString("burst", 330 - metrics.stringWidth("burst"), 135);
					attackTypeParameter1.setBounds(332, 118, 40, 20);
					g.drawString("within", 330 - metrics.stringWidth("within squares"), 155);
					attackTypeParameter2.setBounds(332 - metrics.stringWidth("squares"), 138, 40, 20);
					g.drawString("squares", 370 - metrics.stringWidth("squares"), 155);
				}
				else
				{
					g.setFont(font.deriveFont(Font.BOLD));
					g.drawString(card.getAttackType(), 360 - metricsb.stringWidth(card.getAttackType()), 135);
					g.setFont(font);
					attackTypeParameter1.setBounds(0, 0, 0, 0);
					attackTypeParameter2.setBounds(0, 0, 0, 0);
				}
			} catch(Exception e){
			}
			try {
				g.setFont(font);
				g.setColor(new Color(239, 237, 217));
				g.drawString(card.getClasss(), 10, 505);
			} catch(Exception e)
			{
			}
			try {
				typeLevel.setBounds(15 + metrics.stringWidth(card.getClasss()), 490, 300 - metrics.stringWidth(card.getClasss()), 20);
			} catch(Exception e)
			{
			}
			flavor.setBounds(10, 400, 355, 60);
		}
	}
	public static void setJTextPaneFont(JTextPane jtp, Font font, Color c)
	{
		MutableAttributeSet attrs = jtp.getInputAttributes();
		StyleConstants.setFontFamily(attrs, font.getFamily());
		StyleConstants.setFontSize(attrs, font.getSize());
		StyleConstants.setItalic(attrs, (font.getStyle() & Font.ITALIC) != 0);
		StyleConstants.setBold(attrs, (font.getStyle() & Font.BOLD) != 0);
		StyleConstants.setForeground(attrs, c);
		StyledDocument doc = jtp.getStyledDocument();
		doc.setCharacterAttributes(0, doc.getLength() + 1, attrs, false);
	}
}


