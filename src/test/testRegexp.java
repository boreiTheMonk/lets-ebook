package test;

public class testRegexp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		// TODO Auto-generated method stub
		String pattern ="^(([1-9][0-9]*)|([1-9][0-9]*-[1-9][0-9]*))(,([1-9][0-9]*)|,([1-9][0-9]*-[1-9][0-9]*))*";
	//	String pattern = "^[1-9][0-9]*((,?[0-9]*)*|(-[0-9]*)?)";
System.out.println("1"+"1".matches(pattern)+" ok");
System.out.println("1-3".matches(pattern)+" ok");
System.out.println("1-3,4,5".matches(pattern)+" ok");
System.out.println("12-16".matches(pattern)+" ok");
System.out.println("1 2".matches(pattern)+" no");
System.out.println("1,2".matches(pattern)+" ok");
System.out.println("1,2-5".matches(pattern)+" ok");
System.out.println("1,2-5,3-5,4,3".matches(pattern)+" ok");
System.out.println("1,2,3-10".matches(pattern)+" ok");
System.out.println("1-2,3-10".matches(pattern)+" ok");
System.out.println(",1-2,3-10".matches(pattern)+" no");
System.out.println("0,1-2,3-10".matches(pattern)+" no");
System.out.println("1,-2,3-10".matches(pattern)+" no");
System.out.println("12-16-14".matches(pattern)+" no");
	}

}
