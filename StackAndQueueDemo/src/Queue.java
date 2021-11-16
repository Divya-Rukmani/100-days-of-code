
public class Queue {

	public static class Node{
		public Node next;
		public int data;
		
	public Node(int data) {
		this.data=data;
	}
	}
	
	public Node head;
	public Node tail;
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int peek() {	
		if(head!=null) {
		return head.data;}
		return 0;		
	}
	//add data in tail
	public void add(int data) {
		Node node = new Node(data);
		if(tail!=null) {
			tail.next=node;
		}
		tail=node;
		if(head==null) {
			head=node;
		}
	}
	
	//remove data from head 
	public int remove() {
		int data= head.data;
		head= head.next;
		if(head==null) {
			tail=null;
		}
		return data;
	}
	public void print() {
		
		 Node node= head;
		 while(node.next!=null) { 
			 System.out.println(node.data);
			 node=node.next;
		 }
		 System.out.println(node.data);
		
		
	}
}
