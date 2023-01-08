/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
public class Bank {

    private BankAccountsBinarySearchTree namesTree;
    private BankAccountsBinarySearchTree accountNumbersTree;

    public Bank() {
        this.namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
        this.accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
    }

    public BankAccount lookUp(String name) {
        // create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
        // This "dummy" accountNumber will be ignored when executing getData
        BankAccount lookFor = new BankAccount(name, 1, 0);
        return this.namesTree.findData(lookFor);
    }

    public BankAccount lookUp(int accountNumber) {
        // create an Entry with a "dummy" name, zero balance and the given accountNumber
        // This "dummy" name will be ignored when executing getData
        BankAccount lookFor = new BankAccount("dummy", accountNumber, 0);
        return this.accountNumbersTree.findData(lookFor);
    }

    // END OF Given code -----------------------------------

    //Complete the following method
    private void modifyNodes(BankAccount newAccount, String opt) {
        //maybe later
        // the action that we will do  add remove new node
    }

    public boolean add(BankAccount newAccount) {
        if (lookUp(newAccount.getAccountNumber()) == null & (lookUp(newAccount.getName())) == null) {
            if (this.namesTree.root == null) {
                this.namesTree.root = new BinarySearchNode<>(newAccount, this.namesTree.comparator);
                this.accountNumbersTree.root = new BinarySearchNode<>(new BankAccount(newAccount.getName(), newAccount.getAccountNumber(), newAccount.getBalance()), this.accountNumbersTree.comparator);
            } else {
                this.namesTree.root.insert(newAccount);
                this.accountNumbersTree.root.insert(newAccount);
            }
            return true;
        }
        return false;

    }

    //Complete the following method
    public boolean delete(String name) {
        // this first line is given in the assignment file
        BankAccount toRemove = lookUp(name);
        if (toRemove == null)
            return false;
        //data is in the tree so we can remove it
        this.accountNumbersTree.remove(toRemove);
        this.namesTree.remove(toRemove);
        return true;
    }

    //Complete the following method
    public boolean delete(int accountNumber) {
        // this first line is given in the assignment file
        BankAccount toRemove = lookUp(accountNumber);
        if (toRemove == null)
            return false;
        //data is in the tree so we can remove it
        this.accountNumbersTree.remove(toRemove);
        this.namesTree.remove(toRemove);
        return true;
    }

    //Complete the following method
    public boolean depositMoney(int amount, int accountNumber) {
        BankAccount depositAccount = lookUp(accountNumber);
        if (depositAccount == null)
            return false;
        //data is in the tree, we can make a deposit
        if (!depositAccount.depositMoney(amount))
            return false;
        BankAccount deposit = lookUp(depositAccount.getName());
        if (deposit == null)
            //meaning he exits in one tree only
            throw new RuntimeException("tha fuck?");

        if (!deposit.depositMoney(amount))
            throw new RuntimeException("somthing is dagi (like fishi)");
        return true;
    }

    //Complete the following method
    public boolean withdrawMoney(int amount, int accountNumber) {
        BankAccount withdraw = lookUp(accountNumber);
        if (withdraw == null)
            return false;
        //data is in the tree, we can make a deposit
        if (!withdraw.withdrawMoney(amount))
            return false;
        withdraw = lookUp(withdraw.getName());
        if (withdraw == null)
            //meaning he exits in one tree only
            throw new RuntimeException("tha fuck?");

        if (!withdraw.withdrawMoney(amount))
            throw new RuntimeException("meaning the same account dosent have the same amount of money");
        return true;
    }

    //Complete the following method
    public boolean transferMoney(int amount, int accountNumber1, int accountNumber2) {
        BankAccount acc1 = lookUp(accountNumber1);
        BankAccount acc2 = lookUp(accountNumber2);
        if (acc1 == null | acc2 == null)
            return false;
        if (acc1.withdrawMoney(amount))
            if (acc2.depositMoney(amount))
                //the only reason it will fail is if amount < 0, and we checked this at the withdraw before
                //we don't need to give 1 his money back
                return true;
        return false;
    }

    //Complete the following method
    public boolean transferMoney(int amount, int accountNumber, String name) {
        BankAccount acc1 = lookUp(accountNumber);
        BankAccount acc2 = lookUp(name);
        if (acc1 == null | acc2 == null)
            return false;
        if (acc1.withdrawMoney(amount))
            if (acc2.depositMoney(amount))
                //the only reason it will fail is if amount < 0, and we checked this at the withdraw before
                //we don't need to give 1 his money back
                return true;
        return false;
    }
}
