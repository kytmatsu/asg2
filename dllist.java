///*
//Kyle Matsumoto
//kytmatsu
//CMPS012B
//11/5/14
//This is the doubly linked list, with the assigned codes in it.
//*/
//
import static java.lang.System.*;

public class dllist {

	public enum position {
		FIRST, PREVIOUS, FOLLOWING, LAST
	};

	private class node {
		String item;
		node prev;
		node next;
	}

	private node first = null;
	private node current = null;
	private node last = null;
	private int currentPosition = 0;


	public void setPosition(position pos) {
		switch (pos) 
		{
		case FIRST:
			current = first;
			break;
		case PREVIOUS:
			if (current == first)
				break;
			current = current.prev;
			break;
		case FOLLOWING:
			if (current == last)
				break;
			current = current.next;
			break;
		case LAST:
			current = last;
			break;
		default:
			throw new IllegalArgumentException();
		}

	}

	public boolean isEmpty() {
		return first == null;
	}

	public void printLines (){ 
		int line = 0; 
		node x = first; 

		while (x != null) { 
			out.printf("%6d %s%n",line,x.item); 
			line++; 
			x = x.next; 
		} 
	} 


	public String getItem() {
		if (first == null)
		{
			throw new java.util.NoSuchElementException();
		} 
		else
			return current.item;
	}

	public int getPosition() {
		int pos = 0;
		if (current == null) 
		{
			throw new java.util.NoSuchElementException();
		}
		node n = first;

		while (n != current)
		{
			pos++;
			n = n.next;
		}
		currentPosition = pos;
		return currentPosition;

	}

	public void delete() {
		if (current == null) 
		{
			throw new java.util.NoSuchElementException();
		} 
		else if (first == last)
		{ 
			first = null;
			last = null;
			current = null;
		} 
		else if (current == first) 
		{ 
			current = first.next;
			first = current;
			current.prev = null;
		} 
		else if (current == last) 
		{ 
			current = last.prev;
			last = current;
			current.next = null;
		}
		else
		{
			node nextCurr = current.next;
			node prevCurr = current.prev;
			prevCurr.next = nextCurr;
			nextCurr.prev = prevCurr;
			current = nextCurr;
		}

	}

	public void insert(String item, position pos) {
		node temp = new node(); 
		temp.item = item; 


		if ( first == null){ 
			temp.prev = null; 
			temp.next = null; 
			first = temp; 
			last = temp; 
			current = temp; 
			return; 
		} 

		switch (pos)
		{ 
		case PREVIOUS: 
			if (current == first) 
			{ 
				current.prev = temp; 
				temp.next = current; 
				temp.prev = null; 
				current = temp; 
				first = temp; 
			}
			else
			{ 
				node prevCurr = current.prev; 
				current.prev = temp; 
				temp.next = current; 
				prevCurr.next = temp; 
				temp.prev = prevCurr; 
				current = temp; 
			} 
			break; 
		case FOLLOWING: 
			if (current == last)
			{ 
				current.next = temp; 
				temp.prev = current; 
				temp.next = null; 
				current = temp; 
				last = temp; 
			}
			else
			{ 
				node nextCurr = current.next; 
				current.next = temp; 
				temp.prev = current; 
				temp.next = nextCurr; 
				nextCurr.prev = temp; 
				current = temp; 
			} 
			break;

		case FIRST: 
			temp.next = first;
			first = temp;
			current = temp;
			break;
		case LAST:
			if(isEmpty())
			{
				first = temp;
				current = temp;
			}
			else {
				last.next = temp;
				temp.prev = last;
				last = temp;
				current = temp;
			}
			break; 
		default: 
			throw new IllegalArgumentException(); 
		} 

	}

}

