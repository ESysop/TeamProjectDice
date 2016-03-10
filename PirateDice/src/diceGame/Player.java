
package diceGame;

public class Player
{
	
	String name;
	String currentElement;
	int health;
	int guardLevel;
	int mana;
	int playerNumber;
	int element;
	boolean isHuman;
	
	Dice dice = new Dice();
	
	public Player()
	{
		health = 100;
		mana = 50;
		isHuman = true;
	}
	
	public void ViewCurrentStats()
	{
		System.out.println("Name: " + name + "\t Health: " + health + "\t Mana: " + mana + "\t Guard: " + guardLevel + "\t Element: " + currentElement);
	}
	public void ManaRegen()
	{
		int manaIncrease = dice.dFour;
		mana += manaIncrease;
		System.out.println("Amount of mana regenerated:" + manaIncrease + " mana.");
	}

	public void PlayerRest()
	{
		int manaIncrease = dice.DFour() + dice.DFour() + dice.DFour() + dice.DFour() + dice.DFour();
		mana += manaIncrease;
		System.out.println("After 5 rolls of the four-sided die, your total mana increase is " + manaIncrease + " mana.");
	}

	public int SetPlayerGuard()
	{
		guardLevel = dice.dTen;
		System.out.println(guardLevel);
		return guardLevel;
	}
	public String SetPlayerElement()
	{
			element = dice.dSix;
			switch(element)
			{
				case 1:
					currentElement = "Fire";
					break;
				case 2:
					currentElement = "Ice";
					break;
				case 3:
					currentElement = "Wind";
					break;
				case 4:
					currentElement = "Earth";
					break;
				case 5:
					currentElement = "Lightning";
					break;
				case 6:
					currentElement = "Water";
					break;
				default:
					currentElement = "Fire";
					break;
			}
			return currentElement;
	}
}		