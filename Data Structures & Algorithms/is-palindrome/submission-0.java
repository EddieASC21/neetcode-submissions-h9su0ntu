class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right){
            // if the left pointer is on a non-alphanumeric, we skip over it
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            // if the right pointer is on a non-alphanumeric, we skip over it
            while(right > left && !Character.isLetterOrDigit(s.charAt(right))) right--;
            // we compare the characters at our pointers
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            // we move both pointers towards the center
            left++;
            right--;
        }

        return true;
    }
}
