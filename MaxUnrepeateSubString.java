package maxunrepetingsubstring;

import java.util.HashSet;

public class MaxUnrepeateSubString {
	
	public static String longestSubString(String s) {
		int n = s.length();
		HashSet<Character> subString = new HashSet<Character>();
		int i = 0; //left pointer of the sliding window
		int j = 0; //right pointer of the sliding window
		int start = 0; //start index of the longest substring
		int maxLength = 0; //length of the longest substring
		while(j < n) {
			char currentChar = s.charAt(j);
			if(!subString.contains(currentChar)) {
				subString.add(currentChar);
				if(j - i + 1 > maxLength) {
					maxLength = j - i + 1;
					start = i;
				}
				j++;
			}
			else {
				subString.remove(s.charAt(i));
				i++;
			}

		}
		return s.substring(start, start + maxLength);
		
		//"apple"  
		// after the first iteration of j => i = a, j = a subString = [a] start = 0 and maxLength = 1
		// after the second iteration of j => i = a, j = p subString = [a, p], start = 0 and maxLength = 2 start = 0
		// after the third iteration of j=> i = a j = p subString = [p] start = 0 and maxLenght = 2
		// after the fourth iteration of j => i = p j = p subString = [] start = 0 and maxLenght = 2
		// after the fifth iteration of j => i = p j = p subString = [p] start = 0 and maxLength = 2
		// after the sixth iteration of j => i = p j = l subString = [p, l] start = 0 and maxLenght = 2
		// after the seventh iteration of j => i = p j = e subString = [p, l, e] start = 2 and maxLenght = 3
		// "apple" substring(start, start+maxLenght) substring(2,5) => "ple" => largest substring without repetations
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "apple";
		System.out.println(longestSubString(str));
	}

}
