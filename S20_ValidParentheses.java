

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.
//
//        Example 1:
//
//        Input: "()"
//        Output: true
//        Example 2:
//
//        Input: "()[]{}"
//        Output: true
//        Example 3:
//
//        Input: "(]"
//        Output: false
//        Example 4:
//
//        Input: "([)]"
//        Output: false
//        Example 5:
//
//        Input: "{[]}"
//        Output: true



import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>(); //建立新Stack

        for( char a : s.toCharArray()){ //把字串換成字元陣列,從最左邊開始

            if ( a == '(') st.push(')');
            else if ( a == '[') st.push(']');
            else if ( a == '{') st.push('}');
            else if ( st.isEmpty() || st.pop()!= a ) return false;
            //若為左括弧則推進右括弧,若不是左括弧應該和最後推進的右括弧相等
        }
        return st.isEmpty() ;
    }
}

NOTE :
1. Stack<Character> st = new Stack<Character>();
   --> 'S'tack 要大寫
   --> new Stack<Character>() 最後記得（）
2. s.toCharArray() ,st.isEmpty(),st.pop()
   --> 最後要()
        
