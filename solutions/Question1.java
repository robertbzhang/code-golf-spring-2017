import java.io.*;
import java.util.*;

public class Question1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("src/code-golf-spring-2017/inputs/1.txt"));
		PrintStream output = new PrintStream(new File("src/code-golf-spring-2017/answers/1.txt"));
		while(scan.hasNextInt()) {
			output.println(numPrimes(scan.nextInt()));
		}
	}
	
	public static int numPrimes(int n) {
		int numPrimes = 0;
		for (int i = 2; i <= n; i++) {
			int numFactors = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					numFactors++;
				}
			}
			if (numFactors == 1) {
				numPrimes++;
			}
		}
		return numPrimes;
	}

}
