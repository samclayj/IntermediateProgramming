import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		for(int i = 0; i < 40; i++) 
			intList.add(new Integer(i));

		for(int i = 0; i < intList.size(); i++)
			System.out.print(intList.get(i) + " ");
		shuffle(intList);
		
		System.out.println();
		for(int i = 0; i < intList.size(); i++)
			System.out.print(intList.get(i) + " ");
		
	}//end main
	
	public static void shuffle(ArrayList<Integer> list) {
		
		for(int i = 0; i < list.size(); i++) {
			int index = (int)(Math.random() * list.size());
			Integer temp = list.get(i);
			list.set(i, list.get(index));
			list.set(index, temp);
		}//end
	}//end shuffle
	
}
