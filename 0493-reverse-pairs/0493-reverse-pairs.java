class Solution {
    static int count;
    public int reversePairs(int[] arr) {
        count =0;
        mergesort(arr);
        return count;

    }
    public static void inversion(int[] a , int[] b)
    {
        int i =0;
        int j =0;
        while(i<a.length && j<b.length)
        {
            if((long)a[i]>2L*b[j])
            {
                count+=(a.length-i);
                j++;
            }
            else{
            i++;
            }
        }       
    }
    public static void mergesort(int[] arr)
    {
        int n=arr.length;
        if(n<=1) return;
        int idx = 0;
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];
        for(int i =0; i<a.length; i++)
        {
            a[i] = arr[idx++];
        }
        for(int i =0; i<b.length; i++)
        {
            b[i] = arr[idx++];
        }
        mergesort(a);
        mergesort(b);
        inversion(a ,b);
        merge(a , b ,arr);
    }
    public static void merge(int[] a, int[] b, int[] c)
    {
        int i=0;
        int j =0; int k=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]<=b[j])
            {
                c[k++]=a[i++];
            }
            else
            {
                c[k++]= b[j++];
            }
        }
        while(i<a.length)
        {
            c[k++] = a[i++];
        }
         while(j<b.length)
        {
            c[k++] = b[j++];
        }
    }
}