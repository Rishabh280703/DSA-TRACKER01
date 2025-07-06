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
- Recursion
- Greedy
- Binary Search

---

## 📃 Problem Table (Sample)
| # | Title | Topic | Difficulty | Solution |
|--|-------|--------|------------|----------|
| 1 | Two Sum | Arrays | Easy | [Java](./Arrays/1-TwoSum.java) |
| 33 | Search in Rotated Sorted Array | Arrays | Medium | [Java](./Arrays/33-SearchInRotatedSortedArray.java) |

---

Arrays/README.md
------------------
# Arrays Problems

| # | Title | Difficulty | Solution |
|--|-------|------------|----------|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | [1-TwoSum.java](./1-TwoSum.java) |
| 33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium | [33-SearchInRotatedSortedArray.java](./33-SearchInRotatedSortedArray.java) |

---

Arrays/1-TwoSum.java
---------------------
// Problem: 1. Two Sum
// Link: https://leetcode.com/problems/two-sum/
// Difficulty: Easy

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (!map.containsKey(remaining)) {
                map.put(nums[i], i);
            } else {
                arr[0] = map.get(remaining);
                arr[1] = i;
            }
        }
        return arr;
    }
}

---

Arrays/33-SearchInRotatedSortedArray.java
------------------------------------------
// Problem: 33. Search in Rotated Sorted Array
// Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Difficulty: Medium

class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < arr[hi]) {
                if (target > arr[mid] && target <= arr[hi]) {
                    lo = mid + 1;
                } else hi = mid - 1;
            } else {
                if (target < arr[mid] && target >= arr[lo]) {
                    hi = mid - 1;
                } else lo = mid + 1;
            }
        }
        return -1;
    }
}
