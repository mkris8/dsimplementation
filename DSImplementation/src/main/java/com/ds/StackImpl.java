package com.ds;

public class StackImpl {
	private int TOP = -1;
	private final int MAX_SIZE = 5;

	private Object[] object = new Object[MAX_SIZE];

	public Object[] getNewStack() {
		return object;
	}

	public Object size() {
		return this.TOP;
	}

	public boolean isEmpty() {
		if (TOP == -1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean push(String element_1) throws StackOverFlowException {

		if (++TOP >= MAX_SIZE) {
			throw new StackOverFlowException("stack overflow..");
		}
		this.object[TOP] = element_1;
		return true;

	}

	public Object pop() throws UnderFlowException {

		if (!isEmpty()) {
			String top_object = (String) object[TOP];
			TOP--;
			return top_object;
		} else {
			throw new UnderFlowException("under flow - stack is empty");
		}

	}

	public Object peek() throws UnderFlowException {

		if (!isEmpty()) {
			return object[TOP];
		} else {
			throw new UnderFlowException("peek : stack is empty");
		}
	}

}
