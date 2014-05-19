import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class Card
{
	public enum CardType
	{
		POWER, FEAT, ITEM;
	}
	private CardType type;
	private BufferedImage tierImage;
	private BufferedImage powerTypeImage;
	private BufferedImage bgImage;
	private BufferedImage actionTypeImage;
	private BufferedImage attackTypeImage;
	private String name = null;
	private String powerType = null;
	private String tier = null;
	private String actionType = null;
	private String attackType = null;
	private String classs = null;
	private String keywords = null;
	private String attackTypeParameter1 = null;
	private String attackTypeParameter2 = null;
	private String typeLevel = null;
	private String flavor = null;
	private ArrayList<BodyParam> body = new ArrayList<BodyParam>();

	public Card(CardType type)
	{
		this.type = type;
		try {
			bgImage = ImageIO.read(new File("img/parchment.png"));
		} catch (IOException e) {
		}
		setBgImage(type);
	}

	public void setBgImage(CardType type)
	{
		switch(type)
		{
		case POWER:
//			bgImage = ImageIO.read(new File());
			break;
		case FEAT:
//			bgImage = ImageIO.read(new File());
			break;
		case ITEM:
//			bgImage = ImageIO.read(new File());
			break;
		}
	}
	
	public void save()
	{
		JFileChooser fc = new JFileChooser();
		File file = null;
		int returnVal = fc.showSaveDialog(new FileChooserPanel());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        } else {
        }
		PrintWriter writer;
		try {
			writer = new PrintWriter(file, "UTF-8");
//			private String name;
//			private String powerType;
//			private String tier;
//			private String actionType;
//			private String attackType;
//			private String classs;
//			private String keywords;
//			private String attackTypeParameter1;
//			private String attackTypeParameter2;
//			private String typeLevel;
//			private String flavor;
			try {writer.println("<name>" + this.name + "</name>");} catch (Exception e){}
			try {writer.println("<powerType>" + this.powerType + "</powerType>");} catch (Exception e){}
			try {writer.println("<tier>" + this.tier + "</tier>");} catch (Exception e){}
			try {writer.println("<actionType>" + this.actionType + "</actionType>");} catch (Exception e){}
			try {writer.println("<attackType>" + this.attackType + "</attackType>");} catch (Exception e){}
			try {writer.println("<class>" + this.classs + "</class>");} catch (Exception e){}
			try {writer.println("<keywords>" + this.keywords + "</keywords>");} catch (Exception e){}
			try {writer.println("<attackTypeParameter1>" + this.attackTypeParameter1 + "</attackTypeParameter1>");} catch (Exception e){}
			try {writer.println("<attackTypeParameter2>" + this.attackTypeParameter2 + "</attackTypeParameter2>");} catch (Exception e){}
			try {writer.println("<typeLevel>" + this.typeLevel + "</typeLevel>");} catch (Exception e){}
			try {writer.println("<flavor>" + this.flavor + "</flavor>");} catch (Exception e){}
			try {
				for(int i = 0; i < this.body.toArray().length; i++)
				{
					writer.println("<bodyParam" + i + "><name>" + ((BodyParam)body.toArray()[i]).getNamef());
				}
			} catch (Exception e) {	
			}
			writer.close();
		} catch (FileNotFoundException e) {
		} catch (UnsupportedEncodingException e) {
		}
	}
	
	public CardType getType()
	{
		return type;
	}

	public void setType(CardType type)
	{
		this.type = type;
	}
	public BufferedImage getTierImage()
	{
		return tierImage;
	}

	public void setTierImage(BufferedImage tierImage)
	{
		this.tierImage = tierImage;
	}

	public BufferedImage getPowerTypeImage()
	{
		return powerTypeImage;
	}

	public void setPowerTypeImage(BufferedImage powerTypeImage)
	{
		this.powerTypeImage = powerTypeImage;
	}

	public BufferedImage getBgImage()
	{
		return bgImage;
	}

	public void setBgImage(BufferedImage bgImage)
	{
		this.bgImage = bgImage;
	}

	public BufferedImage getActionTypeImage()
	{
		return actionTypeImage;
	}

	public void setActionTypeImage(BufferedImage actionTypeImage)
	{
		this.actionTypeImage = actionTypeImage;
	}

	public BufferedImage getAttackTypeImage()
	{
		return attackTypeImage;
	}

	public void setAttackTypeImage(BufferedImage attackTypeImage)
	{
		this.attackTypeImage = attackTypeImage;
	}

	public String getPowerType()
	{
		return powerType;
	}

	public void setPowerType(String powerType)
	{
		this.powerType = powerType;
		switch(powerType)
		{
		case "At-Will":
			try {
				System.out.println("hi");
				this.powerTypeImage = ImageIO.read(new File("img/atwill.png"));
			} catch (IOException e) {
			}
			if(actionType != null)
			{
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/standardatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/minoratwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/immediateatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freeatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freeatwill.png"));
					} catch (IOException e) {
					}
					break;
				}
				break;
			}
			break;
		case "Encounter":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/encounter.png"));
			} catch (IOException e) {
			}
			if(actionType != null)
			{
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/standardencounter.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/minorencounter.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/immediateencounter.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freeencounter.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freeencounter.png"));
					} catch (IOException e) {
					}
					break;
				}
				break;
			}
			break;
		case "Daily":
			try {
				System.out.println("dfkj");
				this.powerTypeImage = ImageIO.read(new File("img/daily.png"));
			} catch (IOException e) {
			}
			if(actionType != null)
			{
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/standarddaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/minordaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/immediatedaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freedaily.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freedaily.png"));
					} catch (IOException e) {
					}
					break;
				}
			break;
			}
		break;
		}
	}

	public String getTier()
	{
		return tier;
	}

	public void setTier(String tier)
	{
		this.tier = tier;
		switch(tier)
		{
		case "Heroic":
			try {
				this.tierImage = ImageIO.read(new File("img/heroic.png"));
			} catch (IOException e) {
			}
			break;
		case "Paragon":
			try {
				this.tierImage = ImageIO.read(new File("img/paragon.png"));
			} catch (IOException e) {
			}
			break;
		case "Epic":
			try {
				this.tierImage = ImageIO.read(new File("img/epic.png"));
			} catch (IOException e) {
			}
			break;
		}
	}

	public String getActionType()
	{
		return actionType;
		
	}

	public void setActionType(String actionType)
	{
		this.actionType = actionType;
		if(powerType != null)
		{
			switch(powerType)
			{
			case "At-Will":
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/standardatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/minoratwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/immediateatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freeatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freeatwill.png"));
					} catch (IOException e) {
					}
					break;
				}
				break;
			case "Encounter":
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/standardencounter.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/minorencounter.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/immediateencounter.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freeencounter.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freeencounter.png"));
					} catch (IOException e) {
					}
					break;
				}
				break;
			case "Daily":
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/standarddaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/minordaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/immediatedaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freedaily.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.actionTypeImage = ImageIO.read(new File("img/freedaily.png"));
					} catch (IOException e) {
					}
					break;
				}
				break;
			}
		}
	}

	public String getAttackType()
	{
		return attackType;
	}

	public void setAttackType(String attackType)
	{
		this.attackType = attackType;
		switch(attackType)
		{
		case "Personal":
			try {
				this.attackTypeImage = ImageIO.read(new File("img/personal.png"));
			} catch (IOException e) {
			}
			break;
		case "Ranged":
			try {
				this.attackTypeImage = ImageIO.read(new File("img/ranged.png"));
			} catch (IOException e) {
			}
			break;
		case "Melee Weapon":
			try {
				this.attackTypeImage = ImageIO.read(new File("img/melee.png"));
			} catch (IOException e) {
			}
			break;
		case "Ranged Weapon":
			try {
				this.attackTypeImage = ImageIO.read(new File("img/ranged.png"));
			} catch (IOException e) {
			}
			break;
		case "Close Burst":
			try {
				this.attackTypeImage = ImageIO.read(new File("img/burst_c.png"));
			} catch (IOException e) {
			}
			break;
		case "Area":
			try {
				this.attackTypeImage = ImageIO.read(new File("img/burst_r.png"));
			} catch (IOException e) {
			}
			break;
		case "Melee Touch":
			try {
				this.attackTypeImage = ImageIO.read(new File("img/touch.png"));
			} catch (IOException e) {
			}
			break;
		case "Melee or Ranged Weapon":
			try {
				this.attackTypeImage = ImageIO.read(new File("img/hybrid.png"));
			} catch (IOException e) {
			}
			break;
		}
	}

	public String getClasss()
	{
		return classs;
	}

	public void setClasss(String classs)
	{
		this.classs = classs;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getKeywords()
	{
		return keywords;
	}

	public void setKeywords(String keywords)
	{
		this.keywords = keywords;
	}

	public String getAttackTypeParameter1()
	{
		return attackTypeParameter1;
	}

	public void setAttackTypeParameter1(String attackTypeParameter1)
	{
		this.attackTypeParameter1 = attackTypeParameter1;
	}

	public String getAttackTypeParameter2()
	{
		return attackTypeParameter2;
	}

	public void setAttackTypeParameter2(String attackTypeParameter2)
	{
		this.attackTypeParameter2 = attackTypeParameter2;
	}

	public String getTypeLevel()
	{
		return typeLevel;
	}

	public void setTypeLevel(String typeLevel)
	{
		this.typeLevel = typeLevel;
	}

	public String getFlavor()
	{
		return flavor;
	}

	public void setFlavor(String flavor)
	{
		this.flavor = flavor;
	}

	public ArrayList<BodyParam> getBody()
	{
		return body;
	}

	public void setBody(ArrayList<BodyParam> body)
	{
		this.body = body;
	}
}
