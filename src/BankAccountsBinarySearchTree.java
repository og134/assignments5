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
			List<BankAccount> nodes= new LinkedList<BankAccount>();
			BinaryTreeInOrderIterator<BankAccount> treeIter = new BinaryTreeInOrderIterator<BankAccount>(this.root);
			while(treeIter.hasNext()) {
				nodes.add(treeIter.next());
			}
			BankAccountsBinarySearchTree temp = new BankAccountsBinarySearchTree(this.comparator);
			temp.buildBalancedTree(nodes,0,nodes.size()-1);
			this.root = temp.root;
	    }
	    
	    private void buildBalancedTree(List<BankAccount> list, int low, int high) {
			if(low > high)
				return;
			if(low==high){
				this.root.insert(list.get(low));
				return;
			}
			int index = (low+high)/2;
			BankAccount temp = list.get(index);
			this.root.insert(temp);
			//left side
			buildBalancedTree(list,low,index);
			//right side
			buildBalancedTree(list,index,high);
	    }
}
