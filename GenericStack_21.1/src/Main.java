
public class Main {

	public static void main(String[] args) {
		GenericStack<String> stack = new GenericStack<String>();
		stack.push("London");
		stack.push("Paris");
		stack.push("Berlin");
		
		System.out.println(stack.toString());
		
		stack.pop();
		
		System.out.println(stack.toString());

		stack.push("Italy");
		stack.push("Rome");
		stack.push("Spain");
		stack.push("Istanbul");
		stack.push("Houston");
		stack.push("Austin");
		stack.push("Dallas");
		stack.push("Fort Worth");
		stack.push("New York");
		stack.push("Random");
		stack.push("Stuff");
		stack.push("City");
		stack.push("Yeah");
		System.out.println(stack.toString());

		

	}
	
}
