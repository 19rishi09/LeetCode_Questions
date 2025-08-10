class Solution {
    public boolean reorderedPowerOf2(int n) {
        int [] arr=digits(n);
        int val=1;
        for(int i=0;i<31;i++){
            if(Arrays.equals(arr,digits(val))){
                return true;
            }
            val=val*2;
        }
        return false;
    }
    public static int[] digits(int n){
        int [] arr=new int[10];
        while(n>0){
            int rem=n%10;
            arr[rem]++;
            n=n/10;
        }
        return arr;
    }
}