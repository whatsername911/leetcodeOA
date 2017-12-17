package stringAnagram;

import java.util.*;

public class StrAnaGram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrAnaGram s = new StrAnaGram();
		List<Integer> l = s.anagram("abcsdfgfbacfghsdfgcab", "bac");
		for(int i: l) {
			System.out.println(i);
		}
	}
	private List<Integer> anagram(String s, String p){
		List<Integer> res = new ArrayList<>();
		if(s == null || s.length() == 0 || p == null || p.length() == 0) {
			return res;
		}
		int start = 0; int end = 0; int count = p.length();
		int[] letters = new int[26];
		for(int i = 0; i < count; i++) {
			letters[s.charAt(i) - 'a']++;
		}
		while(end < s.length()) {
			if(letters[s.charAt(end) - 'a'] >= 1) {
				count--;
			}
			
			letters[s.charAt(end) - 'a']--;
			end++;
			if(count == 0) {
				res.add(start);
			}
			if(end - start == p.length()) {
				if(letters[s.charAt(start) - 'a'] >= 0) {
					count++;
				}
				
				letters[s.charAt(start) - 'a']++;
				start++;
			}
		}
		return res;
	}
}
