package doublyLinkedList;

public class Main<T> extends DoubleLinkedList<T>{
	
	public static void main(String[] args)
	
	{
		 DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
		
		 	linkedList.addToFirst(1);
	        linkedList.addToFirst(2);
	        linkedList.addToFirst(3);

	        linkedList.addToLast(4);

	        linkedList.addToFirst(1);
	        linkedList.addToFirst(2);
	        linkedList.addToFirst(3);

	        linkedList.traverse();

	        linkedList.delete(1);

	        linkedList.traverse();

	        System.out.println("Adding value 5 at index 1");
	        linkedList.addToIndex(5, 1);

	        linkedList.traverse();

	        System.out.println("Deleting node at index 2");
	        linkedList.deleteNodeAtIndex(2);

	        linkedList.traverse();

	        System.out.println("Deleting node At index 3");
	        linkedList.deleteNodeAtIndex(3);

	        System.out.println(linkedList.getNodeAtIndex(5).getData());
	        linkedList.traverse();
	        
	        
	}

}
