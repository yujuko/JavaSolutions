

//14. Longest Common Prefix
//
//Write a function to find the longest common prefix string amongst an array of strings.
//
//        If there is no common prefix, return an empty string "".
//
//        Example 1:
//
//        Input: ["flower","flow","flight"]
//        Output: "fl"
//        Example 2:
//
//        Input: ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
//        Note:
//
//        All given inputs are in lowercase letters a-z.
//


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if ( strs == null || strs.length == 0 ) return "";
        String carry = strs[0]; //把第一個字串當成比較基準

        for ( int i =1 ; i<strs.length ; i++ ){ //從第二個字串開始比較
            while ( strs[i].indexOf(carry) != 0 ) //若基準字串不再比較字串的第0位, 基準字串從後面少一個字元,再比較
                carry = carry.substring(0, carry.length()-1);

        }
        return carry;
    }
}

ＮＯＴＥ：
1. carry = carry.substring(0, carry.length()-1)
   --> String substring(int beginIndex, int endIndex), String方法：返回一個新字符串，它是此字符串的一個子字符串。
2. i<strs.length -->矩陣.length不用（）
3. carry.length()-1 -->String.length()要（）
4. String carry = strs[0] -->"S"大寫
5. strs == null || strs.length == 0  -->兩個 =
