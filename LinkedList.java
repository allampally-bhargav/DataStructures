

import java.util.*;
public class LinkedList {
	
    class Node{
		 int data;
		 Node next;
		 }
    
    Node head;
    
    // Inserting elements into LinkedList
    public void insertData(int d){
    	Node node1 = new Node();
    	if(head == null){
    		node1.data = d;
    		node1.next = null;
    		head = node1;
    	}
    	else{

    		Node temp = head;
    		while(temp.next!= null){
    			temp = temp.next;
    		}
    		node1.data = d;
    		temp.next = node1;
    		node1.next = null;
    	}
   }
    
   //Implementation of selection sort in LinkedList
   public void dataSort(){	
	   		Node temp = head;
	   		Node temp2;
	   		Node firstele = head;
	   		
	   		while(temp.next!= null){
	   			Node minele = temp;
	   			Node temp1 = temp;
	   			Node lastele = temp;
	   			while(temp1.next != null){
	   				if(minele.data > temp1.next.data){
	   					minele = temp1.next;
	   					lastele = temp1;
	   				}
	   				temp1= temp1.next;
	   			}
	   			if(minele != temp){
	   				
	   				if(lastele != temp){
	   					
	   					lastele.next = temp;
	   					temp2 = temp.next;
	   					temp.next = minele.next;
	   					minele.next = temp2;
	   				}
	   				else{
	   					temp.next = minele.next;
	   					minele.next = temp;
	   				}
	   				
	   			if(firstele!=temp){
	   				firstele.next = minele;
	   			}
	   			else{
	   				head = minele;
	   			}
	   		}
	   			
	   		temp = minele;
	   		firstele = temp;
	   		temp= temp.next;
	   	 }
	   	}
   
   //displaying the elements of LinkedList
   public void displayValues(){
   	   Node temp1 = head;
   	   
   	   while(temp1 != null){
   	   	System.out.println("number is " + temp1.data);
   	   	temp1 = temp1.next;
   	   }
   	   
   }
   	  
   public static void main(String[] args){
   	 LinkedList l = new LinkedList();
   	 
   	 Random rand = new Random();
   	 for(int i = 0;i<15;i++){
   		int  r = rand.nextInt(15);
   	    l.insertData(r);
   	 }
   	 
   	 l.displayValues();
   	 l.dataSort();
   	 System.out.println("\nValues after sort\n");
   	 l.displayValues();
   } 	
}

