/*

953. Verifying an Alien Dictionary

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 

Note:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.
*/

//solutions 5ms
class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        for(int i = 0; i<words.length-1 ;i++){
            int j=0;
            while(j < words[i].length() ){
            	
                if(j >= words[i+1].length())
                    return false;
                
                if(order.indexOf(words[i].charAt(j))>order.indexOf(words[i+1].charAt(j))){
                    System.out.println(words[i].charAt(j)+"."+words[i+1].charAt(j));
                    return false;
                }
                
                if(order.indexOf(words[i].charAt(j)) < order.indexOf(words[i+1].charAt(j)))
                    break;
                j++;
            }
                        
        }
        return true;
    }
}


//solutions 3ms -from rock
/*Analysis:
Outer loop iterates m (= words.length) times, and inner loop runs n (= A[0].length()) times;
map cost O(1) space.

Therefore, Time: O(mn), space: O(1).
*/
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; ++i) { map[order.charAt(i) - 'a'] = i; } // construct mapping to the given order.
        outer:
        for (int i = 1; i < words.length; ++i) { // Verify the adjacent words order.
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); ++j) { // compare the 2 words char by char.
                int pre = words[i - 1].charAt(j) - 'a', cur = words[i].charAt(j) - 'a'; // corresponding indexes in mapping array `map`.
		if (map[pre] > map[cur]) { return false; } // if their relation is NOT compliant with `order`, false.
                else if (map[pre] < map[cur]) { continue outer; } // if current char > previous char, no need to check following chars.
            } // NOTE: only when 1 word is the prefix of the other, can the code excute the following if clause.
            if (words[i - 1].length() > words[i].length()) { return false; } //  current word must NOT be the prefix of and shorter than previous word.
        }
        return true;
    }