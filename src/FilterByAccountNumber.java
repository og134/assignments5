
public class FilterByAccountNumber implements Filter<BankAccount> {

    int minAccountNum;
    int maxAccountNum;
    public FilterByAccountNumber(int minAccountNum, int maxAccountNum) {
        this.minAccountNum = minAccountNum;
        this.maxAccountNum = maxAccountNum;
    }

    public boolean accept(BankAccount element) {

        if(element == null)
            return false;
        return (this.maxAccountNum >= element.getAccountNumber()) & (this.minAccountNum <= element.getAccountNumber());
    }
}
