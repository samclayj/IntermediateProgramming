import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Italy");
		list.add("Rome");
		list.add("Rome");
		list.add("Rome");
		list.add("Rome");
		list.add("Spain");
		list.add("Istanbul");
		list.add("Houston");
		list.add("Houston");
		list.add("Houston");
		list.add("Houston");
		list.add("Austin");
		list.add("Dallas");
		list.add("Fort Worth");
		list.add("New York");
		list.add("Random");
		list.add("Stuff");
		list.add("City");
		list.add("Yeah");
		list.add("Yeah");
		list.add("City");
		list.add("City");
		list.add("City");

		ArrayList<String> returnedArr = removeDuplicates(list);
		for(String s: returnedArr)
			System.out.println(s);
	}
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> tempArr = list;
		
 		for(int i = 0; i < list.size(); i++) {
			int count = 0;
			for(int j = 0; j < tempArr.size(); j++) {
				if(list.get(i).equals(tempArr.get(j))) {
					count++;
					if(count > 1)
						tempArr.remove(j);
				}//end if
			}//end for j
 		}
 		return tempArr;	
	}
	
}
