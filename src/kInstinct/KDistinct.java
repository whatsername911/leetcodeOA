package kInstinct;

import java.util.Arrays;

public class KDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KDistinct k = new KDistinct();
		System.out.println(k.kDistinct("abc", 2));
		

	}
	public int kDistinct(String s, int k) {
		if(s == null || k <= 0) {
			return 0;
		}
		int[] letters = new int[26];
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			Arrays.fill(letters, 0);
			int distinct = 0;
			for(int j = i; j < s.length(); j++) {
				
				if(letters[s.charAt(j) - 'a'] == 0) {
					distinct++;
				}
				letters[s.charAt(j) - 'a']++;
				if(distinct == k) {
					res++;
				}
			}	
		}
		return res;
	}
}
