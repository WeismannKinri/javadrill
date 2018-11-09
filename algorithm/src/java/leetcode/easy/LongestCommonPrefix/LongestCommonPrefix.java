package leetcode.easy.LongestCommonPrefix;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int num=strs.length;//num为总共几个字符串
        if(num==0){
            return "";
        }
        if(num==1){
            return strs[0];
        }
        int min=strs[0].length();
        for(int i=1;i<num;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
            }
        }//得到最小的长度
        StringBuilder a=new StringBuilder();
        for(int i=0;i<min;i++){
            char now=strs[0].charAt(i);
            for(int j=1;j<num;j++){
                if(strs[j].charAt(i)!=now){
                    return a.toString();
                }
            }
            a.append(now);
        }
        return a.toString();
    }
}

