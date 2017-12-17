package WareHouse;
import java.util.*;
public class WareHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WareHouse w = new WareHouse();
		List<List<Integer>> list =  new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		List<Integer> l4 = new ArrayList<Integer>();
		l1.add(1);l1.add(-1);
		l2.add(8);l2.add(-1);
		l3.add(2);l3.add(-6);
		l4.add(3);l4.add(-5);
		list.add(l1);list.add(l2);list.add(l3);list.add(l4);
		
		List<List<Integer>> res= w.topKNearest(2, list);
		for(List<Integer> ll : res) {
			for(int i : ll) {
				System.out.print(i + ",");
			}
			System.out.println("");
		}
	}
	
	public List<List<Integer>> topKNearest(int n, List<List<Integer>> list) {
		if(list == null || list.size() == 0) {
			return list;
		}
		int size = Math.min(n, list.size());
		PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(size, new Comparator<List<Integer>>() {

			public int compare(List<Integer> l1, List<Integer> l2) {
				// TODO Auto-generated method stub
				return (l1.get(0) * l1.get(0) + l1.get(1) * l1.get(1)) - (l2.get(0) * l2.get(0) + l2.get(1) * l2.get(1));
			}
			
		});
		for(List<Integer> l : list) {
			pq.offer(l);
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i < size; i++) {
			res.add(pq.poll());
		}
		return res;
	}

}
