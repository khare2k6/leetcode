import java.util.*;

public class MorrisNumber{

public static void main(String[]argv){
int count=0;
int number;
List<Integer>inputList = new ArrayList<Integer>();
List<Integer>sol = new ArrayList<Integer>();
inputList.add(1);

int limit = 7;
int p = 0, q = 0;

do{
	if(q<inputList.size() && (inputList.get(p) == inputList.get(q))){
		q++;
	}
	else{
		sol.add(q-p);
		sol.add(inputList.get(p));
		p = q;
		
		if(q==inputList.size()){
			inputList = new ArrayList<Integer>(sol);
			System.out.println("Num:"+sol);
			sol.clear();
			count++;
			p=q=0;
		}
	}
}while(count <=limit);
}
}

/**
 Time complexity: O(n), where n is the number of morris numbers required.
Space complexity: O(d), where d is the max number of digits in nth morris number.
**/
