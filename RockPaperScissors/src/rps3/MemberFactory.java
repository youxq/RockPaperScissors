package rps3;

import java.util.Random;


public class MemberFactory {
	public static Member Generate(){
		Random rand = new Random();
		int number = rand.nextInt(5);
		return Member.getMember(number);
	}
}
