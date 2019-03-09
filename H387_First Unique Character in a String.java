/*

387. First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/


//1st attempt solution using array :12ms
class Solution {
    public int firstUniqChar(String s) {
        int[] cases = new int[26];
        for(int i = 0 ;i < s.length() ; i++){
            cases[s.charAt(i)-'a']++;
        }
        for(int i = 0 ;i <s.length() ; i++){
            if(cases[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
//2nd attempt solution using LinkedHashMap 53ms
class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0 ; i<s.length(); i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        Set<Character> set = map.keySet();
        Iterator<Character> itr = set.iterator();
        while(itr.hasNext()){
            char c = itr.next();
            if(map.get(c)==1){
                return s.indexOf(c);
            }
        }
        return -1;
    }
}

//HashMap 
//makes absolutely no guarantees about the iteration order. 
//It can (and will) even change completely when new elements are added.

//TreeMap 
//will iterate according to the "natural ordering" of the keys according 
//to their compareTo() method (or an externally supplied Comparator). 
//Additionally, it implements the SortedMap interface, which contains 
//methods that depend on this sort order.

//LinkedHashMap 
