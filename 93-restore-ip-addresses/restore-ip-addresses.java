class Solution {
    static List<String> ans=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        helper(s,ans,temp,0,new StringBuilder());
        return ans;
    }
    public static void helper(String s,List<String> ans,List<String> temp,int idx,StringBuilder sb){
        if(idx==s.length() && temp.size()==4){
            for(int j=0;j<temp.size();j++){
                sb.append(temp.get(j)).append((j<3)?".":"");
            }
            ans.add(sb.toString());
            sb.setLength(0);
            return;
        }
        if(temp.size()>4){
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isValid(s.substring(idx,i+1))){
                temp.add(s.substring(idx,i+1));
                helper(s,ans,temp,i+1,sb);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean isValid(String s){
        if(s.length()>3){
            return false;
        }
        if(s.charAt(0)=='0' && s.length()>1){
            return false;
        }
        if(Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }
}