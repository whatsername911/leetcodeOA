package KMinusDist;

import java.util.Arrays;


public class KMinusDist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMinusDist k = new KMinusDist();
		System.out.println(k.kMinus("aaa", 2));
	}
	public int kMinus(String s, int k) {
		if(s == null || k < 0) {
			return 0;
		}
		int res = 0;
		int[] letters = new int[26];
		for(int i = 0; i <= s.length() - k; i ++) {
			int dist = 0;
			Arrays.fill(letters, 0);
			for(int j = i; j < i + k; j++) {
				if(letters[s.charAt(j) - 'a'] == 0) {
					dist++;
				}
				letters[s.charAt(j) - 'a']++;
			}
			if(dist == k - 1) {
				res++;
			}
		}
		return res;
	}

}
