package demo01_dynamic_programming.Demo04_求最长不降子序列LIS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    需求:
        1．问题描述
            设有一个正整数的序列：𝒃𝟏,𝒃𝟐,…，𝒃𝒏，对于下标𝒊𝟏<𝒊𝟐<…＜𝒊𝒎，若有𝒃𝒊𝟏≤𝒃𝒊𝟐≤…≤𝒃𝒊𝒎 ，则称存在一个长度为m的不下降序列。
            例如，下列数列
            13  7  9  16  38  24  37  18  44  19  21  22  63  15
            对于下标𝒊𝟏=𝟏，𝒊𝟐=𝟒，𝒊𝟑=𝟓，𝒊𝟒=𝟗，𝒊𝟓=𝟏𝟑，满足13＜16＜38＜44＜63，则存在长度为5的不下降序列。
            但是，我们看到还存在其他的不下降序列: 𝒊𝟏=𝟐，𝒊𝟐=𝟑，𝒊𝟑=𝟒，𝒊𝟒=𝟖，𝒊𝟓＝𝟏𝟎，𝒊𝟔=𝟏𝟏，𝒊𝟕=𝟏𝟐，𝒊𝟖=𝟏𝟑，
            满足：7＜9＜16＜18＜19＜21＜22＜63，则存在长度为8的不下降序列。
            问题为：当𝒃𝟏,𝒃𝟐,…，𝒃𝒏给出之后，求出最长的不下降序列。

 */
public class Demo04_求最长不降子序列LIS {

    public static void main(String[] args) throws IOException {
        LIS();
    }

    private static void LIS() throws IOException {
        // 读取文件
        int[] L = new int[100];
        FileInputStream fis1 = new FileInputStream("hust-oj\\src\\demo01_dynamic_programming\\Demo04_求最长不降子序列LIS\\L.txt");
        int len = 0; //记录每次读取的有效字符个数
        int n = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis1.read(bytes)) != -1) {
            String[] split = new String(bytes, 0, len).split("\r\n");
            n = split.length;
            for (int i = 1; i <= n; i++) {
                L[i] = Integer.parseInt(split[i -1]);
            }
        }

        // 求最长不降子序列,A[i]记录LIS,i表示LIS的长度,A[i]表示LIS的末尾元素
        int[] A = new int[n + 1];
        A[1] = L[1];
        int j = 1, k;
        for (int i = 2; i <= n; i++) {
            k = j - 1;
            if (L[i] >= A[j]){
                A[++j] = L[i];
            }
            // 这一步可以用二分查找优化,使得算法时间复杂度为O(nlogn)
            else {
                /*int mid, l = 1;
                while (l <= k){
                    mid = (l + k + 1) / 2;
                    if(A[mid - 1] < L[i] && A[mid] > L[i])
                        A[mid] = L[i];
                    else if(A[mid - 1] > L[i])
                        k = mid + 1;
                    else
                        l = mid - 1;
                }*/
                while (A[k] > L[i])
                    k--;
                A[k + 1] = L[i];
            }
        }

        for (int i = 1; i <= j; i++) {
            System.out.println(A[i]);
        }
    }
}
