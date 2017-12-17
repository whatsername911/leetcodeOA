package TagList;

import java.util.*;

public class TagList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TagList t = new TagList();
		List<String> target = new ArrayList<String>();
		List<String> avai = new ArrayList<String>();
		String s1 = "abbsbscb";
		String s2 = "absdbscbfcbdcbbssgesdabs";
		for(int i = 2; i <= s1.length(); i+=2) {
			target.add(s1.substring(i-2, i));
		}
		for(int i = 2; i <= s2.length(); i+=2) {
			avai.add(s2.substring(i-2, i));
		}
		List<Integer> l = t.subTags2(target, avai);
		for(int i:l) {
			System.out.println(i);
		}
	}
	public List<Integer> subTags(List<String> target, List<String> avai){
		Map<String, Queue<Integer>> map = new HashMap<String, Queue<Integer>>();
		for(int i = 0; i < avai.size(); i++) {
			String s = avai.get(i);
			if(target.contains(s)) {
				if(map.containsKey(s)) {
					Queue<Integer> q = map.get(s);
					q.offer(i);
					map.put(s, q);
				}else {
					Queue<Integer> q = new LinkedList<Integer>();
					q.offer(i);
					map.put(s, q);
				}
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		
		if(map.size() != target.size()) {
			return res;
		}

		int minSoFar = Integer.MAX_VALUE;
		int maxSoFar = 0;
		int resSoFar = Integer.MAX_VALUE;
		while(true) {
			String mins = "";
			int min = Integer.MAX_VALUE;
			int max= 0;
			for(String s : map.keySet()) {
				int i = map.get(s).peek();
				if(i > max) {
					max = i;
				}
				if(i < min) {
					min = i;
					mins = s;
				}
			}
			if(max - min < resSoFar ) {
				minSoFar = min;
				maxSoFar = max;
				resSoFar = max - min;
			}
			Queue<Integer> q = map.get(mins);
			q.poll();
			if(q.isEmpty()) {
				res.add(minSoFar);
				res.add(maxSoFar);
				return res;
			}
			map.put(mins, q);
		}
	}
	public List<Integer> subTags2(List<String> target, List<String> avai){
		Map<String, Integer> map = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		if(target == null || avai == null || target.size() == 0 || avai.size() == 0) {
			return res;
		}
		int count = 0;
		for(String t: target) {
			if(map.containsKey(t)) {
				map.put(t, map.get(t) + 1);
			}else {
				map.put(t, 1);
				
			}
			count++;
		}
		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		int minleft = -1;
		int minright = -1;
		while(right < avai.size()) {
			while(right < avai.size() && count > 0) {
				String s = avai.get(right);
				if(map.containsKey(s) && map.get(s) > 0) {
					map.put(s,  map.get(s) - 1);
					count--;
				}
				right++;
			}
			if(right >= avai.size() && count != 0 && minleft == -1 && minright == -1) {
				return res;
			}
			while(left <= right && count == 0) {
				String l = avai.get(left);
				if(map.containsKey(l)) {
					map.put(l,  map.get(l) + 1);
					count++;
				}
				left++;
			}
			if(right - left < min) {
				min = right - left;
				minleft = left - 1;
				minright = right - 1;
			}
		}
		res.add(minleft);
		res.add(minright);
		return res;
	}
}
