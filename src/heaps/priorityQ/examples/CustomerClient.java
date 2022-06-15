package heaps.priorityQ.examples;

import java.util.PriorityQueue;
import java.util.Queue;

public class CustomerClient {

	public static void main(String[] args) {
		
		CustomerOrder c1 = new CustomerOrder(1, 100.0, "customer1");
		CustomerOrder c2 = new CustomerOrder(3, 50.0, "customer3");
		CustomerOrder c3 = new CustomerOrder(2, 300.0, "customer2");
		
		CustomerOrder c4 = new CustomerOrder(5, 500.0, "customer5");
		CustomerOrder c5 = new CustomerOrder(6, 450.0, "customer6");
		CustomerOrder c6 = new CustomerOrder(4, 600.0, "customer4");

		Queue<CustomerOrder> customerOrders = new PriorityQueue<>();
		customerOrders.add(c1);
		customerOrders.add(c2);
		customerOrders.add(c3);
		customerOrders.add(c5);
		while (!customerOrders.isEmpty()) {
			System.out.println(customerOrders.poll());
		}
		
		System.out.println("\n * * * * Customer orders by amount :: * * * * ");
		Queue<CustomerOrder> customerOrdersByAmount = new PriorityQueue<>(new CustomerOrderAmountComparator());

		customerOrdersByAmount.add(c1);
		customerOrdersByAmount.add(c2);
		customerOrdersByAmount.add(c3);
		
		customerOrdersByAmount.add(c4);
		customerOrdersByAmount.add(c5);
		customerOrdersByAmount.add(c6);
		
		while (!customerOrdersByAmount.isEmpty()) {
			System.out.println(customerOrdersByAmount.poll());
		}
		
	}

}
