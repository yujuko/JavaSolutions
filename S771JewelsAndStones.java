//771. Jewels and Stones

//        You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
//
//        The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
//
//        Example 1:
//
//        Input: J = "aA", S = "aAAbbbb"
//        Output: 3
//        Example 2:
//
//        Input: J = "z", S = "ZZ"
//        Output: 0
//        Note:
//
//        S and J will consist of letters and have length at most 50.
//        The characters in J are distinct.

//14ms
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i = 0 ; i<J.length() ; i++){
            for(int j=0; j<S.length(); j++){
                if (J.charAt(i) ==  S.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
}

//one_line solution:
public int numJewelsInStones(String J, String S) {
   return S.replaceAll("[^" + J + "]", "").length();
}

//HashSet solution:
public int numJewelsInStones(String J, String S) {
    int res = 0;
    Set setJ = new HashSet();
    for (char j: J.toCharArray())
        setJ.add(j);
    for (char s: S.toCharArray())
        if (setJ.contains(s))
        res++;
    return res;
}
