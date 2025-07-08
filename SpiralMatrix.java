import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        ArrayList<Integer> ans= new ArrayList<>();

        int m= arr.length;
        int n= arr[0].length;
        int minR=0;
        int maxR=m-1;
        int minC=0;
        int maxC= n-1;
        while(minC<=maxC && minR<=maxR ){
            if(minC>maxC||minR>maxR) break;
            for(int i=minC;i<=minC;i++){
                for(int j=i;j<=maxC;j++){
                    ans.add(arr[i][j]);
                }
            }
            minR++;
            if(minC>maxC||minR>maxR) break;
            for(int j=maxC;j<=maxC;j++){
                for(int i=minR;i<=maxR;i++){
                    ans.add(arr[i][j]);
                }
            }
            maxC--;
            if(minC>maxC||minR>maxR) break;
            for(int i=maxR;i<=maxR;i++){
                for(int j=maxC;j>=minC;j--){
                    ans.add(arr[i][j]);
                }
            }
            maxR--;
            if(minC>maxC||minR>maxR) break;
            for(int j=minC;j<=minC;j++){
                for(int i=maxR;i>=minR;i--){
                    ans.add(arr[i][j]);
                }
            }
            minC++;
        }
        return ans;
    }
}