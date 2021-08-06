package scanner.huawei;

import java.util.ArrayList;

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
