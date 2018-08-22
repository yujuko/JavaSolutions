

//        58. Length of Last Word
//
//        Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
//        return the length of last word in the string.
//
//        If the last word does not exist, return 0.
//
//        Note: A word is defined as a character sequence consists of non-space characters only.
//
//        Example:
//
//        Input: "Hello World"
//        Output: 5


public class LengthOfLastWord {
        public int lengthOfLastWord(String s) {

            s = s.trim();
            int lastIndex = s.lastIndexOf(' ') + 1;
            return s.length() - lastIndex;

        }
    }
}


NOTE:
1. String trim() 方法 --> 去除前後空白後返回字串
2. int lastIndexOf(int ch)    返回指定字符在此字符串中最後一次出現處的索引。
   int lastIndexOf(int ch, int fromIndex)    返回指定字符在此字符串中最後一次出現處的索引，從指定的索引處開始進行反向搜索。
   int lastIndexOf(String str)    返回指定子字符串在此字符串中最右邊出現處的索引。
   int lastIndexOf(String str, int fromIndex)    返回指定子字符串在此字符串中最後一次出現處的索引，從指定的索引開始反向搜索。
