//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//        Example 1:
//        Input: "A man, a plan, a canal: Panama"
//        Output: true`
//
//        Example 2:
//        Input: "race a car"
//        Output: false

// MySolution:

    public boolean isPalindrome(String s) {

            String str = new String ();
            str = s.toLowerCase().replaceAll("[^(a-zA-Z0-9)]", "").replaceAll("\\pP","");
            //"\\pP"用來去除所有符號,不包括空格

            StringBuffer strb = new StringBuffer(str);
            //需用StringBuffer的reverse方法

            String strv  = new String(strb.reverse());
            //需用String的CompareTo方法

            if(str.compareTo(strv)!= 0){
            return false;
            }
            else{
            return true;
            }
    }


// BetterSolution:

    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
    