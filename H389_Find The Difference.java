/*

389. Find the Difference

Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Input:
s = "a"
t = "aa"

Output:
a

Explanation:
'e' is the letter that was added.
*/

//great solution using bit manipulation: 3ms

class Solution {
public char findTheDifference(String s, String t) {
	char c = 0;
	for (int i = 0; i < s.length(); ++i) {
		c ^= s.charAt(i);
	}
	for (int i = 0; i < t.length(); ++i) {
		c ^= t.charAt(i);
	}
	return c;
}
}


//1st attempt solution: 19ms 
class Solution {
    public char findTheDifference(String s, String t) {
        char ret = '\0' ;
        List<Character> list = new ArrayList<>();
        
        for(int i =0; i<s.length(); i++){
            list.add(s.charAt(i));
        }
        for(int j =0; j<t.length(); j++){
            if(!list.contains(t.charAt(j)))
                return ret = t.charAt(j);
            list.set(list.indexOf(t.charAt(j)),' ');
        }
        return ret;    
    }
}

//2nd attempt solution: 27ms
class Solution {
    public char findTheDifference(String s, String t) {
        for(int i=0 ;i<s.length();i++){
            t = t.replaceFirst(Character.toString(s.charAt(i)),"");    
        }
        return t.charAt(0);
}
}

//could use sum of String - sum of t String