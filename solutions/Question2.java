import java.io.*;
import java.util.*;

public class Question2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("../inputs/2.txt"));
		PrintStream output = new PrintStream(new File("../answers/2.txt"));
		while(scan.hasNext()) {
			output.println(prefixResult(scan.next()));
		}
	}
	
	public static int prefixResult(String s) {
		Stack<Integer> stack = new Stack();
		Stack<Character> opStack = new Stack();
		boolean intBefore = false;
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i)-'0');
			if (s.charAt(i) == '-' || s.charAt(i) == '+' || 
					s.charAt(i) == '*' || s.charAt(i) == '/') {
				opStack.push(s.charAt(i));
				intBefore = false;
			} else if (intBefore){
				int rhs = stack.pop();
				int lhs = stack.pop();
				char operator = opStack.pop();
				if (operator == '-') {
					stack.push((lhs-rhs));
				} else if (operator == '+') {
					stack.push((lhs+rhs));
				} else if (operator == '*') {
					stack.push((lhs*rhs));
				} else {
					stack.push((lhs/rhs));
				}
				intBefore = false;
			} else {
				intBefore = true;
			}
		}
		return stack.pop();
	}

}