class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int n = s.length();
        for(int i =0; i<n; i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(0);
            }
            else
            {
                int x = st.pop();
                int y = 0;
                if(x==0)
                {
                    y =  1;
                }
                else
                {
                    y = 2*x;
                }
                st.push(st.pop() + y);
            }
        }
        return st.pop();
        
    }
}