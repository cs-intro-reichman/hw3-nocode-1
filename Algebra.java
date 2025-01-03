// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
    public static void main(String args[]) {
        // Tests some of the operations

        System.out.println(plus(2, 3)); // 2 + 3
        System.out.println(minus(7, 2)); // 7 - 2
        System.out.println(minus(2, 7)); // 2 - 7
        System.out.println(times(3, 4)); // 3 * 4
        System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
        System.out.println(pow(5, 3)); // 5^3
        System.out.println(pow(3, 5)); // 3^5
        System.out.println(div(12, 3)); // 12 / 3
        System.out.println(div(5, 5)); // 5 / 5
        System.out.println(div(25, 7)); // 25 / 7
        System.out.println(mod(25, 7)); // 25 % 7
        System.out.println(mod(120, 6)); // 120 % 6
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }

    // Returns x1 + x2
    public static int plus(int x1, int x2) {
        int sum = x1;
    
        if (x2 < 0) {
            for (int i = 0; i < -x2; i++) {
                sum--;
            }
        } else { 
            for (int i = 0; i < x2; i++) {
                sum++;
            }
        }
    
        return sum;
    }

    public static int minus(int x1, int x2) {
        int sum = x1;
    
        if (x2 < 0) {
            for (int i = 0; i < -x2; i++) {
                sum++;
            }
        } else {
            for (int i = 0; i < x2; i++) {
                sum--;
            }
        }
    
        return sum;
    }

        
    public static int times(int x1, int x2) {
        int product = 0;
    
        if (x2 < 0) {
            for (int i = 0; i < -x2; i++) {
                product -= x1;
            }
        } else {
            for (int i = 0; i < x2; i++) {
                product += x1;
            }
        }
    
        return product;
    }


    // Returns x^n (for n >= 0)
    // 5^3
    public static int pow(int x, int n) {
        int product = 1;
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                product *= x;
            }
        } else {
            return 0;
        }
        return product;
    }

    public static int div(int x1, int x2) {
        boolean isNegative = (x1 < 0) ^ (x2 < 0); 
    
        x1 = Math.abs(x1);
        x2 = Math.abs(x2);
    
        int quotient = 0;
    
        while (x1 >= x2) {
            x1 -= x2;
            quotient++;
        }
    
        return isNegative ? -quotient : quotient;
    }
    // Returns x1 %  x2
    public static int mod(int x1, int x2) {
        int remainder = x1;
    
        while (remainder >= x2) {
            remainder -= x2;
        }
    
        return remainder;
    }

    // Returns the integer part of sqrt(x)
    public static int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
    
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
