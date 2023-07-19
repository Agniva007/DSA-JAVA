package Easy;

public class countGoodNumbers {
    public static void main(String[] args) {
        System.out.println(countGoodNumber(50));
    }

    public static int countGoodNumber(long n) {
        if(n%2==0){
            long even = pow(5, n/2);
            long odd = pow(4, n/2);
            return (int)((even*odd)%1000000007);
        }else{
            long mid = n/2;
            long even = pow(5, mid+1);
            long odd = pow(4, mid);

            return (int)((even*odd)%1000000007);
        }
    }

    public static long pow(long x, long n){
        if(n==0) return 1;
        if(n%2==1){
            return (x%1000000007 * (pow((x*x)%1000000007, (n-1)/2))%1000000007)%1000000007;
        }else{
            return (pow((x*x)%1000000007, n/2))%1000000007;
        }
    }
}
