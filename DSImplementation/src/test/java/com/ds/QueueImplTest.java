package com.ds;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class QueueImplTest {

	private QueueImpl queueImpl;
	private String element_1= null;
	private String element_2= null;
	private String element_3= null;
	@Before
	public void init(){
		constructDummyInputs();
		queueImpl = new QueueImpl();
	}
	
	@Test
	public void checkIfQueueNotNull() {
		assertNotNull(queueImpl);
	}
	
	@Test
	public void enqueue() throws InvalidInputException{
		assertTrue(queueImpl.enqueue(element_1));
		assertTrue(queueImpl.enqueue(element_2));
		assertTrue(queueImpl.enqueue(element_3));
	}
	
	@Test
	public void checkQueueSizeAfterEnqueue() throws InvalidInputException{
		assertTrue(queueImpl.enqueue(element_1));
		assertTrue(queueImpl.enqueue(element_2));
		assertTrue(queueImpl.enqueue(element_3));

		assertThat(3, is(equalTo(queueImpl.size())));
	}
	
	@Test(expected = InvalidInputException.class)
	public void enqueueInvalidInput() throws InvalidInputException{
		assertTrue(queueImpl.enqueue(""));
	}
	
	@Test
	public void dequeue() throws UnderFlowException, InvalidInputException{
		queueImpl.enqueue(element_1);
		assertTrue(queueImpl.dequeue());
	}
	
	@Test
	public void checkQueueSizeAfterDequeue()throws InvalidInputException, UnderFlowException{
		addElementsIntoQueue();

		queueImpl.dequeue();
		assertThat(2, is(equalTo(queueImpl.size())));
	}

	@Test(expected = UnderFlowException.class)
	public void checkIfQueueAlreadyEmptybeforeDequeue() throws InvalidInputException, UnderFlowException{
		addElementsIntoQueue();
		
		queueImpl.dequeue();
		queueImpl.dequeue();
		queueImpl.dequeue();
		queueImpl.dequeue();
		
	}

	@Test
	public void checkQueuueSize() throws InvalidInputException{
		addElementsIntoQueue();
		assertThat(3, is(equalTo(queueImpl.size())));
	}
	
	private void addElementsIntoQueue() throws InvalidInputException {
		queueImpl.enqueue(element_1);
		queueImpl.enqueue(element_2);
		queueImpl.enqueue(element_3);
	}
	

	private void constructDummyInputs() {
		element_1 = "elt1";
		element_2 = "elt2";
		element_3 = "elt3";
	}

}
