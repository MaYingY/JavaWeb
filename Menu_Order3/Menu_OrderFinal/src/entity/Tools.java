package entity;

public class Tools {
	public boolean IsInteger(String name) {
		boolean result=true;
		 for (int i = 0; i < name.length(); i++){
			   //System.out.println(name.charAt(i));
			   if (!Character.isDigit(name.charAt(i))){
			    result=false;
			   }
			  }
		return result;	
	}
}