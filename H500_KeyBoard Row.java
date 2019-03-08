/*
500. Keyboard Row

Given a List of words, return the words that can be typed using 
letters of alphabet on only one row's of American keyboard like the image below.

 
Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
 

Note:

You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.

*/

//solution:

import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        Hashtable<Character,Integer> hash = new Hashtable<>();
        List<String> result = new ArrayList<>();
        hash.put('Q',1); 
        hash.put('W',1);
        hash.put('E',1);
        hash.put('R',1);
        hash.put('T',1);
        hash.put('Y',1);
        hash.put('U',1);
        hash.put('I',1);
        hash.put('O',1);
        hash.put('P',1);
        hash.put('q',1); 
        hash.put('w',1);
        hash.put('e',1);
        hash.put('r',1);
        hash.put('t',1);
        hash.put('y',1);
        hash.put('u',1);
        hash.put('i',1);
        hash.put('o',1);
        hash.put('p',1);
        hash.put('A',2);
        hash.put('S',2);
        hash.put('D',2);
        hash.put('F',2);
        hash.put('G',2);
        hash.put('H',2);
        hash.put('J',2);
        hash.put('K',2);
        hash.put('L',2);
        hash.put('a',2);
        hash.put('s',2);
        hash.put('d',2);
        hash.put('f',2);
        hash.put('g',2);
        hash.put('h',2);
        hash.put('j',2);
        hash.put('k',2);
        hash.put('l',2);
        hash.put('Z',3);
        hash.put('X',3);
        hash.put('C',3);
        hash.put('V',3);
        hash.put('B',3);
        hash.put('N',3);
        hash.put('M',3);
        hash.put('z',3);
        hash.put('x',3);
        hash.put('c',3);
        hash.put('v',3);
        hash.put('b',3);
        hash.put('n',3);
        hash.put('m',3);
        
        boolean check = true;
        int i=0;
        
        for(String s :words){
            i=0;
            check = true;
            while(i<s.length()-1){
                if(hash.get(s.charAt(i))!=hash.get(s.charAt(i+1))){
                    check = false;
                    break;
                }
                i++;
            }
            if(check==true){
                result.add(s);
            }
        }        
        return result.toArray(new String[0]);
    }
}

//faster solution - from devkapupara

//Maps each character to the row in the keyboard in which it occurs.
private int[] map = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};

public String[] findWords(String[] words) {

 String[] w = new String[words.length];	// Store filtered words
 int index = 0;							// Where to insert the filtered words
 for (String s: words)					// for each word in words
     if (checkWord(s.toLowerCase()))		// convert it to lowercase and check if all char
         w[index++] = s;					// occurs in the same row, if it does, add it
 return Arrays.copyOfRange(w, 0, index);	// Simply return a copy of the array from 0
}											// index

private boolean checkWord(String word){		// Check if all chars in the word belong in the
 int row = map[word.charAt(0)-'a'];		// same row. Check first chars row
 for (char c: word.toCharArray()){		// For all the chars in the word
     if (map[c-'a'] != row)				// if that char belongs to a different row,
         return false;					// return false
 }
 return true;							// All chars in same row, return true.
}