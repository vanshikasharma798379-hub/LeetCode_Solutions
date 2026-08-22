class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i<s.length(); i++) {
            String str = "";
            for (int j = i; j<s.length(); j++) {
                char ch=s.charAt(j);
                if (str.contains(String.valueOf(ch))) {
                    break;
                }
                str=str+ch;
                if (str.length() > maxLength) {
                    maxLength = str.length();
                }
            }
        }
        return maxLength;
    }
}