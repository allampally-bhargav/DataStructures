import java.util.*;

public class BST {
	 class Node{
		int data;
		Node left;
		Node right;
		public Node(int a){
			data =  a;
			left = null;
			right = null;
		}
	}
	Node root;
    BST(){
    	root = null;
    }
	public void insert(int num){
		root = insertData(num,root);
	}
	
	public Node insertData(int d,Node root){
		if(root == null){
			root = new Node(d);
			return root;
		}
		else if(root.data<d){
		    root.right = insertData(d,root.right);
		}
		else{
			root.left = insertData(d,root.left);
		}
		return root;
	}
	public void inOrder(){ 
	       inOrderTraversal(root); 
	    } 
	
	public void inOrderTraversal(Node root){
		 if(root != null){
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);	
		}
	}
	
	public void delete(int data){
		root = deleteValue(data,root);
	}
	
	 public Node deleteValue(int key,Node root){
		 if(root == null){
			 return root;
		 }
		 if(key<root.data){
			 root.left = deleteValue(key,root.left);
		 }
		 else if(key > root.data){
			 root.right = deleteValue(key,root.right);
		 }
		 else{
			 if(root.left == null){
				 return root.right;
			 }
			 else if(root.right == null){
				 return root.left;
		      }
		 root.data = successor(root.right);
		 System.out.println("successor is :" + root.data);
		 root.right = deleteValue(root.data,root.right);
		 }
	   return root;	 
	 }
	 public int successor(Node root){
		 int val = root.data;
		 if( root.left == null){
			 val = root.data;
		 }
		 else{
			  return successor(root.left);
		 }
		 return val;
	 }
	public static void main(String[]args){
		BST bst = new BST();
		
		bst.insert(8);
		bst.insert(5);
		bst.insert(3);
		bst.insert(10);
		bst.insert(23);
		bst.insert(13);
		bst.insert(9);
		bst.insert(16);
		bst.insert(2);
		bst.insert(41);
		bst.insert(14);
		bst.insert(29);
		bst.insert(7);
		bst.insert(19);
		bst.insert(24);
		System.out.println("inorder traversal");
		bst.inOrder();
		bst.delete(2);
		System.out.println("\ninorder traversal after deleting leaf node 2");
		bst.inOrder();
		System.out.println("\ninorder traversal after deleting a node with subtree 23");
		bst.delete(23);
		bst.inOrder();
		
		
	}
	
}
