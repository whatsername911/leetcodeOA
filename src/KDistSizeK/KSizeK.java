package KDistSizeK;

import java.util.Arrays;


public class KSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KSizeK k = new KSizeK();
		System.out.println(k.kSizeK("aab", 2));
	}
	public int kSizeK(String s, int k) {
		if(s == null || k < 0) {
			return 0;
		}
		int res = 0;
		int[] letters = new int[26];
		for(int i = 0; i <= s.length() - k; i ++) {
		
			Arrays.fill(letters, 0);
			boolean dist = true;
			for(int j = i; j < i + k; j++) {
				if(letters[s.charAt(j) - 'a'] >= 1) {
					dist = false;
					break;
				}
				letters[s.charAt(j) - 'a']++;
			}
			if(dist) {
				res++;
			}
		}
		return res;
	}


}
