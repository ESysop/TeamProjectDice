import java.util.Random;

public class Die {
	int sides;
	int result;
	int min;
	int max;
	int score;
	Random rand;
	//constructor
	public Die (int Sides, int Min, int Max){
		
		sides = Sides;
		min = Min;
		max = Max;
		rand = new Random();
	}
	//functions
	
	public void roll(int max)
		{ 
			int result = rand.nextInt(max)+1;
			score = result;
			
		
			System.out.println("You Scored a  " + score);
		}

	
			
			
		}	

