public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double payment = loan / n; 
        iterationCounter = 0;
    

        while (true) {
            iterationCounter++; 
            double balance = endBalance(loan, rate, n, payment);
            
            if (Math.abs(balance) <= epsilon) {
                return payment;
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) { 
        double payment = loan / n; 
        int iterationCounter = 0; 
    
        while (Math.abs(payment) > epsilon) { 
            double balance = endBalance(loan, rate, n, payment); 
            if (balance <= epsilon) {
                return payment; 
            }
            payment += epsilon; 
            iterationCounter++; 
        }
        
        return payment; 
    }



    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double payment = 0;
        double a = 0;
        double b = loan;
        iterationCounter = 0;
        for (; b - a >= epsilon; iterationCounter++) {
            payment = (a + b) / 2;
            double target = endBalance(loan, rate, n, payment);
            if (target > 0) {
                a = payment;
            } else {
                b = payment;
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        int iterationCounter = 0; 
        double payment = 0; 
        double a = 0; 
        double b = loan; 
    
        while (b - a >= epsilon) { 
            payment = (a + b) / 2; 
            double target = endBalance(loan, rate, n, payment); 
    
            if (target > 0) { 
                a = payment; 
            } else { 
                b = payment; 
            }
    
            iterationCounter++; 
        }
        return payment;
    
        return payment; 
    }
    

}
