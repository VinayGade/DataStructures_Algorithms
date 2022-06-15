package linked_list.double_ended;

import linked_list.exceptions.EmptyListException;

public class DELOperations {

	public static void main(String[] args) {

		DoubleEndedList list = new DoubleEndedList();

		try {
			
			System.out.println("Double Ended List is Empty ?"+list.isEmpty());
			
			list.insertFirst(20);

			list.insertLast(30);
			list.insertLast(50);
			list.insertLast(100);

			list.display();

			list.insertFirst(15);
			list.insertFirst(10);
			list.insertFirst(5);

			list.display();

			list.deleteFirst();
			list.deleteLast();
			
			list.display();
			
			list.deleteFirst();
			list.deleteLast();
			
			list.display();
			System.out.println("Double Ended List is Empty ?"+list.isEmpty());
		} catch (EmptyListException e) {

			e.printStackTrace();
		}
	}

}
