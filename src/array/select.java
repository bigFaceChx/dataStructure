package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分法查找数组元素
 */
public class select {
    public static void main(String[] args) {
        int[] arr = new int[]{1,6,6,95,98,100,165,268,369,456,598,698};
        //int index=BinarySelect(arr,165);
        /*System.out.println(index);*/
        List<Integer> integers = InterpolationSearch(arr, 0, arr.length - 1, 6);
        int i = fibonacciSearch(arr, 598);
        System.out.println(i);
    }

    /**
     * 斐波拉契查找算法
     * @param arr：传入的数组
     * @param value：需要查找的值
     * @return 返回该值在数组里的索引集合
     */
    public static int fibonacciSearch(int[] arr,int value){
        int left=0;
        int right=arr.length-1;
        //构建一个斐波拉契数组
        int[] fibonacci=new int[20];
        fibonacci[0]=1;
        fibonacci[1]=1;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i]=fibonacci[i-1]+fibonacci[i-2];
        }
        int i=0;
        while (arr.length>fibonacci[i]){
            i++;
        }
        //创建一个新数组
        int[] temp=null;
        if (arr.length!=fibonacci[i]){
            temp= Arrays.copyOf(arr,fibonacci[i]);
            for (int j = right+1; j < temp.length; j++) {
                temp[j]=temp[right];
            }
        }
        while (left<right){
            int mid=left+fibonacci[i-1]-1;
            if (value<temp[mid]){
                right=mid-1;
                i-=1;
            }else if (value>temp[mid]){
                left=mid+1;
                i-=2;
            }else{
                if (mid<=right){
                    return mid;
                }else{
                    return right;
                }
            }
        }
        return -1;

    }

    //插值查找
    /**
     *
     * @param arr：传入的数组
     * @param left ：数组的最小索引
     * @param right：数组的最大索引
     * @param value：需要查找的值
     * @return ：返回该值的下标集合
     */
    public static List<Integer> InterpolationSearch(int[] arr,int left,int right,int value){
            int mid=left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
            int valueMid=arr[mid];
            if (left>right){
                return new ArrayList<Integer>();
            }else{
                if (value>valueMid){//向右递归
                    return InterpolationSearch(arr,mid+1,right,value);
                }else if (value<valueMid){//向左递归
                    return InterpolationSearch(arr,left,mid-1,value);
                }else{
                    ArrayList<Integer> indexs = new ArrayList<>();
                    int index=mid-1;
                    while(index>=00&&arr[index]==value){
                        indexs.add(index);
                        index--;
                    }
                    indexs.add(mid);
                    int index01=mid+1;
                    while (index01<arr.length&&arr[index01]==value){
                        indexs.add(index01);
                        index01++;
                    }
                    return indexs;
                }
            }
    }

    /**
     * 二分查找算法（折半查找）
     * @param arr
     * @param i
     * @return
     */
    private static int BinarySelect(int[] arr, int i) {
        int length = arr.length;
        int start=0;
        int end=length-1;
        while(start<=end){
            int center=(start+end)/2;
            if (i>arr[center]){
                start=center+1;
            }else if (i<arr[center]){
                end=center-1;
            }else {
                return center;
            }
        }
        return -1;
    }
}
