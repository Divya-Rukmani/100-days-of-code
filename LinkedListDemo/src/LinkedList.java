
public class LinkedList {
	Node head;// inserting node head
	public void insert(int data) {
		
		if(head==null) { // checking if head is null
			head= new Node(data);// if head is null assign the data to the node
			return;
		}
	Node current=head;// inserting next element// assigning head to current to traverse
	if(current.next!=null) { // checking the null condition
		current=current.next;
	}
	current.next=new Node(data);// inserting data to the node
		
	}
	
	public void insertAtBeginning(int data) {
		
		Node newHead= new Node(data);// creating object to insert data in beginning
		newHead.next=head;//shifting head element
		head=newHead;// assigning new head element in the position of Node Head
	}
	public void deleteWithData(int data) {
		
		if(head==null) return;// if head has no data
		if(head.data==data) {// if head is the only data
			head=head.next; //shifting the position of head 
			return;
		}
		Node current=head;// assigning head element to the current element to traverse
		while(current.next!=null) {
			if(current.next.data==data) {
				current.next= current.next.next; // traverse to shift positions
			}
			current=current.next;
			
		}
	}
	public void insertAt(int index,int data) {
		Node node = new Node(data);
		node.data=data;// assign the data to the node
		node.next=null;
		if(index==0) {
			insertAtBeginning(data);// if index value is 0, assign the value at head
		}
		else {
			
			Node current=head;
			for(int i=0;i<index-1;i++) {
				current=current.next; //traverser through the list
			}
			node.next=current.next;
			current.next=node;// assign the value in the position
		}
		
	}
	public void show() {
		 Node node= head;
		 while(node.next!=null) {
			 System.out.println(node.data);
			 node=node.next;
		 }
		 System.out.println(node.data);
		 
		 
	 }

}
