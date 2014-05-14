import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


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
	private String powerType;
	private String tier;
	private String actionType;
	private String attackType;
	private String classs;

	public Card(CardType type)
	{
		this.type = type;
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
				this.powerTypeImage = ImageIO.read(new File("img/atwill.png"));
			} catch (IOException e) {
			}
			if(actionType != null)
			{
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/standardatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/minoratwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/immediateatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freeatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freeatwill.png"));
					} catch (IOException e) {
					}
					break;
				}
				break;
			}
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
						this.powerTypeImage = ImageIO.read(new File("img/standardattackType.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/minorattackType.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/immediateattackType.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freeattackType.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freeattackType.png"));
					} catch (IOException e) {
					}
					break;
				}
			break;
			}
		case "Daily":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/daily.png"));
			} catch (IOException e) {
			}
			if(actionType != null)
			{
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/standarddaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/minordaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/immediatedaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freedaily.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freedaily.png"));
					} catch (IOException e) {
					}
					break;
				}
			break;
			}
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
				this.powerTypeImage = ImageIO.read(new File("img/heroic.png"));
			} catch (IOException e) {
			}
			break;
		case "Paragon":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/paragon.png"));
			} catch (IOException e) {
			}
			break;
		case "Epic":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/epic.png"));
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
				try {
					this.powerTypeImage = ImageIO.read(new File("img/atwill.png"));
				} catch (IOException e) {
				}
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/standardatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/minoratwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/immediateatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freeatwill.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freeatwill.png"));
					} catch (IOException e) {
					}
					break;
				}
				break;
			case "Encounter":
				try {
					this.powerTypeImage = ImageIO.read(new File("img/encounter.png"));
				} catch (IOException e) {
				}
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/standardattackType.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/minorattackType.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/immediateattackType.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freeattackType.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freeattackType.png"));
					} catch (IOException e) {
					}
					break;
				}
				break;
			case "Daily":
				try {
					this.powerTypeImage = ImageIO.read(new File("img/daily.png"));
				} catch (IOException e) {
				}
				switch(actionType)
				{
				case "Standard Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/standarddaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Minor Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/minordaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Immediate Interrupt":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/immediatedaily.png"));
					} catch (IOException e) {
					}
					break;
				case "Free Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freedaily.png"));
					} catch (IOException e) {
					}
					break;
				case "No Action":
					try {
						this.powerTypeImage = ImageIO.read(new File("img/freedaily.png"));
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
				this.powerTypeImage = ImageIO.read(new File("img/personal.png"));
			} catch (IOException e) {
			}
			break;
		case "Ranged":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/ranged.png"));
			} catch (IOException e) {
			}
			break;
		case "Melee":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/melee.png"));
			} catch (IOException e) {
			}
			break;
		case "Close Burst":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/burst_c.png"));
			} catch (IOException e) {
			}
			break;
		case "Burst":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/burst_r.png"));
			} catch (IOException e) {
			}
			break;
		case "Touch":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/touch.png"));
			} catch (IOException e) {
			}
			break;
		case "Melee or Ranged":
			try {
				this.powerTypeImage = ImageIO.read(new File("img/hybrid.png"));
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
}
