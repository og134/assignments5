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
			Iterator<BankAccount> iter = this.iterator();
			while(iter.hasNext()) {
				nodes.add(iter.next());
			}
			BankAccountsBinarySearchTree temp = new BankAccountsBinarySearchTree(this.comparator);
			temp.buildBalancedTree(nodes,0,nodes.size()-1);
			this.root = temp.root;
	    }

	    private void buildBalancedTree(List<BankAccount> list, int low, int high) {
			if(low > high)
				return;
			else if(low==high){
				if(this.root ==null)
					this.root = new BinaryNode<>(list.get(low));
				else
					this.root.insert(list.get(low));
				return;
			}
			else {
				int index = (low + high) / 2;
				BankAccount temp = list.get(index);
				if (this.root == null)
					this.root = new BinaryNode<>(temp);
				else
					this.root.insert(temp);
				//left side

				buildBalancedTree(list, low, index-1);
				//right side
				buildBalancedTree(list, index+1, high);
			}
	    }

}
