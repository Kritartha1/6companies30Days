/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
//leetcode.com/problems/find-in-mountain-array/

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        //logic is simple:
        //after the pivot point we will get a sorted decreasing array..
        //before the pivot we will get a sorted increasing array..
        //so first find the pivot..
        //then since smallest target index is required..
        //so first do binary search in the left half of thr pivot..
        //then binary search in the right half of the pivot..
        
        int n=mountainArr.length();
        int l=0;
        int r=n-1;
        int idx=0;
        
        while(l<=r){
            
            int mid=l+(r-l)/2;
            int a=mid>0?mountainArr.get(mid-1):Integer.MIN_VALUE;
            int m=mountainArr.get(mid);
            int b=mid<n-1?mountainArr.get(mid+1):Integer.MAX_VALUE;
            
            if(m>a&&m>b){
                idx=mid;
                break;
            }else if(m<b){
                l=mid+1;
            }else if(m<a){
                r=mid-1;
                
            }
        }
        
        
        l=0;
        r=idx;
        
        while(l<=r){
            int mid=l+(r-l)/2;
           
            int m=mountainArr.get(mid);
            
            if(m==target){
                return mid;
            }else if(m>target){
                r=mid-1;
            }else if(m<target){
                l=mid+1;
            }
        }
        
        l=idx+1;
        r=n-1;
        
        while(l<=r){
            int mid=l+(r-l)/2;
           
            int m=mountainArr.get(mid);
            
            if(m==target){
                return mid;
            }else if(m>target){
                l=mid+1;
            }else if(m<target){
                r=mid-1;
            }
        }
        
        return -1;
        
        
        
    }
}
