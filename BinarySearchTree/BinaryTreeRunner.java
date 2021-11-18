import java.util.*;

public class BinaryTreeRunner{
	
	public static void main(String args[]){

		
        Node root = new Node(10);
        root.insert(10);
        root.insert(56);
        root.insert(6);
        root.insert(11);
        root.insert(4);
        root.printTree();
        System.out.println("Is Tree Contains value 27 "+root.contains(27));
	}
}