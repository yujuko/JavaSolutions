
//Implement strStr().
//
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//
//        Input: haystack = "hello", needle = "ll"
//        Output: 2
//        Example 2:
//
//        Input: haystack = "aaaaa", needle = "bba"
//        Output: -1
//        Clarification:
//
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
//

class Solution {
    public int strStr(String haystack, String needle) {
        for ( int i = 0 ; ; i++ ){      //對齊haystack第一個字母開始
            for (int j = 0 ; ; j++ ){   //對齊needle第一個字母開始
                if ( j == needle.length() ) return i ;      //若全部needle字母都檢查完畢(確認與haystack相同) 回報i字母位置
                if ( i+j == haystack.length() ) return -1 ; //檢查是否還有放入needle的空間
                if ( haystack.charAt(i+j) != needle.charAt(j)) break; //若兩者字母不同,跳出j,haystack往下一字母檢查
            }
        }
    }
}

//ＮＯＴＥ：
// 回傳資料return
//return是直接回傳一個資料型態或無任何型態，而不再繼續向下執行其它敘述句，所以可以中斷迴圈的執行，最常用在函數的回傳值。
//用法上跟break一樣，在需要回傳值或中斷的地方直接輸入return ; 就可以中斷且不向下執行。