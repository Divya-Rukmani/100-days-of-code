
public class StackRunner {
	
	
	public static void main(String[] args) {
		Stack stack= new Stack();
		System.out.println("intially stack is empty"+ stack.isEmpty());
		stack.push(10);
		stack.push(40);
		stack.push(70);
		stack.print();
		System.out.println("Last Deleted element"+stack.pop());
		System.out.println("Now the top element is "+stack.peek());

	}

}
