package diceGame;
import java.util.ArrayList;
import java.util.Scanner;
public class SetUpGame
{
	boolean gameActive = true;
	int turn;
	Player player = new Player();
	ArrayList<Player> playerList = new ArrayList<>();
	ArrayList<Integer> targetList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	public SetUpGame()
	{
		turn = 1;
	}
	
	public  void PlayerSetup()
	{
		gameActive = true;
		System.out.println("How many Player players? (Max 4)");
		int input = scanner.nextInt();
		player.dice.RollDice();
		if(input > 0)
		{
			Player player1 = new Player();
			playerList.add(player1);
			SetDiceValue(0);
			input -= 1;
		}
		else
		{
			AI player1 = new AI();
			playerList.add(player1);
			SetDiceValue(0);
		}
		if(input > 0)
		{
			Player player2 = new Player();
			playerList.add(player2);
			SetDiceValue(1);
			input -= 1;
		}
		else
		{
			AI player2 = new AI();
			playerList.add(player2);
			SetDiceValue(1);

		}
		if(input > 0)
		{
			Player player3 = new Player();
			playerList.add(player3);
			SetDiceValue(2);
			input -= 1;
		}
		else
		{
			AI player3 = new AI();
			playerList.add(player3);
			SetDiceValue(2);

		}
	
		if(input > 0)
		{
			Player player4 = new Player();
			playerList.add(player4);
			SetDiceValue(3);
			input -= 1;
		}
		else
		{
			AI player4 = new AI();
			playerList.add(player4);
			SetDiceValue(3);
		}		
	}

		public void SetPlayerName()
		{
			scanner.nextLine();
			for(int i = 0; i < 4; i++)
			{
				int playerNumber = i + 1;
				System.out.println("Please enter a name for player " + playerNumber + ": ");
				String name = scanner.nextLine();
				playerList.get(i).name = name;
			}
		}  
		public void PrintRules()
		{
			System.out.println("All the Game Rules!!!");
		}
		
		public void PrintAllStats()
		{
			for( int i = 0; i < 4; i++)
			{
			playerList.get(i).ViewCurrentStats();
			}
		}
		public void Match()
		{
			while(playerList.size() > 1)
			{		
				this.Turn();
				PrintAllStats();
			}
			if(playerList.size() == 1){
				System.out.println("Game Over!");
			}			
		}
		public void Turn()
		{
			for(int i = 0; i < playerList.size(); i++)
			{
				System.out.println(playerList.get(i).name + "'s turn.");
				player.dice.RollDice();
				SetDiceValue(i);
				ReportDice(i);		
                if(playerList.get(i).isHuman == true)
                {
                    System.out.println("What would you like to do?");
                    System.out.println("1: Rest" );
                    int options = 2;
                    for(int j = 0; j < playerList.size(); j++)
                    {
                        if(i != j)
                        {
                        System.out.println(options + ": Attack " + playerList.get(j).name);
                        targetList.add(j);
                        options += 1;
                        }    
                    }
                    int	inputInt = scanner.nextInt();
                    switch(inputInt)
                    {
                        case 1:
                            playerList.get(i).PlayerRest();
                            break;
                        case 2:
                            Attack(targetList.get(0), i);
                            break;
                        case 3:
                            Attack(targetList.get(1), i);
                            break;
                        case 4:
                            Attack(targetList.get(2), i);
                            break;
                        default:
                            break;
                    }
			}			
			}
			turn += 1;
		}
		
		public void ReportDice(int I)
		{
			int i = I;
			System.out.println("Turn: " + turn);
			System.out.println("Player " + playerList.get(i).name + " rolled:");
			System.out.println("Mana Regen(D4): " + player.dice.dFour);
			System.out.println("Element(D6): " + playerList.get(i).currentElement + "(" + player.dice.dSix + ")");
			System.out.println("Mulitplier(D8): " + player.dice.dEight);
			System.out.println("Guard(D10): " + player.dice.dTen);
			System.out.println("Attack Cost(D12): " + player.dice.dTwelve);
			System.out.println("Attack Damage(D20): " + player.dice.dTwenty);
		}
		public void Attack(int TargetIndex, int PlayerIndex)
		{
			CalculateCritial();
			CalculateElemental(TargetIndex, PlayerIndex);
			if (playerList.get(TargetIndex).guardLevel > player.dice.dTwenty)
			{
				playerList.get(TargetIndex).guardLevel = player.dice.dTwenty;
			}
			playerList.get(TargetIndex).health -= player.dice.dTwenty - playerList.get(TargetIndex).guardLevel;
			playerList.get(PlayerIndex).mana -= player.dice.dTwelve;
			playerList.get(TargetIndex).ViewCurrentStats();
		}	
		public void CalculateCritial()
		{
			if (player.dice.dEight == player.dice.dSix)
			{
				player.dice.dTwenty *= 2;
			}
		}
		public void CalculateElemental(int TargetIndex, int PlayerIndex)
		{
			if(playerList.get(PlayerIndex).element == playerList.get(TargetIndex).element - 1 || 
					playerList.get(PlayerIndex).element == 6 && playerList.get(TargetIndex).element == 1)
			{
				player.dice.dTwenty *= 2;
			}
			else if(playerList.get(PlayerIndex).element == playerList.get(TargetIndex).element + 1 ||
					playerList.get(PlayerIndex).element == 1 && playerList.get(TargetIndex).element == 6)
			{
				player.dice.dTwenty /= 2;
			}
		}
		
		public void SetDiceValue(int PlayerIndex)
		{
			playerList.get(PlayerIndex).guardLevel = playerList.get(PlayerIndex).SetPlayerGuard();
			playerList.get(PlayerIndex).currentElement = playerList.get(PlayerIndex).SetPlayerElement();
		}

	//public PrintPlayerStats(){
	//	for()// each item in playerlist call ViewCurrentStats on that player
			
	//}
}