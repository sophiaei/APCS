public class Method{
	public static String fenceF(int posts){
		String fenceString = "|";
		for (int i = 1; i < posts; i++){
			fenceString += "--|";		
		}
		return fenceString;
	
	}
	
	public static void main(String[] args){
		System.out.println(fenceF(1));
		System.out.println(fenceF(2));
		System.out.println(fenceF(3));
	
	}
}
