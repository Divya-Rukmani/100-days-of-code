
public class LinkedListRunner {

	public static void main(String args[]) {
		
		LinkedList list= new LinkedList();
		list.insert(40);
		list.insert(50);
		list.insert(70);
		list.insertAtBeginning(80);
		list.deleteWithData(50);
		list.insertAt(2, 55);
		list.show();
		
	}
}
