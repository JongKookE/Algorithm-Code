import java.util.*;

public class Main {
    static long mod = 1000000007;
    static Map<Long, Long> map = new HashMap<>();
    static long answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        map.put(0L, 0L);
        map.put(1L, 1L);
        map.put(2L, 1L);
        map.put(3L, 2L);
        answer = fibo(N);
        System.out.println(Long.valueOf(answer).intValue());
    }

    public static long fibo(long N) {
        if (map.containsKey(N)) return map.get(N);
        long a, b, c;
        if (N % 2 == 1) {
            a = fibo(N / 2 + 1);
            b = fibo(N / 2);
            map.put(N, ((a % mod) * (a % mod) % mod + (b % mod) * (b % mod) % mod) % mod);
        } else {
            a = fibo(N / 2 + 1);
            b = fibo(N / 2);
            c = fibo(N / 2 - 1);
            map.put(N, ((a % mod) * (b % mod) % mod + (b % mod) * (c % mod) % mod) % mod);
        }

        return map.get(N);
    }
}