package rps;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
	private static List<String> range = Arrays.asList("0", "1", "2");
	private static final int No = -1;
	private static final int Yes = 1;
	private static final int Invalid = -2;
	private static final int Valid = 0;

	private static final int Again = -2;

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the world of RockPaperScissors");
		System.out
				.println("Now it is your turn. Choose one below. Or[N/n] to exit");
		System.out.println("0:Rock   1:Paper   2:Scissors");

		String choise;
		while (true) {
			choise = scan.nextLine();
			int state = getChoiseState(choise);
			switch (state) {
			case No:
				System.out.println("Thanks for join us. See you next time");
				return;
			case Valid:
				Member user = Member.getMember(Integer.parseInt(choise));
				Member com = MemberFactory.Generate();
				int result = Member.compare(user, com);
				switch (outputResultAndReplay(result)) {
				case Yes:
				case Again:
					System.out.println("Choose one from them. Or[N/n] to exit");
					System.out.println("0:Rock   1:Paper   2:Scissors");
					break;
				case No:
					return;
				}
				break;
			default:
				System.out.println("Invalid input, try again");
			}
		}
	}

	public static int getChoiseState(String input) {
		if (input.toLowerCase().equals("n")) {
			return No;
		} else if (input.toLowerCase().equals("y")) {
			return Yes;
		} else if (range.contains(input)) {
			return Valid;
		}
		return Invalid;
	}

	public static int outputResultAndReplay(int result) {
		if (result > 0) {
			System.out
					.println("Congratulations. You win. Do you want to play again [Y/N]");
			return tryReplay();
		}
		if (result < 0) {
			System.out
					.println("Sorry, you lose. Do you want to play again [Y/N]");
			return tryReplay();
		}
		System.out.println("Draw. Do you want to play again [Y/N]");
		return tryReplay();
	}

	private static int tryReplay() {
		String choise = scan.nextLine();
		switch (getChoiseState(choise)) {
		case Yes:
			return Yes;
		case No:
			return No;
		default:
			return Invalid;
		}
	}
}
