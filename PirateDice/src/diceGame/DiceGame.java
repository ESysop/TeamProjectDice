package diceGame;

public class diceGame
{
	public static void main(String[] args)
	{
		SetUpGame game = new SetUpGame();

		game.PlayerSetup();
		game.SetPlayerName();
		game.PrintAllStats();
		System.out.println();
		game.Match();
	}
}