
public class MainDice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Die four = new Die (4,1,4);
		Die six = new Die (6,1,6);
		Die eight = new Die (8,1,8);
		Die ten = new Die (10,1,10);
		Die twelve = new Die (12,1,12);
		Die twenty = new Die (20,1,20);
		
		four.roll(4);
		six.roll(6);
		eight.roll(8);
		ten.roll(10);
		twelve.roll(12);
		twenty.roll(20);
		
	}

}

