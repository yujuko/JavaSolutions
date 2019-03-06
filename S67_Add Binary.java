//67. Add Binary
//DescriptionHintsSubmissionsDiscussSolution
//Given two binary strings, return their sum (also a binary string).
//
//The input strings are both non-empty and contains only characters 1 or 0.
//
//Example 1:
//Input: a = "11", b = "1"
//Output: "100"
//
//Example 2:
//Input: a = "1010", b = "1011"
//Output: "10101"


class Solution {
    public String addBinary(String a, String b) {
        StringBuilder adds = new StringBuilder(); //Stringbuilder 可以append 及 reverse
        int i = a.length()-1 , j = b.length()-1 , carry = 0; //從最高為加到最低位（右到左）

        while ( i>=0 || j>=0 ){ //左右顛倒
            int sum = carry; //上一輪要進位的放入下一輪再加
            if ( i>=0 ) sum += a.charAt(i--) - '0';
            if ( j>=0 ) sum += a.charAt(j--) - '0'; //把字元的ASCII剪掉0的ASCII會是原本的數字

            adds.append(sum % 2); //不用進位/進位後剩的部分先接上
            carry = sum / 2; //要進位的部分

        }

        if( carry!=0 ) adds.append( carry ); //街上最後的進位
        return adds.reverse().toString(); //反轉
    }
}
