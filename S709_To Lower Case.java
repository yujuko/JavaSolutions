//709. To Lower Case
//
//        Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
//
//
//
//        Example 1:
//
//        Input: "Hello"
//        Output: "hello"
//        Example 2:
//
//        Input: "here"
//        Output: "here"
//        Example 3:
//
//        Input: "LOVELY"
//        Output: "lovely"

//Runtime: 1 ms
class Solution {
    public String toLowerCase(String str) {

        for(int i = 0; i<str.length() ; i++){
            if( 64 <str.charAt(i) && str.charAt(i) < 91)
                str = str.replace(str.charAt(i), (char)(str.charAt(i)+32));
        }
        return str ;}
}

//toCharArray solution:
public String toLowerCase(String str) {
    char[] a = str.toCharArray();
    for (int i = 0; i < a.length; i++)
        if ('A' <= a[i] && a[i] <= 'Z')
            a[i] = (char) (a[i] - 'A' + 'a');
    return new String(a);
}