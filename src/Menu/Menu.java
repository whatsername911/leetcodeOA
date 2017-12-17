package Menu;

import java.util.*;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> people = new ArrayList<>();
		List<String> dish = new ArrayList<>();
		people.add("a");
		people.add("*");
		people.add("b");
		people.add("1");
		people.add("b");
		people.add("2");
		people.add("c");
		people.add("3");
		people.add("d");
		people.add("4");
		dish.add("1");
		dish.add("gg");
		dish.add("1");
		dish.add("tt");
		dish.add("2");
		dish.add("ii");
		dish.add("4");
		dish.add("pp");
		Menu m = new Menu();
		List<List<String>> list = m.menu(people, dish);
		for(List<String> l:list) {
			for(String s : l) {
				System.out.print(s + ",");
			}
			System.out.println("");
		}
	}
	public List<List<String>> menu(List<String> people, List<String> dish){
		Map<String, Set<String>> p = new HashMap<>();
		HashSet<String> dishes = new HashSet<>();
		for(int i = 0; i < people.size() ; i+= 2) {
			String s1 = people.get(i);
			String s2 = people.get(i+ 1);
			if(p.containsKey(s1)) {
				Set<String> set = p.get(s1);
				set.add(s2);
				p.put(s1, set);
			}else {
				Set<String> set = new HashSet<>();
				set.add(s2);
				p.put(s1, set);
			}
			
//			category.add(s2);
		}
		Map<String, Set<String>>  d = new HashMap<>();
		for(int i = 0; i < dish.size() ; i+= 2) {
			String s1 = dish.get(i);
			String s2 = dish.get(i+ 1);
			if(d.get(s1) == null) {
				Set<String> set = new HashSet<>();
				set.add(s2);
				d.put(s1, set);
			}else {
				Set<String> set = d.get(s1);
				set.add(s2);
				d.put(s1, set);
			}
			dishes.add(s2);
		}
		List<List<String>> res= new ArrayList<>();
		for(String s : p.keySet()) {
			for(String cat : p.get(s)) {
				if(d.containsKey(cat)) {
					for(String set: d.get(cat)) {
						List<String> temp = new ArrayList<>();
						temp.add(s);
						temp.add(set);
						res.add(temp);
					}
				}else if(cat == "*") {
					for(String m : dishes) {
						List<String> temp = new ArrayList<>();
						temp.add(s);
						temp.add(m);
						res.add(temp);					
					}
				}
			}
		}
		return res;
	}
}
