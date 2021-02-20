import amazon.asked.UtilizationCheck;

public class PracticeTest {
    public static void main(String[] args) {
//        int instances = 2;
//        int[] averageUtil = {25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80};
//         int[] averageUtil = {5,10,80};
//         int instances = 1;
//        int instances = 5;
//        int[] averageUtil = {30, 5, 4, 8, 19, 89};

//        int instances=1;
//        int averageUtil[] = {30,15,18,18,19,89,15,18,18,19,89,15,18,18,19,89,15,18,18,19,89,15,18,18,19,89};
//        int instances = 200000000;
//        int averageUtil[] = {100};
        int instances = 100000000;
        int averageUtil[] = {30,95,4,8,19,89};


        PracticeTest uc = new PracticeTest();
        System.out.println(uc.finalInstances(instances, averageUtil));
    }

    public int finalInstances( int instance, int[] avgUtil){
        if( avgUtil.length == 0 )
            return instance;
        int i = 0;
        boolean flag = false;
        while ( i < avgUtil.length ){
            if( avgUtil[i] < 25 ){
                if ( instance == 1 ){
                    i = i + 1;
                }else {
                    instance = (instance + 2  - 1)/2;
                    i = timerForTenSeconds(i, avgUtil.length);
                }
            }else if ( avgUtil[i] >= 25 && avgUtil[i] <= 60){
                i++;
               continue;
            }else{
                int temp = instance * 2;
                if( temp <= 2 * Math.pow(10,8)){
                    instance = instance * 2;
                    i = timerForTenSeconds(i, avgUtil.length);
                }else {
                    i++;
                }

            }
        }
        return instance;
    }

    public int timerForTenSeconds( int i , int length){
        int counter = 0;
        while( counter <= 10 && i < length )  {
            i++;
            counter++;
        }
        return i;
    }
}
