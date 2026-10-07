class Solution {
    public int largestRectangleArea(int[] nums) {
        int n=nums.length;
        int[] nse=nse(nums);
        int[] pse=pse(nums);
        int maxR=0;
        for(int i=0;i<n;i++){
            int l=pse[i];
            int r=nse[i];
            int area=(r-l-1)*nums[i];
            maxR=Math.max(maxR,area);
        }
        return maxR;

        
    }
    int[] nse(int[] nums){
        int sm=Integer.MAX_VALUE;
        int n=nums.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            nse[i]=(st.isEmpty())?n:st.peek();

            st.push(i);
        }
        return nse;
    }
     int[] pse(int[] nums){
        int sm=Integer.MAX_VALUE;
        int n=nums.length;
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            pse[i]=(st.isEmpty())?-1:st.peek();

            st.push(i);
        }
        return pse;
    }
}
