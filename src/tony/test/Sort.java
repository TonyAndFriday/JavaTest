package tony.test;

/**
 * Created by tony on 2018/5/8.
 * 几种排序实现
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        //insertSort(arr);
        quickSort(arr,0,arr.length-1);
        printArr(arr);
        //System.out.println(binarySearch(arr,6,0,arr.length-1));
        System.out.println(binarySearch_1(arr,3));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void maopaoSort(int[] arr){
        for (int i = 0 ; i < arr.length - 1; i++){
            for (int j = 0 ; j < arr.length - 1 -i ; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        for (int i = 0 ; i < arr.length - 1; i++){
            int index = i;
            for (int j = i + 1 ; j < arr.length ; j++){
                if(arr[j] < arr[i]){
                    index = j;
                }
            }
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        int j ;
        for(int i = 1 ; i < arr.length; i++){
            int tmp = arr[i];
            for(j = i - 1 ; j >= 0 && tmp < arr[j]; j--){
                    arr[j+1] = arr[j];
            }
            arr[j+1] = tmp;
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr,int low,int high){
        if(low < high){
            int mid = getMid(arr,low,high);
            quickSort(arr,low,mid - 1);
            quickSort(arr,mid+1,high);
        }


    }

    public static int getMid(int[] arr,int low,int high){
        int tmp = arr[low];
        while(low < high){
            while(low < high && tmp < arr[high])
                high --;
            arr[low] = arr[high];
            while(low < high && tmp > arr[low])
                low ++;
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }


    /**
     * 递归版二分查找
     * @param arr
     * @param target
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int[] arr,int target,int low ,int high){
        if(low < high){
            int mid = (low+high)/2;
            if(arr[mid] < target){
                return binarySearch(arr,target,mid+1,high);
            }else if (arr[mid] > target){
                return binarySearch(arr,target,low,mid-1);
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 非递归版
     * @param arr
     * @param target
     * @return
     */

    public static int binarySearch_1(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] < target)
                low = mid + 1;
            else if(arr[mid] > target)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void printArr(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }

    }

}
