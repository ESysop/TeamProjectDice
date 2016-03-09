
public class Dice {
	
	int min = 1;
	int max = 4;
	int nextIntInRange(int min, int max, Random rng) {
		   if (min > max) {
		      throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
		   }
		   int diff = max - min;
		   if (diff >= 0 && diff != Integer.MAX_VALUE) {
		      return (min + rng.nextInt(diff + 1));
		   }
		   int i;
		   do {
		      i = rng.nextInt();
		   } while (i < min || i > max);
		   System.out.println(i);
		   return i;
		}
}
