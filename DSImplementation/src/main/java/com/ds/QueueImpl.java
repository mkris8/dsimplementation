package com.ds;

import java.util.LinkedList;
import java.util.List;

public class QueueImpl {

	LinkedList<Object> queue;

	public QueueImpl() {
		queue = new LinkedList<Object>();
	}

	public boolean enqueue(String element_1) throws InvalidInputException {

		if (element_1 == null || element_1 == "") {
			throw new InvalidInputException("Invalid input to the queue");
		} else {
			queue.addFirst(element_1);
			return true;
		}

	}

	public boolean dequeue() throws UnderFlowException {

		boolean result = false;
		result = checkQueueisNotEmptyandPoll();
		return result;
	}

	private boolean checkQueueisNotEmptyandPoll() throws UnderFlowException {
		boolean result;
		if (queue.isEmpty()) {
			result = false;
			throw new UnderFlowException(
					"Cannot perform a dequeue. Queue is already Empty!");
		} else {
			queue.poll();
			result = true;
		}
		return result;
	}

	public Integer size() {
		return queue.size();
	}

}
