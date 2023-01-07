import java.util.Iterator;
import java.util.LinkedList;


public class BankAccountFiltering {
    public static List<BankAccount> getAllValidAccounts(Iterable<BankAccount> accounts,int requiredBalance,int minAccountNumber,int maxAccountNumber) {
        List<BankAccount> nodes = new DynamicArray<>();
        Iterator<BankAccount> iter = accounts.iterator();
        FilterByAccountNumber filterAccNum = new FilterByAccountNumber(minAccountNumber,maxAccountNumber);
        FilterByBalance filerAccBalance = new FilterByBalance(requiredBalance);
        while(iter.hasNext()){
            BankAccount temp = iter.next();
            if((filterAccNum.accept(temp)) & (filerAccBalance.accept(temp)))
                nodes.add(temp);
        }
        return nodes;
    }
}
