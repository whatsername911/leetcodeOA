package binaryPalindrom;

public class BinPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinPalindrom a = new BinPalindrom();
		int i = -1;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(a.palindrom(i));
	}
	
	private boolean palindrom(int x) {
		String s = Integer.toBinaryString(x);
		int i = 0; int j = s.length() - 1;

		while(i < j) {
			if(s.charAt(i++) != s.charAt(j--)) {
				return false;
				
			}
		}
		return true;
	}

}
