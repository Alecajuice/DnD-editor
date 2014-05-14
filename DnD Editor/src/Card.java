import java.awt.image.BufferedImage;
import java.io.File;

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
	private BufferedImage rangeImage;

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

	public BufferedImage getRangeImage()
	{
		return rangeImage;
	}

	public void setRangeImage(BufferedImage rangeImage)
	{
		this.rangeImage = rangeImage;
	}
}
