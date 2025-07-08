class Solution {
    public void rotate(int[][] arr) {
        int m= arr.length;
        int n= arr[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<=i;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        for(int i=0;i<m;i++){
            int x=0,y=n-1;
            while(x<=y){
                int temp=arr[i][x];
                arr[i][x]=arr[i][y];
                arr[i][y]=temp;
                x++; y--;
            }
        }
    }
}