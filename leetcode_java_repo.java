README.md (Main)
-----------------
# LeetCode Solutions – Rishabh280703 ✨

This repository contains clean and structured solutions to LeetCode problems written in **Java**.

## 🌟 Profile Stats:
- **LeetCode Username**: [rishabh2807](https://leetcode.com/rishabh2807)
- **Total Problems Solved**: 148
  - Easy: 47
  - Medium: 93
  - Hard: 8

---

## 📚 Topics Covered:
- Arrays
- Strings
- Dynamic Programming (DP)
- Recursion
- Greedy
- Binary Search

---

## 📃 Problem Table (Sample)
| # | Title | Topic | Difficulty | Solution |
|--|-------|--------|------------|----------|
| 1 | Two Sum | Arrays | Easy | [Java](./Arrays/1-TwoSum.java) |
| 72 | Edit Distance | DP | Hard | [Java](./DP/72-EditDistance.java) |

---

Arrays/README.md
------------------
# Arrays Problems

| # | Title | Difficulty | Solution |
|--|-------|------------|----------|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | [1-TwoSum.java](./1-TwoSum.java) |

---

DP/README.md
-------------
# Dynamic Programming Problems

| # | Title | Difficulty | Solution |
|--|-------|------------|----------|
| 72 | [Edit Distance](https://leetcode.com/problems/edit-distance/) | Hard | [72-EditDistance.java](./72-EditDistance.java) |

---

Arrays/1-TwoSum.java
---------------------
// Problem: 1. Two Sum
// Link: https://leetcode.com/problems/two-sum/
// Difficulty: Easy

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

---

DP/72-EditDistance.java
------------------------
// Problem: 72. Edit Distance
// Link: https://leetcode.com/problems/edit-distance/
// Difficulty: Hard

class Solution {
    public int mindist(int i, int j,StringBuilder a, StringBuilder b,int[][]dp){
        if(i==-1)return j+1;
        if(j==-1) return i+1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]= mindist(i-1,j-1,a,b,dp);
        }
        else{
            int del=  mindist(i-1,j,a,b,dp);
            int insert= mindist(i,j-1,a,b,dp);
            int replace= mindist(i-1,j-1,a,b,dp);
            return dp[i][j]= 1+Math.min(del,Math.min(insert,replace));
        }
    }

    public int minDistance(String word1, String word2) {
        StringBuilder a=new StringBuilder(word1);
        StringBuilder b=new StringBuilder(word2);
        int m=a.length(); int n=b.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return mindist(m-1,n-1,a,b,dp);
    }
}
