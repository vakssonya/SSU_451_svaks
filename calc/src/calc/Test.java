package calc;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Test {

	public static int getPriority(char ch) {
		if ((ch == ')') || (ch == '('))
			return 1;
		if ((ch == '+') || (ch == '-'))
			return 2;
		if ((ch == '*') || (ch == '/'))
			return 3;
		if (ch == '^')
			return 4;
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "";
		ArrayList<Character> operators = new ArrayList<Character>();
		operators.add('*');
		operators.add('/');
		operators.add('+');
		operators.add('-');
		operators.add('^');
		System.out.println("Enter data");
		s = sc.nextLine();
		while (!s.equals("Close")) {
			if (s.isEmpty()){
				s = sc.nextLine();
				continue;
			}
			char[] chrArray = s.toCharArray();
			StringBuilder sb = new StringBuilder();
			Stack<Character> st = new Stack<Character>();
			Boolean flag = false;
			Boolean flag2 = true;
			int k = 1;
			for (char ñ : chrArray) {
				if (Character.isDigit(ñ)) {
					if (flag)
						sb.append(' ');
					sb.append(ñ);
					flag = false;
				} else if (operators.contains(ñ)) {
					flag = true;
					if (st.size() == 0) {
						st.push(ñ);
					} else if (getPriority(ñ) > getPriority(st.peek())) {
						st.push(ñ);
					} else {
						while (!st.empty() && getPriority(ñ) <= getPriority(st.peek())) {
							sb.append(' ');
							sb.append(st.pop());
						}
						st.push(ñ);
					}
				} else if (ñ == '(') {
					st.push(ñ);
				} else if (ñ == ')') {
					while (!st.empty() && st.peek() != '(') {
						sb.append(' ');
						sb.append(st.pop());
					}
					if (!st.empty()) {
						st.pop();
					} else {
						flag2 = false;
						System.out.println("You miss bracket");
					}
				} else {
					System.out.println("Incorrect");
					flag2 = false;
					break;
				}

				k++;
			}

			if (flag2) {
				Boolean fl = false;
				while (!st.empty()) {
					if (st.peek() == '(' || st.peek() == ')') {
						System.out.println("You miss bracket");
						fl = true;
						break;
					} else {
						sb.append(' ');
						sb.append(st.pop());
						sb.append(' ');
					}
				}
				if (!fl) {
					char[] result = sb.toString().toCharArray();
					System.out.println(result);
					Stack<Double> st2 = new Stack<Double>();
					StringBuilder sb1 = new StringBuilder();
					for (char c : result) {
						if (c != ' ') {
							if (Character.isDigit(c))
								sb1.append(c);
							else {
								double a = st2.pop();
								double b = st2.pop();
								if (c == '+')
									st2.push(a + b);
								if (c == '-')
									st2.push(b - a);
								if (c == '*')
									st2.push(a * b);
								if (c == '/')
									st2.push(b / a);
								if (c == '^')
									st2.push(Math.pow(b, a));
							}
						} else if (sb1.length() != 0) {
							st2.push(Double.parseDouble(sb1.toString()));
							sb1.setLength(0);
						}
					}
					System.out.println(st2.pop());
				}
			}
			System.out.println("Enter data");
			s = sc.nextLine();
		}
		sc.close();
	}
}
