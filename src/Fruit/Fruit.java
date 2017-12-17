package Fruit;

import java.util.*;

public class Fruit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit f = new Fruit();
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> cart = new ArrayList<String>();
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		List<String> l3 = new ArrayList<String>();
		cart.add("aaa");cart.add("bbb");cart.add("ccc");cart.add("aaa");cart.add("ccc");cart.add("bbb");
		cart.add("ccc");cart.add("aaa");
		l1.add("anything");l1.add("bbb");l1.add("ccc");
		l2.add("bbb");l2.add("ccc");
		l3.add("aaa");l3.add("anything");
		list.add(l1);
		list.add(l2);
		list.add(l3);
		System.out.println(f.fruitMatch(list, cart));
	}
	public int fruitMatch(List<List<String>> list, List<String> cart) {
		int startCart = 0;
		int startList = 0;
		if(list == null) {
			return 1;
		}
		if(cart == null || cart.size() < list.size()) {
			return 0;
		}
		while(true) {
			List<String> l = list.get(startList);
			boolean found = false;
			for(int i = startCart; i <= cart.size() - l.size(); i++) {
				boolean match = true;
				int icart = i;
				for(int j = 0; j < l.size(); j++) {
					
					if(cart.get(icart).equals(l.get(j)) || l.get(j).equals("anything")) {
						icart++;
					}else {
						match = false;
						break;
					}
				}
				if(match) {
					found = true;
					startList++;
					startCart += l.size();
				}
			}
			if(!found) {
				return 0;
			}
			if(startList >= list.size()) {
				return 1;
			}
			if(startCart >= cart.size()) {
				return 0;
			}
		}
	}
}
