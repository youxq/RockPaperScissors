package rps;

import java.util.Random;


public class MemberFactory {
	public static Member Generate(){
		Random rand = new Random();
		int number = rand.nextInt(3);
		return Member.getMember(number);
	}
}
