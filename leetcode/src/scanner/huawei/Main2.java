package scanner.huawei;

import java.util.ArrayList;

/**
 * 第二题 自动驾驶计速
 * 题目
 * 建立云端数据库，汽车将自身的运行信息上报到云端，汽车自身每隔0.5s生成一次速度数据。
 *
 * 数据上报方式：
 *
 * 周期上报：每30s上报一次，启动后的第一个速度开始计算，第一帧需要上报。
 * AEB（自动紧急制动）上报：当汽车速度比上一次生成的速度减少了9及以上时，认为触发AEB流程，如果连续2s均保持AEB状态，触发AEB上报，
 * 上报内容有：（1）本次AEB过程中的所有速度数据，触发AEB前2s的数据和AEB结束后2s的数据。
 * （2）该范围内的数据中如果包含了已经周期上报的数据，重复上报。（3）如果两次AEB上报的数据有重叠，重叠数据上报一次。
 *
 * 在满足AEB上报条件时会立刻暂停周期上报，即此时即使进入周期上报的周期也不再上报了。
 * 在AEB上报结束后重新启动周期上报，新的周期从AEB上报的最后一个数据开始计算。
 * 请根据输入的速度信息，输出上报到云端的内容。
 *
 */
public class Main2 {
    private static ArrayList<Integer> uploadSpeeds(int[] speed){
        ArrayList<Integer> res = new ArrayList<>();
        int length = speed.length;
        int lastAEB = -1;
        int timer = 1;
        int curAEB = 0;
        boolean AEB = false;
        res.add(speed[0]);
        for (int i = 1; i < length; i++) {
            // 在AEB状态下, 单独处理
            if (AEB == true){
                // 判断AEB结束
                if (speed[i - 1] - speed[i] < 9){
                    for (int j = 0; j < 4; j++) {
                        if (i + j < length){
                            res.add(speed[i + j]);
                            // 值得注意的是, 在AEB结束后的2s内还需要判断下一次AEB
                            if (speed[i + j - 1] - speed[i + j] >= 9){
                                curAEB++;
                            } else {
                                curAEB = 0;
                            }
                        }
                    }
                    // 在AEB结束后启动新的周期, 同时AEB过程中暂停周期上报
                    timer = 0;
                    lastAEB = i + 3;
                    i += 3;
                    AEB = false;
                } else {
                    res.add(speed[i]);
                }
            } else if (speed[i - 1] - speed[i] >= 9){
                //判断AEB开始
                curAEB++;
                if (curAEB >= 4){
                    curAEB = 0;
                    AEB = true;
                    timer = 0;
                    // 找到前4个点, 看看是否比lastAEB大, 既能去重也能防止溢出
                    for (int j = i - 7; j <= i; j++) {
                        if (j > lastAEB){
                            res.add(speed[j]);
                        }
                    }
                }
            } else {
                curAEB = 0;
            }

            // 正常的周期上报, AEB状态下暂停周期
            if (timer == 60 && !AEB){
                timer = 0;
                res.add(speed[i]);
            }
            timer++;
        }
        return res;
    }
}
