package applications;

import implementationClasses.BasicQueueImpl;

public class TicketCounterQueue {
	
	static BasicQueueImpl<String> queueArray = new BasicQueueImpl<String>();
	public static void main(String[] args) {
		
		System.out.println("New members in the Queue");
		System.out.println("------------------------");
		populateQueue();
		System.out.println("Current Size of Queue: " + checkNumberOfPeopleInTheCounter());
		queueArray.printQueue();
		
		System.out.println("\n");
		System.out.println("Issuing Tickets to everyone...");
		System.out.println("------------------------------");
		issueTicketsToEveryone();
		System.out.println("Current Size of Queue: " + checkNumberOfPeopleInTheCounter());
		queueArray.printQueue();

		System.out.println("\n");
		System.out.println("Repopulating the Queue");
		System.out.println("----------------------");
		System.out.println("Current Size of Queue: " + checkNumberOfPeopleInTheCounter());
		queueArray.printQueue();
		
		System.out.println("\n");
		System.out.println("Serving only the first two customers");
		System.out.println("------------------------------------");
		serveFirstNCustomers(2);
		System.out.println("Current Size of Queue: " + checkNumberOfPeopleInTheCounter());
		queueArray.printQueue();
		
	}
	
	public static void populateQueue() {
		queueArray.enQueue("Bruce");
		queueArray.enQueue("Jason");
		queueArray.enQueue("Alfred");
		queueArray.enQueue("Cassandra");
		queueArray.enQueue("Gordon");
	}
	
	public static void issueTicketsToEveryone() {
		for (int i=0; i<checkNumberOfPeopleInTheCounter(); i++) {
			System.out.println("Tickets issued to: " + queueArray.deQueue());
		}
	}
	
	public static int checkNumberOfPeopleInTheCounter() {
		int size = queueArray.size();
		//System.out.println("Current size of the queue: " + size);
		return size;
	}

	public static String serveFirstNCustomers(int num) {
		return queueArray.accessItem(num);
	}
}
