class Solution {
    public int search(int[] arr, int key) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int pivot = -1;
        while(low<high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]>=arr[high])
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
            
        }
        pivot = low;
        low = 0;
        high = pivot-1;
        while(low<=high)
        
        {
            int mid = low+(high-low)/2;
            if(arr[mid]==key)
            {
                return mid;
            }
            else if(arr[mid]>key)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        low = pivot;
        high = n-1;
        while(low<=high)
        
        {
            int mid = low+(high-low)/2;
            if(arr[mid]==key)
            {
                return mid;
            }
            else if(arr[mid]>key)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
        
        
    }
}
