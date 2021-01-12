package greedy;

import java.util.*;
import java.io.*;

// 백준 2608번 로마숫자
// 1차시 - 성공
public class RomaNum {
	
	static String[] sub = {"IV","IX","XL","XC","CD","CM"};
	
	static HashMap<Character,Integer> rome = new HashMap<>();
	
	public static void solution(String o1, String o2) {
		int n1 = convertRtoN(o1);
		int n2 = convertRtoN(o2);
		
		int sumN = n1+n2;
		
		String sumR = converNtoR(sumN);
		System.out.println(sumN);
		System.out.println(sumR);
	}
	
	public static String converNtoR(int n1) {
		String r1="";
		
		int thousand = n1/1000;
		n1 %= 1000;
		int hundred = n1/100;
		n1 %= 100;
		int ten = n1/10;
		n1 %= 10;
		int one = n1;
		
		if(thousand-4 < 0) {
			while(thousand>0) {
				rome.
				r1+="M";
				thousand--;
			}
		}else if(thousand-4 == 0) {
			// never come here
		}else if(thousand-4 <5) {
			// never come here
		}else if(thousand-4 == 5) {
			// never come here
		}
		
		if(hundred-4 < 0) {
			while(hundred>0) {
				r1+="C";
				hundred--;
			}
		}else if(hundred-4 == 0) {
			r1+="CD";
		}else if(hundred-4 <5) {
			r1+="D";
			while(hundred - 5>0) {
				r1+="C";
				hundred--;
			}
		}else if(hundred-4 == 5) {
			r1+="CM";
		}
		
		if(ten-4 < 0) {
			while(ten>0) {
				r1+="X";
				ten--;
			}
		}else if(ten-4 == 0) {
			r1+="XL";
		}else if(ten-4 <5) {
			r1+="L";
			while(ten - 5>0) {
				r1+="X";
				ten--;
			}
		}else if(ten-4 == 5) {
			r1+="XC";
		}
		
		if(one-4 < 0) {
			while(one>0) {
				r1+="I";
				one--;
			}
		}else if(one-4 == 0) {
			r1+="IV";
		}else if(one-4 <5) {
			r1+="V";
			while(one - 5>0) {
				r1+="I";
				one--;
			}
		}else if(one-4 == 5) {
			r1+="IX";
		}
		
		return r1;
	}

	public static int convertRtoN(String o1) {
		
		int n1=0;
		for(int i=0;i<o1.length();i++) {
			boolean isSub=false;
			for(int j=0;j<sub.length;j++) {
				if(i < o1.length()-1 && o1.substring(i, i+2).equals(sub[j])) {
					isSub=true; 
					n1+=rome.get(o1.charAt(i+1))-rome.get(o1.charAt(i));
					i++;
					break;
				}
			}
			if(!isSub) {
				n1+=rome.get(o1.charAt(i));
			}
		}	
		
		return n1;
	}
	
	
	
	public static void main(final String[] args) throws IOException {

		rome.put('I', 1);
		rome.put('V', 5);
		rome.put('X', 10);
		rome.put('L', 50);
		rome.put('C', 100);
		rome.put('D', 500);
		rome.put('M', 1000);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String o1 = br.readLine();
		String o2 = br.readLine();
		
		solution(o1,o2);
		
	}
}
