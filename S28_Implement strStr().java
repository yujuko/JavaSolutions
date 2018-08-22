
//Implement strStr(). Haystack & Needle
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
            for（ int j = 0 ; ; j++){   //對齊needle第一個字母開始
                if ( j == needle.length() ) return i ;      //若全部needle字母都檢查完畢(確認與haystack相同) 回報i字母位置
                if ( i+j == haystack.length() ) return -1 ; //檢查是否還有放入needle的空間
                if ( haystack.charAt(i+j) != needle.charAt(j)) break; //若兩者字母不同,跳出j,haystack往下一字母檢查
            }
        }
    }
}
--------------------------------------------------------------------------------------------------------------------------------------
        EX:
        hello & ll
        1. i=0 , j=0  hello  X
                      l

        2. i=1 , j=0  hello  X
                       l

        3. i=2 , j=0  hello  O
                        l

           i=2 , j=1  hello  O
                         l

             --> j=2 = needle.length
             --> return i=2
--------------------------------------------------------------------------------------------------------------------------------------
        EX:
        hello & on
        1. i=0 , j=0  hello  X
                      o

        2. i=1 , j=0  hello  X
                       o

        3. i=2 , j=0  hello  X
                        o

        4. i=3 , j=0  hello  X
                         o

        5. i=4 , j=0  hello  O
                          o

             --> j=1 , i+j = 5 == haystack.length 沒有空間放 j=1 字元
             --> return -1

--------------------------------------------------------------------------------------------------------------------------------------
ＮＯＴＥ：
1. needle.length() & haystack.length()
   --> 字串長度方法後面要（）
2. 回傳資料return
   return是直接回傳一個資料型態或無任何型態，而不再繼續向下執行其它敘述句，所以可以中斷迴圈的執行，最常用在函數的回傳值。
   用法上跟break一樣，在需要回傳值或中斷的地方直接輸入return ; 就可以中斷且不向下執行。

