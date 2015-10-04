import java.util.*;

public class GenericStack<E> {
	private E[] list = (E[])new Object[10];
	
	public int getSize() {
		int size = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null)
				size++;
		}
		return size;
	}
	
	public E peek() {
		return list[getSize() - 1];
	}
	
	public void push(E o) {
		boolean foundSpace = false;
		
		for(int i = 0; i < list.length; i++)
			if(list[i] == null) {
				list[i] = o;
				foundSpace = true;
				break;
			}
		
		if(!foundSpace) {
			E[] tempArr = (E[])new Object[list.length + 10];
			for(int i = 0; i < list.length; i++)
				tempArr[i] = list[i];
			tempArr[getSize() + 1] = o;
			list = tempArr;
		}
			
	}
	
	public E pop() {
		E o = list[getSize() - 1];
		list[getSize() - 1] = null;
		E[] tempArr = (E[])new Object[list.length];
		for(int i = 0; i < list.length; i++)
			if(list[i] != null)
				tempArr[i] = list[i];
		list = tempArr;
		return o;
	}
	
	public boolean isEmpty() {
		boolean empty = true;
		for(E obj: list)
			if(obj != null)
				empty = false;
		return empty;
	}
	
	@Override
	public String toString() {
		String toStringReturn = "";
		for(int i = 0; i < list.length; i++)
			if(list[i] != null)
				toStringReturn += list[i].toString() + " ";
		
		return "stack: " + toStringReturn;
	}
	
}//end class
