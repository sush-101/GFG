//https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1

class Solution
{   static String gmax = "";
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
        {
            gmax = "";
            findMax(str.toCharArray(),k,0);
            return gmax;
        }
    public static void findMax(char arr[], int k, int pos){
        
        if(arr == null){
            return;
        }
        
        if(String.valueOf(arr).compareTo(gmax) > 0)
            gmax = String.valueOf(arr);
        
        if(k == 0 || pos == arr.length-1){
            return;
        }
        
        char max = arr[pos];
        int len = arr.length;
        
        for(int i=len-1;i>pos;i--){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        if(arr[pos] == max){
            findMax(arr,k,pos+1);
            return;
        }
        for(int i=pos+1;i<len;i++){
            if(arr[i] == max){
                arr[i] = arr[pos];
                arr[pos] = max;
                findMax(arr,k-1,pos+1);
                arr[pos] = arr[i];
                arr[i] = max;
            }
        }
    }
}
