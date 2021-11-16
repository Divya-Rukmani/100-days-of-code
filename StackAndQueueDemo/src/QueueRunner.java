
public class QueueRunner {

	public static void main(String[] args) {
		
		Queue queue= new Queue();
		System.out.println("intially queue is empty"+ queue.isEmpty());
		queue.add(10);
		queue.add(40);
		queue.add(70);
		queue.add(90);
		queue.print();
		System.out.println("Last Deleted element in Queue"+queue.remove());
		System.out.println("Now the top element in queue is "+queue.peek());
	}

}
