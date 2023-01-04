import java.math.BigInteger;
import java.util.Iterator;

public class AlmostPrimeIterator implements Iterator<Integer> {

	int num;
    LinkedList<Integer> primeNums;
    public AlmostPrimeIterator(int start){
        this.num = start;
        this.primeNums = new LinkedList<>();
        this.primeNums.add(2); //first prime number
    }
	//Complete the following method
    public boolean hasNext(){
        return true;
    }

	//Complete the following method
    public Integer next(){
        return 1;
    }
    /*
    public static boolean findPrime() {
        boolean ans = true;
        boolean isPrime = true;

        check = check.add(update); // update to 2
        mulVal = check.multiply(check);
        // <1 means mulVal is smaller then n
        while (ans & mulVal.compareTo(n) < 1) {
            if (mod_res.compareTo(n.mod(check)) == 0) {
                ans = false;
            }
            mulVal = check.multiply(check);
            check = check.add(update);

        }

        return ans;

    }
    */

}
