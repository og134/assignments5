/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}

	    // Complete the following methods
	    public void balance(){
			List<BankAccount> nodes= new LinkedList<>();
			for (BankAccount bankAccount : this) {
				nodes.add(bankAccount);
			}
			BankAccountsBinarySearchTree temp = new BankAccountsBinarySearchTree(this.comparator);
			temp.buildBalancedTree(nodes,0,nodes.size()-1);
			this.root = temp.root;

	}



	    private void buildBalancedTree(List<BankAccount> list, int low, int high) {
			//impleaments binary search to build the tree
			if(low > high)
				return;
			int index = (low + high) / 2;
			if(this.root == null){
				this.root = new BinarySearchNode<>(list.get(index),this.comparator);
			}
			this.root.insert(list.get(index));
			//left side
			buildBalancedTree(list, low, index-1);
			//right side
			buildBalancedTree(list, index+1, high);
		}
}
