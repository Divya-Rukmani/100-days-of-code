
public class Stack {
	
	public static class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data=data;
	}
	}
	
	private Node top;// Node is the top element
	public boolean isEmpty() {
		return top==null;// if top is null return stack is empty
	}
	public int peek() {
		return top.data;// return first element in the stack// stack follows LIFO
	}
	public void push(int data) {
		
		Node node= new Node(data);//  push the new data into the node
		node.next=top;// last top will go to second
		top=node;// assign the new node to top
	}
	public int pop() {
		int data=top.data;//get the top data element
		top=top.next;//assign the second top as new top
		return data;// return the removed top element
	}
	
	public void print() {
		
		 Node node= top;// top as Node
		 while(node.next!=null) { // Check until node next is null
			 System.out.println(node.data); // get node data
			 node=node.next;// node next to traverse
		 }
		 System.out.println(node.data);// print the top element if only one is available in stack
		
		
	}

}
