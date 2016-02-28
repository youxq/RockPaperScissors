package rps3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import rps3.exception.RPSInputException;

public class Program {
	private static List<String> range = Arrays.asList("0", "1", "2", "3", "4");
	private static final int No = -1;
	private static final int Yes = 1;
	private static final int Valid = 0;

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the world of RockPaperScissors");
		PrintChoices();

		String choise;
		while (true) {
			choise = scan.nextLine();

			int state = 0;
			try {
				state = checkChoise(choise);
			} catch (RPSInputException e) {
				System.out.println(e.getMessage());
				continue;
			}
			switch (state) {
			case No:
				exit();
				return;
			case Valid:
				Member user = Member.getMember(Integer.parseInt(choise));
				Member com = MemberFactory.Generate();
				int result = Member.compare(user, com);
				outputResult(result);
				switch (tryReplay()) {
				case Yes:
					PrintChoices();
					break;
				case No:
					exit();
					return;
				}
				break;
			}
		}
	}

	private static void PrintChoices() {
		System.out
				.println("Now it is your turn. Choose one below. Or[N/n] to exit");
		System.out.println("0:Rock   1:Paper   2:Scissors	3:Lizard	4:Spock");
	}

	private static void exit() {
		System.out.println("Thanks for join us. See you next time");
	}

	private static int checkAgainOrExit(String input) {
		if (input.toLowerCase().equals("y")) {
			return Yes;
		}
		return No;
	}

	private static int checkChoise(String input) throws RPSInputException {
		if (input.toLowerCase().equals("n")) {
			return No;
		} else if (input.toLowerCase().equals("y")) {
			return Yes;
		} else if (range.contains(input)) {
			return Valid;
		}
		throw new RPSInputException();
	}

	private static void outputResult(int result) {
		if (result > 0) {
			System.out
					.println("Congratulations. You win. Do you want to play again? [Y--again  others--exit]");
			return;
		}
		if (result < 0) {
			System.out
					.println("Sorry, you lose. Do you want to play again? [Y--again  others--exit]");
			return;
		}
		System.out
				.println("Draw. Do you want to play again? [Y--again  others--exit]");
	}

	private static int tryReplay() {
		String choise = scan.nextLine();
		int result = checkAgainOrExit(choise);
		switch (result) {
		case Yes:
			return Yes;
		default:
			return No;
		}
	}
}
