
public class FilterByBalance implements Filter<BankAccount>{

	int threshold;
	public FilterByBalance(int balanceThreshold) {
        this.threshold = balanceThreshold;
	}
	
	@Override
	public boolean accept(BankAccount elem) {
		if(elem == null)
			return false;
		return this.threshold <= elem.getBalance();
	}
}
