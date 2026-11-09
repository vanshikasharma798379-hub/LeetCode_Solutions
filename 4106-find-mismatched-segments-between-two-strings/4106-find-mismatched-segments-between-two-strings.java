class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans = new ArrayList<>();
        int n = s1.length();
        int start = -1;
        for(int i =0; i<n; i++)
        {
            if(s1.charAt(i) !=s2.charAt(i))
            {
                if(start == -1)
                {
                    start =i;
                }
            }
            else
            {
                if( start != -1)
                {
                    List<String> temp = new ArrayList<>();
                    temp.add(s1.substring(start , i));
                    temp.add(s2.substring(start , i));
                    ans.add(temp);
                    start =-1;
                }
            }
        }
        if(start != -1)
        {
            List<String> temp = new ArrayList<>();
            temp.add(s1.substring(start));
            temp.add(s2.substring(start));
            ans.add(temp);
        }
        return ans;
        
    }
}