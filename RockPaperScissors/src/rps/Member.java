package rps;

public enum Member {
	Rock, Paper, Scissors;

	public static Member getMember(int number) {
		return Member.values()[number];
	}

	public static int compare(Member a, Member b) {
		if (a == Member.Rock) {
			if (b == Member.Paper) {
				return -1;
			}
			if (b == Member.Scissors) {
				return 1;
			}
			return 0;
		} else if (a == Member.Paper) {
			if (b == Member.Rock) {
				return 1;
			}
			if (b == Member.Scissors) {
				return -1;
			}
			return 0;
		} else {
			if (b == Member.Rock) {
				return -1;
			}
			if (b == Member.Paper) {
				return 1;
			}
			return 0;
		}
	}

	public static int compare(int a, int b) {
		if (a == 0) {
			if (b == 1) {
				return -1;
			}
			if (b == 2) {
				return 1;
			}
			return 0;
		} else if (a == 1) {
			if (b == 0) {
				return 1;
			}
			if (b == 2) {
				return -1;
			}
			return 0;
		} else {
			if (b == 0) {
				return -1;
			}
			if (b == 1) {
				return 1;
			}
			return 0;
		}
	}
}
