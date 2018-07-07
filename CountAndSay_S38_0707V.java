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

        for ( int i=1 ; i<n ; i++ ){
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            num = prev.charAt(0);

            for( int j=1, len = prev.length() ; j<len ; j++ ){
                if ( prev.charAt(j) != num ){
                    curr.append(count).append(num);
                    count = 1;
                    num = prev.charAt(j);
                }
                else{
                    count ++;
                }
            }
            curr.append(count).append(num);
        }return curr.toString();
    }
}