
import java.util.Iterator;

public class AlmostPrimeIterator implements Iterator<Integer> {
    private int num;
    private LinkedList<Integer> primeNums;
    private int nextAlmostPrime;
    private int index;

    public AlmostPrimeIterator(int start) {
        //will save the number that multiplay and search for a number to multiply with
        this.primeNums = new LinkedList<>();
        this.primeNums.add(2);
        this.findPrimes(start);
        this.num = start + 1;

    }

    //Complete the following method
    public boolean hasNext() {
        return true;
    }

    //Complete the following method
    public Integer next() {
        boolean found = false;
        int ret = 0;
        while (!found) {
            Iterator<Integer> primeNumsIter = this.primeNums.iterator();
            boolean check = true;
            while (primeNumsIter.hasNext() & check) {
                int primeToCheck = primeNumsIter.next();
                if (primeToCheck * this.primeNums.get(0) > this.num)
                    check = false;
                else if (this.num % primeToCheck == 0) {
                    int result = this.num / primeToCheck;
                    if (isPrime(result) & result != primeToCheck) {
                        // we found a number that C = A*B are both primes
                        if (!this.primeNums.contains(result))
                            this.primeNums.add(result);
                        ret = this.num;
                        found = true;
                        check = false;
                    }
                }
            }
            this.num++;
        }
        return ret;
    }

    private void findPrimes(int start) {
        for (int n = 2; n*n <= start; n++) {
            boolean isPrime = true;
            for (int p = 2; p * p <= n & isPrime; p++) {
                if (n % p == 0) {
                    isPrime = false;
                }
            }
            if (isPrime)
                this.primeNums.add(n);
        }
    }

    private boolean isPrime(int check) {
        for (int p = 2; p * p <= check ; p++) {
            if (check % p == 0) {
                return false;
            }
        }
        return true;
    }
}
