package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class sort {

    //堆排序
    public static void Heapsort(int [] arr){
        //步骤1：经过arr.length/2伦循环后，构建该数组的大顶堆
        for (int i = arr.length; i >1; i--) {
            for (int j = (i / 2 - 1); j >=0 ; j--) {
                adjustHeap(arr,j,i);
            }
            int temp=arr[i-1];
            arr[i-1]=arr[0];
            arr[0]=temp;
        }
        System.out.println(Arrays.toString(arr));;
    }

    /**
     * 功能：建造当前节点i的一个大顶堆
     * @param arr：传入的数组
     * @param i：该数组对应树的一个非叶子节点索引
     * @param length：数组的长度
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i];
        for (int k = i*2+1; k <length; k=k*2+1) {
            if (k+1<length&&arr[k]<arr[k+1]){//若该节点的左节点小于右节点，则使k指向右节点
                k++;
            }
            if (arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
    //冒泡排序
    public static int[] maopaoSort(int[] arr){
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    int x=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=x;
                }
            }
        }
        return arr;
    }
    //选择排序
    private static int[] selectSort(int[] arr01) {
        for (int i = 0; i < arr01.length-1; i++) {
            int min=i;
            for (int j = i+1; j < arr01.length; j++) {
                if (arr01[j]<arr01[min]){
                    min=j;
                }
            }
            if (min!=i){
                int x=arr01[i];
                arr01[i]=arr01[min];
                arr01[min]=x;
            }
        }
        return arr01;
    }
    //快速插入排序
    public static int[] insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
                int indexVau=arr[i];
                int index=i-1;
                while(index>=0&&arr[i]<arr[index]){
                    arr[index+1]=arr[index];
                    index--;
                }
                arr[index+1]=indexVau;
        }
        return arr;
    }
    //希尔排序
    public int [] shellSort(int [] arr){
        for (int i=arr.length/2;i>0;i /=2){
            for (int j = i; j <arr.length; j++) {
                for (int k = j-i; k >=0 ; k-=i) {

                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        /*int[] arr01 = {64, 548, 5413, 4, 6, 484, 5, 1, 515};
        int[] arr=maopaoSort(arr01);*/
        /*for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        //int[] ints = selectSort(arr01);
        /*for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }*/
        /*int[] ints2 = insertSort(arr01);
        long l = System.currentTimeMillis();
        System.out.println(Arrays.toString(ints));;
        System.out.println(System.currentTimeMillis()-l);*/
        Heapsort(new int[]{20,15,17,16,18,19,21,22,65,98,-1,3,38,-69,-31});
    }


}
