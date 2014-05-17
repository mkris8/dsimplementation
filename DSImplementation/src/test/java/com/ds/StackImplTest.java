package com.ds;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StackImplTest {

	private StackImpl stackImpl;
	private final int MAX_SIZE = 5;
	private final int MIN_SIZE = 0;

	private Object[] object;

	@Before
	public void init() {
		stackImpl = new StackImpl();
	}

	@Test
	public void stackNotNULL() {
		this.object = stackImpl.getNewStack();
		assertNotNull(object);
	}

	@Test
	public void push() {
		String element_1 = "abc";
		assertTrue(stackImpl.push(element_1));
		assertThat(0, is(equalTo(stackImpl.size())));
	}

	@Test(expected = StackOverFlowException.class)
	public void overFlow() throws StackOverFlowException{
		stackImpl.push("one");
		stackImpl.push("two");
		stackImpl.push("three");
		stackImpl.push("four");
		stackImpl.push("five");
		stackImpl.push("overflow-element");
	}
	
	@Test
	public void pop() throws UnderFlowException {
		//stackImpl = buildTestStack(MAX_SIZE);
		
		stackImpl.push("element_0");
		stackImpl.push("element_1");
		String top_object = (String) stackImpl.pop();
		assertThat("element_1", is(equalTo(top_object)));
	}

	@Test(expected=UnderFlowException.class)
	public void stackUnderFlowonPop() throws UnderFlowException{
		assertThat(-1, is(equalTo(stackImpl.size())));
		stackImpl.pop();
	}
	
	@Test
	public void peek() throws UnderFlowException {
		stackImpl.push("element_0");
		String peek_top_element = (String)stackImpl.peek();
		assertNotNull(peek_top_element);
		assertThat("element_0", is(equalTo(peek_top_element)));
	}

	@Test(expected=UnderFlowException.class)
	public void peekUnderFlow() throws UnderFlowException {
		String peek_top_element = (String)stackImpl.peek();
		assertNotNull(peek_top_element);
	}
	
	@Test
	public void size() {
		assertNotNull(stackImpl.size());
	}

	@Test
	public void PushandPop() throws UnderFlowException{
		stackImpl.push("one");
		stackImpl.push("two");
		stackImpl.push("element on top");
		stackImpl.pop();
		assertThat("two", is(equalTo(stackImpl.peek())));
	}
	
	private StackImpl buildTestStack(int MAX_SIZE) {
		String element_ = "element_";

		for (int index = 0; index < MAX_SIZE; index++) {
			stackImpl.push(element_ + index);
		}

		return stackImpl;
	}

}
