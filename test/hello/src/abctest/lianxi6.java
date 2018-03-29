package abctest;

public class lianxi6 {
	int zuizhong=0,weizhi=0;
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        for(int i=0;i<s.length()-1;i++){
            huibaba(s,i,i);
            huibaba(s,i,i+1);
        }
    return s.substring(weizhi,weizhi+zuizhong);
    }
    public void huibaba(String s,int j,int k){
        int max=0;
        if(j==k) max=-1;
        while(j>=0 && k<s.length() &&s.charAt(j)==s.charAt(k)){
            j--;
            k++;
            max+=2;
        }
        if(max>zuizhong){
            zuizhong=max;
            weizhi=j+1;
        }
    }

}
