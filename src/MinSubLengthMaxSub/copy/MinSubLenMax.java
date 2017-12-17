package MinSubLengthMaxSub.copy;

import java.util.*;

public class MinSubLenMax {
	public class Interval {
		int start;
		int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinSubLenMax m = new MinSubLenMax();
		String s = "abecaehjtkt";
		char[] ch = s.toCharArray();
		
		List<Character> list = new ArrayList<Character>();
		for(char c: ch) {
			list.add(c);
		}
		List<Integer> listint = m.partition(list);
		for(int i:listint) {
		System.out.println(i);
		}
	}
	public List<Integer> partition(List<Character> list){
		
		Map<Character, Interval> map = new HashMap<Character, Interval>();
		for(int i = 0; i < list.size(); i++) {
			Character c = list.get(i);
			if(map.containsKey(c)) {
				Interval inv = map.get(c);
				inv.end = i;
				map.put(c, inv);
			}else {
				Interval inv = new Interval(i, i);
				map.put(c, inv);
			}
		}
		List<Interval> intervals = new ArrayList<Interval>();
		for(char ch : map.keySet()) {
//			if(map.get(ch).start != map.get(ch).end) {
				intervals.add(map.get(ch));		
//			}
		}
		
		List<Interval> mergeinv =  merge(intervals);
		int start = -1;
		List<Integer> res = new ArrayList<Integer>();
		for(Interval inv: mergeinv) {
			res.add(inv.end - start);
			start = inv.end;
		}
		if(start != list.size() - 1) {
			res.add(list.size() - 1 - start);
		}
		return res;
	}
	private List<Interval> merge(List<Interval> intervals){
		List<Interval> res = new ArrayList<Interval>();
		if(intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.size(), new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if(i1.start < i2.start) {
					return -1;
					
				}else if(i1.start > i2.start) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		for(Interval interval : intervals) {
			pq.offer(interval);
		}
		Interval i = pq.poll();
		while(!pq.isEmpty()) {
			Interval j = pq.poll();
			if(j.start > i.end) {
				res.add(i);
				i = j;
			}else {
				i.end = Math.max(i.end, j.end);
			}
		}
		res.add(i);
		return res;
	}
}
