package rps3;

public enum Member {
	Rock, Paper, Scissors, Lizard, Spock;

	public static Member getMember(int number) {
		return Member.values()[number];
	}

	public static int compare(Member a, Member b) {
		if (a == Member.Rock) {
			if (b == Member.Paper || b == Member.Spock) {
				return -1;
			}
			if (b == Member.Scissors || b == Member.Lizard) {
				return 1;
			}
			return 0;
		}
		if (a == Member.Paper) {
			if (b == Member.Scissors || b == Member.Lizard) {
				return -1;
			}
			if (b == Member.Rock || b == Member.Spock) {
				return 1;
			}
			return 0;
		}
		if (a == Member.Scissors) {
			if (b == Member.Rock || b == Member.Spock) {
				return -1;
			}
			if (b == Member.Paper || b == Member.Lizard) {
				return 1;
			}
			return 0;
		}
		if (a == Member.Lizard) {
			if (b == Member.Scissors || b == Member.Rock) {
				return -1;
			}
			if (b == Member.Rock || b == Member.Spock) {
				return 1;
			}
			return 0;
		}
		if (b == Member.Paper || b == Member.Lizard) {
			return -1;
		}
		if (b == Member.Rock || b == Member.Scissors) {
			return 1;
		}
		return 0;
	}
}
