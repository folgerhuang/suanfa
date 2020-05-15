package Other;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;


/**
 * @author zzm
 * @data 2020/4/15 21:48
 * 由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。
 * 他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。
 * 给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。
 * <p>
 * 输入描述:
 * 第一行一个整数 n(1≤n≤100000) 表示放假天数
 * 第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
 * 第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
 * （1为营业 0为不营业）
 * 输出描述:
 * 一个整数，表示小Q休息的最少天数
 * 思路
 * 典型的动态规划题目, 稍微注意一些条件
 *
 * dp[0][i]dp[0][i]dp[0][i], dp[1][i]dp[1][i]dp[1][i], dp[2][i]dp[2][i]dp[2][i]分别代表第i天休息最少休息天数、第i天工作最少休息天数、第i天健身最少休息天数
 *
 * 可以得到以下递推公式
 *
 * $dp[0][i] = min(dp[0][i-1], dp[1][i-1], dp[2][i-1]) + 1 $
 *
 * 注意只有第i−1i-1i−1 可以健身或者锻炼才把dp[1][i−1]dp[1][i-1]dp[1][i−1], dp[2][i−1]dp[2][i-1]dp[2][i−1]考虑进去,下同
 *
 * $dp[1][i] = min(dp[0][i-1],dp[2][i-1]) $ 只有第i天可以工作，才有此式子
 *
 * $dp[2][i] = min(dp[0][i-1], dp[1][i-1]) $ 只有第i天可以健身，才有此式子
 *
 * 有了递推公式，码代码只是时间的问题
 * ————————————————
 * 版权声明：本文为CSDN博主「zycxnanwang」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/zycxnanwang/java/article/details/101878823
 */
public class MinRest {
        public static void main(String args[]) throws Exception{
            //File file = new File("in.txt");
            //Scanner sc = new Scanner(file);
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            int []keep = new int[number+1];
            int []work = new int[number+1];
            for(int i = 1; i <= number; i++) work[i] = sc.nextInt();
            for(int i = 1; i <= number; i++) keep[i] = sc.nextInt();

            int [][] dp = new int[3][number+1];

            //第一天休息
            dp[0][1] = 1;

            //第一天工作
            if(work[1] == 1) dp[1][1] = 0;
            else dp[1][1] = number + 1;

            //第一天健身
            if(keep[1] == 1) dp[2][1] = 0;
            else dp[2][1] = number + 1;

            for(int i = 2; i <= number; i++) {
                dp[0][i] = Math.min(Math.min(dp[1][i-1], dp[2][i-1]), dp[0][i-1]) + 1;
                if (work[i] == 1) {
                    dp[1][i] = Math.min(dp[2][i-1], dp[0][i-1]);
                }else dp[1][i] = number + 1;

                if(keep[i] == 1) {
                    dp[2][i] = Math.min(dp[1][i-1], dp[0][i-1]);
                }else dp[2][i] = number + 1;
            }

            System.out.println(Math.min(Math.min(dp[0][number], dp[1][number]), dp[2][number]));
            sc.close();
        }

    }
