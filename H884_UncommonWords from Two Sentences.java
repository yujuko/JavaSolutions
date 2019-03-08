/*
884. Uncommon Words from Two Sentences

We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.

 

Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]
 

Note:

0 <= A.length <= 200
0 <= B.length <= 200
A and B both contain only spaces and lowercase letters.
*/

//solutions using HashMap:

import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> result = new ArrayList<String>();
        Map<String,Integer> hash = new HashMap<String,Integer>();
        
        int index=0;
        String sub="";
        
        for(int i= 0; i<=A.length(); i++){
            if(i==A.length()|| A.charAt(i)==' '){
                sub = A.substring(index,i);
                // System.out.println(sub);
                if(hash.containsKey(sub)){
                    int oldCount = hash.get(sub);
                    hash.put(sub,oldCount+1);
                }
                else
                    hash.put(sub,1);
                index = i+1;
            }
        }
        index =0;
        for(int i= 0; i<=B.length(); i++){
            if(i==B.length()|| B.charAt(i)==' '){
                sub = B.substring(index,i);
                if(hash.containsKey(sub)){
                    int oldCount = hash.get(sub);
                    hash.put(sub,oldCount+1);
                }
                else
                    hash.put(sub,1);
                index = i+1;
            }
        }
        
        String str ="";
        Set<String> keys = hash.keySet();
        Iterator<String> itr = keys.iterator();
        
        while(itr.hasNext()){
            
            str = itr.next();  
            if(hash.get(str)==1){
                result.add(str);                
            }
        }
    return result.toArray(new String[0]);
    }
}

