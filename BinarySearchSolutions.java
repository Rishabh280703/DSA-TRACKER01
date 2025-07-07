
// LeetCode 34: Find First and Last Position of Element in Sorted Array
class FindFirstAndLastPosition {
    public int[] searchRange(int[] arr, int t) {
        int[] ans = {-1, -1};
        int n = arr.length;
        int lb = n;
        int ub = n;
        int lo = 0, hi = n - 1;
        boolean flag = false;

        // Step 1: Check if target exists
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == t) {
                flag = true;
                break;
            } else if (arr[mid] > t) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (!flag) return ans;

        // Step 2: Lower bound (first occurrence)
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= t) {
                lb = Math.min(lb, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        // Step 3: Upper bound (just after last occurrence)
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > t) {
                ub = Math.min(ub, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        ans[0] = lb;
        ans[1] = ub != n + 1 ? ub - 1 : -1;

        return ans;
    }
}

// LeetCode 35: Search Insert Position
class SearchInsertPosition {
    public int searchInsert(int[] arr, int t) {
        int n = arr.length;
        int lo = 0, hi = n - 1;
        int x = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == t) return mid;
            else if (arr[mid] < t) {
                x = Math.max(x, mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return x + 1;
    }
}
