class Solution {
public:
    double myPow(double x, long long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        double m = myPow(x, n / 2);

        if (n % 2 == 0) {
            return m * m;
        } else {
            return x * m * m;
        }
    }
};