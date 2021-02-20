package top100.medium;

public class DailyTemperatures {
    public static void main(String[] args) {
        int T[] = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures temperatures = new DailyTemperatures();
        int res[] = temperatures.dailyTemperatures(T);
        for (int n: res
             ) {
            System.out.print(n+" ");
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int count = 0;
        int output[] = new int[T.length];
        int index = 0;
        for( int i = 0;i<T.length;i++){
            count++;
            for( int j = i+1;j<T.length;j++){
                if( T[j] > T[i] ){
                    output[index++] = count;
                    count = 0;
                    break;
                }else
                    count++;
            }
        }
        return output;
    }
}
