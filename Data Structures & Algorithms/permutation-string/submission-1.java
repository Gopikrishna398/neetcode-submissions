class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] need=new int[26];
        int[] window=new int[26];
        int k=s1.length();
        if(k>s2.length()) return false;

        for(int i=0;i<k;i++){
            char ch=s1.charAt(i);
            need[ch-'a']++;
        }
        for(int r=0;r<k;r++){
            char ch=s2.charAt(r);
            window[ch-'a']++;
        }
        if(Arrays.equals(need,window)) return true;

        for(int r=k;r<s2.length();r++){
            window[s2.charAt(r)-'a']++;
            window[s2.charAt(r-k)-'a']--;

            if(Arrays.equals(need,window)) return true;
        }
        return false;
    }
}
