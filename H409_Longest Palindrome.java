/*

409. Longest Palindrome

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

//solution using HashMap : 9ms beats 46%

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hash = new HashMap<>();
        int len = 0;
        for(int i=0; i<s.length() ; i++){
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(Integer l : hash.values()){
            if(l>=2){
                len+=l/2;
            }
        }
        len *=2;
        if(len<s.length())
            len++;
        return len;
    }
}

//faster solution using two arrays : 4ms beats 99.24%
public int longestPalindrome(String s) {
    int[] lowercase = new int[26];
    int[] uppercase = new int[26];
    int res = 0;
    for (int i = 0; i < s.length(); i++){
        char temp = s.charAt(i);
        if (temp >= 97) lowercase[temp-'a']++;
        else uppercase[temp-'A']++;
    }
    for (int i = 0; i < 26; i++){
        res+=(lowercase[i]/2)*2;
        res+=(uppercase[i]/2)*2;
    }
    return res == s.length() ? res : res+1;
        
}