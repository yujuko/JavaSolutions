//The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//        1 is read off as "one 1" or 11.
//        11 is read off as "two 1s" or 21.
//        21 is read off as "one 2, then one 1" or 1211.
//        Given an integer n, generate the nth term of the count-and-say sequence.
//        the nth term is the read-off of the (n - 1)th term
//
//        Note: Each term of the sequence of integers will be represented as a string.
//
//        Example 1:
//
//        Input: 1
//        Output: "1"
//        Example 2:
//
//        Input: 4
//        Output: "1211"

class Solution {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev ;
        int count;
        char num;

        for ( int i=1 ; i<n ; i++ ){ //intput要run的輪數,從上一輪結果的第一位開始再run
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            num = prev.charAt(0);// i=0 第一位開始和下面 J=1 第2位比較
            
            for( int j=1; j<len.length ; j++ ){ //每一run從第一位開始比對,不相同就接上,相同就+1
                if ( prev.charAt(j) != num ){ //第二位！=第一位
                    curr.append(count).append(num); // 接上第一位
                    count = 1;
                    num = prev.charAt(j); //第二位放入第一位下一輪比較
                }
                else{ //第二位 =第一位
                    count ++;
                }
            }
            curr.append(count).append(num); //最後接上最後跳出的一run
        }return curr.toString(); //轉換成固定String
    }
}
