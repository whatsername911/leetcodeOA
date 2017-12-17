package Ancestor;

import java.util.*;
//not work
public class Ancestor {

	class TreeNode {
       int val;
       List<TreeNode> children;
       public TreeNode(int x){
    	   this.val = x;
    	   this.children = new ArrayList<TreeNode>();
       }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ancestor a = new Ancestor();
		TreeNode n1 = a.new TreeNode(1);
		TreeNode n2 = a.new TreeNode(2);
		TreeNode n3 = a.new TreeNode(3);
		TreeNode n4 = a.new TreeNode(4);
		TreeNode n5 = a.new TreeNode(5);
		TreeNode n6 = a.new TreeNode(6);
		TreeNode n7 = a.new TreeNode(7);
		TreeNode n8 = a.new TreeNode(8);
		TreeNode n9 = a.new TreeNode(9);
		TreeNode p = a.new TreeNode(2);
		TreeNode q = a.new TreeNode(6);
		n1.children.add(n2);
		n1.children.add(n3);
		n2.children.add(n4);
		n2.children.add(n5);
		n2.children.add(n6);
		n3.children.add(n7);
		n7.children.add(n8);
		n8.children.add(n9);
		System.out.println(a.common(p, q, n1).val);
		
	}
	public TreeNode common(TreeNode p, TreeNode q, TreeNode root) {
		if(ancestor(p, q, root) == root) {
			return null;
		}
		return ancestor(p, q, root);
	}
	public TreeNode ancestor(TreeNode p, TreeNode q, TreeNode root) {
		if(exist(p, root) && exist(q, root) == false) {
			return null;
		}
		if(root == null || root == p || root == q) {
			return root;
		}
		List<TreeNode> list = new ArrayList<>();
		for(TreeNode c:root.children) {
			if(ancestor(p, q, c) != null) {
				list.add(ancestor(p, q, c));
			}
		}
		if(list.size() == 0) {
			return null;
		}
		if(list.size() == 1) {
			return list.get(0);
		}
		return root;
	}
	public boolean exist(TreeNode p, TreeNode root) {
		if(root == null) {
			return false;
		}
		if(root == p) {
			return true;
		}
		boolean found = false;
		for(TreeNode c:root.children) {
			found = found || exist(p, c);
		}
		return found;
	}
}
