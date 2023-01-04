import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        BankAccountsBinarySearchTree temp = new BankAccountsBinarySearchTree(new AccountComparatorByName());
        temp.insert(new BankAccount("omer1",1,123));
        temp.insert(new BankAccount("omer2",2,123));
        temp.insert(new BankAccount("omer3",3,123));
        temp.insert(new BankAccount("omer4",4,123));
        temp.insert(new BankAccount("omer5",5,123));
        temp.balance();
    }
}