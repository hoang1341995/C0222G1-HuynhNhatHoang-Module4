import java.util.Arrays;

public class test {
    static boolean isBeautiful(int a[]) {
        for (int i: a)
        {

        }

        int sum = a[0];
        int sum2 = 0;
        int n = a.length;
        for (int i = 1; i < n; i++) {

            for (int j = i+1 ; j < n ; j++) {
                sum2 += a[j];
                System.out.println(sum2);
                System.out.println(sum);
                if (sum  == sum2){
                    return true;
                }
            }
            sum2 = 0;
            sum += a[i];
        }
       return false;
    }

    public static void main (String[] args) {

        int a[] = {1, 2, 3, 3};

        if (isBeautiful(a))
            System.out.println ( "Yes");
        else
            System.out.println("No");

    }
}
