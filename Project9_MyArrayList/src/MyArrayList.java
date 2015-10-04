
public class MyArrayList<E> {
	private E[] myArray;
	
	public MyArrayList() {
		myArray = (E[]) new Object[10];
	}//constructor
	
	public void clear() {
		myArray = (E[]) new Object[10];
	}//clear
	
	public E get(int index) {
		if(index < 0 || index > size() - 1) {
			System.out.println("Invalid index for get.");
			return null;
		}
		return myArray[index];
	}//get
	
	public E remove(int index) {
		if(index < 0 || index > size() - 1) {
			System.out.println("Invalid index for remove.");
			return null;
		}
		
		E o = myArray[index];
		myArray[index] = null;
		E[] tempArr = (E[])new Object[myArray.length];
		for(int i = 0; i < myArray.length - 1; i++)
			if(myArray[i] != null) {
				int j = 0;
				while(tempArr[j] != null) {
					j++;
				}
				tempArr[j] = myArray[i];
			}
		myArray = tempArr;
		return o;
	}//remove
	
	public int size() {
		int size = 0;
		for(int i = 0; i < myArray.length; i++)
			if(myArray[i] != null) {
				size++;
			}
		return size;
	}//size
	
	public void add(E o) {
		boolean foundSpace = false;		
		for(int i = 0; i < myArray.length - 1; i++)
			if(myArray[i] == null) {
				myArray[i] = o;
				foundSpace = true;
				break;
			}
		
		if(!foundSpace) {
			E[] tempArr = (E[])new Object[myArray.length + 10];
			for(int i = 0; i < myArray.length; i++)
				tempArr[i] = myArray[i];
			tempArr[size() + 1] = o;
			myArray = tempArr;
		}		
	}//add
}//end class