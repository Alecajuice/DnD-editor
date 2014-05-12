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
	private BufferedImage bgImage;
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

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}
}
