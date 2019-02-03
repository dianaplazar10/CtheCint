package practice;

public class practice {

	public static void main(String[] args) {
		String str = "Hello";
		boolean strUnique = isStringUniqueChars(str);
		if(strUnique) System.out.println("String is unique");
		else System.out.println("String isnt unique");

	}

	private static boolean isStringUniqueChars(String string) {
//		boolean[] chars = new boolean[128];
//		for(int i =0; i<str.length();i++){
//			if(chars[str.charAt(i)]){
//				return false;
//			}
//			chars[str.charAt(i)] = true; 
//		}
//		return true;
		String str = string.toLowerCase();
		int checker=0;
		for(int i =0; i<str.length();i++){
			int val = str.charAt(i) - 'a';
			System.out.println(str.charAt(i) + " : " + val);
			if((checker & (1<<val)) > 0)
				return false;
			checker = checker|(1<<val);
		}
		return true;
	}

}
