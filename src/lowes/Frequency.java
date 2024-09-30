package lowes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frequency {

    public static void main(String[] args) {
        Frequency freq = new Frequency();
        List<Integer> list = Arrays.asList(4, 7, 9, 4, 1, 7, 8);
        freq.frequency(list);
    }

    public void frequency(List<Integer> list) {
        Map<Integer, Integer> fMap = new HashMap<>();
        list.forEach(l -> {
            if (fMap.containsKey(l)) {
                Integer val = fMap.get(l);
                fMap.put(l, val + 1);
            } else {
                fMap.put(l, 1);
            }
        });
        System.out.println(fMap);









/*        Executor executor = new Fixed{

        };
        executor.submit(()->{
            System.out.println("My name is unni");
        });*/

// nums = [2,7,11,15], target = 9

       /* 7,0
                2,1
                        -2,2
                        -6,3*/


    }
}
