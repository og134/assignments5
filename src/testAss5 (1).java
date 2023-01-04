/**
 * created by Tomer Cohen
 */
import java.util.Iterator;
import java.util.Scanner;
import java.util.Comparator;

public class testAss5 {
		private static boolean legalInput(String s)
		{
			boolean checkAll,checkDisplay;
			checkAll = CS(s,"0") | CS(s,"1") | CS(s,"2") | CS(s,"4") |  CS(s,"5") | CS(s,"6") | CS(s,"7");
			checkDisplay = CS(s,"0.1") | CS(s,"1.1") | CS(s,"2.1") | CS(s,"4.1") |  CS(s,"5.1") | CS(s,"6.1") | CS(s,"7.1");
			return checkAll|checkDisplay;
		}
		public static void main(String[] args) {
			System.out.println("created by: Tomer Cohen");
			System.out.println("put a number from 0-7");
			System.out.println("if you want more information, put .1 after, like 0.1 or 6.1");
			Scanner scanner = new Scanner(System.in);
			 String input=scanner.next();
			 while(!CS(input,"-1")) {  
				 while(!legalInput(input)){
					 if(CS(input,"3") | CS(input,"3.1"))
						 System.out.println("nothing to check here :)");
					 else {
						 System.out.println("Cant check that, its not a real number for this Assignment");
						 System.out.println("Check out 'read me' file for more information");
					 }
					 System.out.println("anything else to check?");
					 input = scanner.next();
				 }
				 whatToCheck(input);
				 System.out.println("anything else to check?");
				 input = scanner.next();
			 }
		}
		private static void whatToCheck(String s) {
			boolean isDisplay = CS(s,"0.1") | CS(s,"1.1") | CS(s,"2.1") | CS(s,"4.1") |  CS(s,"5.1") | CS(s,"6.1") | CS(s,"7.1");
			if(isDisplay)
				s=s.substring(0,1);
			if(CS(s,"0")|CS(s,"7")){c0(isDisplay);}
			if(CS(s,"1")|CS(s,"7")){c1(isDisplay);}
			if(CS(s,"2")|CS(s,"7")){c2(isDisplay);}
			if(CS(s,"4")|CS(s,"7")){c4(isDisplay);}
			if(CS(s,"5")|CS(s,"7")){c5(isDisplay);}
			if(CS(s,"6")|CS(s,"7")){c6(isDisplay);}
		}
		
		private static void fail() {
			System.out.println();
			System.out.print("fail: ");
		}
		private static void good() {

			System.out.println("good");
		}
		private static void c0(boolean D)
		{
			System.out.print("checking 0: ");
			if(D)System.out.println();			
			boolean good=true;
			int[][] matrix = new int[5][];
			int [] starts = {2,106,1000,85232,2047483656};
			int[] array0 = {6,10,14,15,21,22,26,33,34,35,38};
			int[] array1 = {111,115,118,119,122,123,129,133,134,141};
			int[] array2 = {1003,1006,1007,1011,1018,1027,1037,1041,1042,1043};
			int[] array3 = {85233,85235,85249,85265,85271,85273,85277,85279,85282,85283};
			int[] array4 = {2047483657,2047483661,2047483677,2047483682,2047483693,2047483703,2047483714,2047483727,2047483729,2047483731};
			matrix[0]=array0;matrix[1]=array1;matrix[2]=array2;matrix[3]=array3;matrix[4]=array4;
			for(int i=0;i<matrix.length;i++)
			{
				if(D) System.out.println("starting check from " +starts[i]+" :");
				Iterator<Integer> iter = new AlmostPrimeIterator(starts[i]);
				for(int j=0;j<10;j++)
				{
					int val=iter.next().intValue();
					if(D) System.out.print("check " +val+" :");
					if(val!=matrix[i][j])
					{
						fail();
						System.out.println("the next number should be "+ matrix[i][j] +" but yours is: " + val );
						good=false;
					}//if
					if(D & good) System.out.println("good");
				}//for
			}//for
			if(D) System.out.println();
			if(good)
				good();
			System.out.println();
		}
		private static void c1(boolean D)
		{
			boolean good=true;
			System.out.println("checking 1: ");
			System.out.print("depositMoney : ");
			if(D)System.out.println();	
			BankAccount BA = new BankAccount("BA",1,0);
			BA.depositMoney(100);
			if(D) System.out.print("depositing 100 from 0: ");
			if(BA.getBalance()!=100)
			{
				fail();
				System.out.println("trying to deposit 100 from 0, should be now 100 but yours is: " + BA.getBalance());
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA = new BankAccount("BA",1,1000);
			BA.depositMoney(10000);
			if(D) System.out.print("depositing 10000 from 1000: ");
			if(BA.getBalance()!=11000)
			{
				fail();
				System.out.println("trying to deposit 10000 from 1000, should be now 11000 but yours is: " + BA.getBalance());
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA = new BankAccount("BA",1,1000);
			boolean check =BA.depositMoney(-500);
			if(D) System.out.print("depositing -500 from 1000: ");
			if(check)
			{
				fail();
				System.out.println("trying to deposit -500 from 1000, should be false but yours is: " + check);
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			if(good)
				good();
			
			good=true;
			System.out.print("withdrawMoney : ");
			if(D)System.out.println();	
			
			BA = new BankAccount("BA",1,333);
			BA.withdrawMoney(100);
			if(D) System.out.print("withdrawing 100 from 333: ");
			if(BA.getBalance()!=233)
			{
				fail();
				System.out.println("trying to withdrawing 100 from 333, should be now 233 but yours is: " + BA.getBalance());
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA = new BankAccount("BA",1,133);
			BA.withdrawMoney(100);
			if(D) System.out.print("withdrawing 100 from 133: ");
			if(BA.getBalance()!=33)
			{
				fail();
				System.out.println("trying to withdrawing 100 from 133, should be now 33 but yours is: " + BA.getBalance());
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA = new BankAccount("BA",1,33);
			check =BA.withdrawMoney(100);
			if(D) System.out.print("withdrawing 100 from 33:");
			if(check)
			{
				fail();
				System.out.println("trying to withdrawing 100 from 33, should be false but yours is: " + check);
				good=false;
			}//if		
			if(D & good) System.out.println("good");
			
			if(good)
				good();
			System.out.println();
		}
		private static void c2(boolean D) {
			System.out.print("checking 2: ");
			if(D)System.out.println();			
			boolean good=true;
			BankAccount BA1,BA2;
			
			BA1= new BankAccount("yoval",1,1);
			BA2= new BankAccount("tomer",1,1);
			Comparator<BankAccount> comp= new AccountComparatorByName();
			boolean check = comp.compare(BA1, BA2)>0;
			if(D) System.out.print("check acc name yoval vs acc name tomer :");
			if(!check) {
				fail();
				System.out.println("the name yoval should be longer than the name tomer and result should be higher than 0 but yours: " + comp.compare(BA1, BA2) );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA1= new BankAccount("roni",1,1);
			BA2= new BankAccount("tamir",1,1);
			 check = comp.compare(BA1, BA2)<0;
			if(D) System.out.print("check acc name roni vs acc name tamir :");
			if(!check) {
				fail();
				System.out.println("the name roni should be shorter than the name tamir and result should be lower than 0 but yours: " + comp.compare(BA1, BA2) );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA1= new BankAccount("tomer",1,1);
			BA2= new BankAccount("tomerhagever",1,1);
			check = comp.compare(BA1, BA2)<0;
			if(D) System.out.print("check acc name tomer vs acc name tomerhagever :");
			if(!check) {
				fail();
				System.out.println("the name tomer should be shorter than the name tomerhagever and result should be shorter than 0 but yours: " + comp.compare(BA1, BA2) );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA1= new BankAccount("tomer",1,1);
			BA2= new BankAccount("tomer",1,1);
			check = comp.compare(BA1, BA2)==0;
			if(D) System.out.print("check acc name tomer vs acc name tomer :");
			if(!check) {
				fail();
				System.out.println("the name tomer should be same as the name tomer and result should be 0 but yours: " + comp.compare(BA1, BA2) );
				good=false;
			}//if
			if(D & good) System.out.println("good");
					
			if(good)
				good();
			System.out.println();
		}
		private static void c4(boolean D) {
			boolean good=true;
			String s;
			boolean check;
			System.out.print("checking 4: ");
			if(D)System.out.println();			
			Comparator<Integer> comp = Comparator.naturalOrder();
			BinarySearchTree<Integer> BT = new BinarySearchTree<Integer>(comp);
			BT.insert(2);
			s=BT.toString();
			check=CS(s,"tree(2)");
			if(D) System.out.print("check tree(2) :");
			if(!check) {
				fail();
				System.out.println("should be tree(2) but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BT.insert(1);
			s=BT.toString();
			check=CS(s,"tree((1),2)");
			if(D) System.out.print("check tree((1),2) :");
			if(!check) {
				fail();
				System.out.println("should be tree((1),2) but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BT.insert(3);
			s=BT.toString();
			check=CS(s,"tree((1),2,(3))");
			if(D) System.out.print("check tree((1),2,(3)) :");
			if(!check) {
				fail();
				System.out.println("should be tree((1),2,(3)) but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BT.insert(60);
			BT.insert(5);
			BT.insert(8);
			BT.insert(7);
			BT.insert(20);
			BT.insert(15);
			s=BT.toString();
			check=CS(s,"tree((1),2,(3,((5,((7),8,((15),20))),60)))");
			if(D) System.out.print("check tree((1),2,(3,((5,((7),8,((15),20))),60))) :");
			if(!check) {
				fail();
				System.out.println("should be tree((1),2,(3,((5,((7),8,((15),20))),60))) but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BT = new BinarySearchTree<Integer>(comp);
			BT.insert(9);
			BT.insert(8);
			BT.insert(7);
			BT.insert(6);
			BT.insert(10);
			BT.insert(12);
			BT.insert(14);
			BT.insert(13);
			s=BT.toString();
			check=CS(s,"tree((((6),7),8),9,(10,(12,((13),14))))");
			if(D) System.out.print("check tree((((6),7),8),9,(10,(12,((13),14)))) :");
			if(!check) {
				fail();
				System.out.println("should be tree((((6),7),8),9,(10,(12,((13),14)))) but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");

			if(good)
				good();
			System.out.println();
		}
		private static void c5(boolean D) {
			boolean good=true;
			String s;
			boolean check;
			System.out.println("ty dolev");
			System.out.print("checking 5b: ");
			if(D)System.out.println();	
			Comparator<BankAccount> comp = new AccountComparatorByNumber();
			BankAccountsBinarySearchTree BT = new BankAccountsBinarySearchTree(comp);
			BankAccount BA= new BankAccount("tomer",1,1);
			BT.insert(BA);
			BT.balance();
			s="tree"+cleanString(BT.toString());
			check=CS(s,"tree(1)");
			if(D) System.out.print("check tree(1) :");
			if(!check) {
				fail();
				System.out.println("input tree(1) should be tree(1) but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA= new BankAccount("tomer",2,1);
			BT.insert(BA);
			BA= new BankAccount("tomer",3,1);
			BT.insert(BA);
			String CD = "tree"+cleanString(BT.toString());
			BT.balance();
			s="tree"+cleanString(BT.toString());
			check=CS(s,"tree((1),2,(3))");
			if(D) System.out.print("check "+CD+ " :");
			if(!check) {
				fail();
				System.out.println("the tree: tree(1,(2,(3))) should be tree((1),2,(3)) but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BT = new BankAccountsBinarySearchTree(comp);
			int[] insert0 = {4,2,1,3,6,7,8,5};
			int[] insert1 = {5,2,1,4,3,6,7,8};
			int[] insert2 = {2,1,3,4,5,6,7,8};
			int[] insert3 = {8,7,6,5,4,3,2,1};
			int[][] matrix = new int[4][];
			matrix[0]=insert0;matrix[1]=insert1;matrix[2]=insert2;matrix[3]=insert3;
			for(int j=0;j<matrix.length;j++) {
				BT = new BankAccountsBinarySearchTree(comp);
				for(int i=0;i<matrix[j].length;i++){
					BA= new BankAccount("tomer",matrix[j][i],1);
					BT.insert(BA);
					s="tree"+cleanString(BT.toString());
				}
				CD = "tree"+cleanString(BT.toString());
				BT.balance();   
			 	s="tree"+cleanString(BT.toString());
				check=CS(s,"tree(((1),2,(3)),4,((5),6,(7,(8))))");
				if(D) System.out.print("check "+CD+ " :");
				if(!check) {
					fail();
					System.out.println("the tree: "+ CD +" should be after balancing tree(((1),2,(3)),4,((5),6,(7,(8)))) but yours is: " + s );
					good=false;
				}//if
				if(D & good) System.out.println("good");
			
			
			}
			if(good)
				good();
			System.out.println();
			if(good) {
			System.out.print("checking 5c: ");
			if(D)System.out.println();	
			BA= new BankAccount("tomer",1,1);
			Filter<BankAccount> fil = new FilterByBalance(100);
			check = fil.accept(BA);
			if(D) System.out.print("check 1 and Threshhold 100 :");
			if(check) {
				fail();
				System.out.println("check 1 and Threshhold 100 should be false but yours is: " + check );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA= new BankAccount("tomer",1,100);
			check = fil.accept(BA);
			if(D) System.out.print("check 100 and Threshhold 100 :");
			if(!check) {
				fail();
				System.out.println("check 100 and Threshhold 100 should be true but yours is: " + check );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA= new BankAccount("tomer",1,1000);
			check = fil.accept(BA);
			if(D) System.out.print("check 1000 and Threshhold 100 :");
			if(!check) {
				fail();
				System.out.println("check 1000 and Threshhold 100 should be true but yours is: " + check );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			if(good)
				good();
			System.out.println();
			
			if(good) {
			System.out.print("checking 5d: ");
			if(D)System.out.println();	
			BA= new BankAccount("tomer",1,1);
			fil = new FilterByAccountNumber(100,200);
			check = fil.accept(BA);
			if(D) System.out.print("check 1 and Threshhold 100 to 200 :");
			if(check) {
				fail();
				System.out.println("check 1 and Threshhold 100 to 200 should be false but yours is: " + check );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA= new BankAccount("tomer",100,1);
			check = fil.accept(BA);
			if(D) System.out.print("check 100 and Threshhold 100 to 200 :");
			if(!check) {
				fail();
				System.out.println("check 100 and Threshhold 100 to 200 should be true but yours is: " + check );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA= new BankAccount("tomer",150,1);
			check = fil.accept(BA);
			if(D) System.out.print("check 150 and Threshhold 100 to 200 :");
			if(!check) {
				fail();
				System.out.println("check 150 and Threshhold 100 to 200 should be true but yours is: " + check );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA= new BankAccount("tomer",1000,1000);
			check = fil.accept(BA);
			if(D) System.out.print("check 1000 and Threshhold 100 to 200:");
			if(check) {
				fail();
				System.out.println("input 1000 and Threshhold 100 to 200 should be false but yours is: " + check );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			if(good)
				good();
			System.out.println();
			
			if(good) {
			System.out.print("checking 5e + 5f: ");
			if(D)System.out.println();	
			matrix = new int[5][];
			int[] i0 = {2,3,4};
			int[] i1 = {1,3,5};
			int[] i2 = {1,2,3,4,5,6,7,8};
			int[] i3 = {1,5,6,7,8,9,10};
			int[] i4 = {};
			String[] ans0 = {"2,3,4","3","2,3,4","",""};
			matrix[0] = i0;matrix[1] = i1;matrix[2]=i2;matrix[3]=i3;matrix[4]=i4;
			for(int j=0;j<matrix.length;j++)
			{
				BT = new BankAccountsBinarySearchTree(comp);
				for(int i=0;i<matrix[j].length;i++){
					BA= new BankAccount("tomer",matrix[j][i],100000);
					BT.insert(BA);
				}
				if(D) System.out.println("creating new list for the filtered accounts");
				List<BankAccount> l = BankAccountFiltering.getAllValidAccounts(BT, 10000, 2, 4);
				CD = cleanString(BT.toString());
				if(D) System.out.print("check "+ CD + " and Threshhold for account number is 2 to 4 (balance is fine):");
				check = CS(cleanString(l.toString()),ans0[j]);
				if(!check) {
					fail();
					System.out.println("input "+CD+" should be "+ans0[j]+" but yours is: " +cleanString(l.toString()));
					good=false;
				}//if
				if(D & good) System.out.println("good");
			}
			
			int[] i00 = {2,3,4,7};
			int[] i10 = {1,3,6};
			int[] i20 = {1,2,3,4,5,6,7,8};
			int[] i30 = {1,2,3,4};
			int[] i40 = {};
			String[] ans00 = {"7","6","5,6,7,8","",""};
			matrix[0] = i00;matrix[1] = i10;matrix[2]=i20;matrix[3]=i30;matrix[4]=i40;
			for(int j=0;j<matrix.length;j++)
			{
				BT = new BankAccountsBinarySearchTree(comp);
				for(int i=0;i<matrix[j].length;i++){
					BA= new BankAccount("tomer",matrix[j][i],matrix[j][i]);
					BT.insert(BA);
				}
				if(D) System.out.println("creating new list for the filtered accounts");
				List<BankAccount> l = BankAccountFiltering.getAllValidAccounts(BT, 5, 1, 10);
				CD = cleanString(BT.toString());
				if(D) System.out.print("check "+ CD + " where balance min is 5 (account number is fine):");
				check = CS(cleanString(l.toString()),ans00[j]);
				if(!check) {
					fail();
					System.out.println("input "+CD+" should be "+ans00[j]+" but yours is: " +cleanString(l.toString()));
					good=false;
				}//if
				if(D & good) System.out.println("good");
			}
			
			
			if(good)
				good();
			System.out.println();
			}}}
		}
		private static void c6(boolean D) {
			boolean good=true;
			String s;
			boolean check;
			System.out.println("checking 6: ");
			System.out.print("add: ");
			if(D)System.out.println();
			if(D)System.out.println("adding to the bank 3 account: tomer 1 10000 , dolev 2 5 and yoval 3 900");
			Bank TOMER = new Bank();
			BankAccount BA = new BankAccount("tomer",1,10000);
			check=TOMER.add(BA);
			if(D) System.out.print("adding tomer :");
			if(!check) {
				fail();
				System.out.println("trying to add tomer, should be true but yours is : "+ check);
				good=false;
			}//if
			if(D & good) System.out.println("good");
			BA = new BankAccount("dolev",2,5);
			TOMER.add(BA);
			BA = new BankAccount("yoval",3,900);
			TOMER.add(BA);
			
			
			s=cleanString(TOMER.lookUp(1).toString());
			check=CS(s,"1");
			if(D) System.out.print("check for account tomer 1 10000 by account number :");
			if(!check) {
				fail();
				System.out.println("input tomer 1 10000 by account number should be 1 but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			s=cleanString(TOMER.lookUp(2).toString()).substring(1);
			check=CS(s,"2");
			if(D) System.out.print("check for account dolev 2 5 by account number :");
			if(!check) {
				fail();
				System.out.println("input dolev 2 5 by account number should be 2 but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			s=cleanString(TOMER.lookUp("yoval").toString()).substring(1);
			check=CS(s,"3");
			if(D) System.out.print("check for account yoval 3 90 by name :");
			if(!check) {
				fail();
				System.out.println("input yoval 3 90 by name should be 3 but yours is: " + s );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			BA = new BankAccount("tomer",1,10000);
			check = TOMER.add(BA);
			if(D) System.out.print("trying to add tomer again :");
			if(check) {
				fail();
				System.out.println("input tomer 1 10000 all ready in so add should be false but yours is: " + check );
				good=false;
			}//if
			if(D & good) System.out.println("good");
			
			if(good) {
					good();
				System.out.println();
				
				System.out.print("delete (both delete):");
				if(D)System.out.println();
				if(D)System.out.println("deleting all the account, tomer and dolev by acc number and yoval by name");
				check=TOMER.delete(1);
				if(D) System.out.print("deleting tomer :");
				if(!check) {
					fail();
					System.out.println("trying to delete tomer, should be true but yours is : "+ check);
					good=false;
				}//if
				if(D & good) System.out.println("good");
				
				TOMER.delete(2);
				TOMER.delete("yoval");

				check=TOMER.lookUp(1)==null;
				if(D) System.out.print("check for account tomer 1 10000 by account number :");
				if(!check) {
					fail();
					System.out.println("input tomer 1 10000 by account number should not find but yours said it did");
					good=false;
				}//if
				if(D & good) System.out.println("good");
				
				check=TOMER.lookUp(2)==null;
				if(D) System.out.print("check for account dolev 2 5 by account number :");
				if(!check) {
					fail();
					System.out.println("input dolev 2 5 by account number should not find but yours said it did");
					good=false;
				}//if
				if(D & good) System.out.println("good");
				
				check=TOMER.lookUp("yoval")==null;
				if(D) System.out.print("check for account yoval 3 90 by name :");
				if(!check) {
					fail();
					System.out.println("input yoval 3 90 by name should not find but yours said it did");
					good=false;
				}//if
				if(D & good) System.out.println("good");
				
				BA = new BankAccount("tomer",1,10000);
				check = TOMER.delete("tomer");
				if(D) System.out.print("trying to delete tomer again :");
				if(check) {
					fail();
					System.out.println("cant delete tomer again but yours said it did");
					good=false;
				}//if
				if(D & good) System.out.println("good");
				
				if(good) {
						good();
					System.out.println();
					
					System.out.print("depositMoney:");
					if(D)System.out.println();
					good=true;
					if(D)System.out.println("adding tomer with 100");
					BA = new BankAccount("tomer",1,100);
					TOMER.add(BA);
					if(D)System.out.print("depositing to tomer 100 money: ");
					check = TOMER.depositMoney(100,1);
					if(!check) {
						fail();
						System.out.println("trying to deposit tomer, should be true but yours is : "+ check);
						good=false;
					}//if
					if(D & good) System.out.println("good");
					
					check=TOMER.lookUp(1).getBalance()==200;
					if(D) System.out.print("check for account tomer if he has 200 now:");
					if(!check) {
						fail();
						System.out.println("after adding to tomer 100 when he had 100 should be 200 but yours is: " + TOMER.lookUp(1).getBalance() );
						good=false;
					}//if
					if(D & good) System.out.println("good");
					
					if(D) System.out.print("trying to add money to a number with no account:");
					check = TOMER.depositMoney(100,2);
					if(check) {
						fail();
						System.out.println("trying to add money to a number with no account should be false, but yours is: "+ check );
						good=false;
					}//if
					if(D & good) System.out.println("good");
					if(good) {
							good();
						System.out.println();
						
						System.out.print("withrawMoney:");
						if(D)System.out.println();
						good=true;
						if(D)System.out.print("withrawing from tomer 150 money:");
						check = TOMER.withdrawMoney(150,1);
						if(!check) {
							fail();
							System.out.println("trying to withraw 150 from tomer who has 200, should be true but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						check=TOMER.lookUp(1).getBalance()==50;
						if(D) System.out.print("check for account tomer if he has 50 now:");
						if(!check) {
							fail();
							System.out.println("after withraw from from tomer who has 200, should has now 50 but yours is: " + TOMER.lookUp(1).getBalance() );
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						if(D) System.out.print("trying to withraw 150 from tomer who has 50:");
						check = TOMER.withdrawMoney(150,1);
						if(check) {
							fail();
							System.out.println("trying to withraw 150 from tomer who has 50 , should be false but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						check = TOMER.withdrawMoney(100,2);
						if(check) {
							fail();
							System.out.println("trying to withraw to a number that has no account should be false, but yours is: "+ check );
							good=false;
						}//if
						if(good) {
							good();
						System.out.println();
						
						System.out.print("transferMoney by numbers:");
						if(D)System.out.println();
						if(D)System.out.println("adding noa with 100");
						BA = new BankAccount("noa",2,100);
						TOMER.add(BA);
						if(D)System.out.print("transfering from noa to tomer 60 money:");
						check = TOMER.transferMoney(60,2,1);
						if(!check) {
							fail();
							System.out.println("trying to transfer from noa to tomer 60 money, should be true but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						check=TOMER.lookUp(1).getBalance()==110;
						if(D) System.out.print("check for account tomer if he has 110 now:");
						if(!check) {
							fail();
							System.out.println("after adding to tomer 60 when he had 50 should be 110 but yours is: " + TOMER.lookUp(1).getBalance() );
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						check=TOMER.lookUp(2).getBalance()==40;
						if(D) System.out.print("check for account noa if she has 40 now:");
						if(!check) {
							fail();
							System.out.println("after withrawing from noa 60 when she had 100 should be 40 but yours is: " + TOMER.lookUp(1).getBalance() );
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						if(D)System.out.print("transfering from noa to tomer another 60 money:");
						check = TOMER.transferMoney(60,2,1);
						if(check) {
							fail();
							System.out.println("trying to transfer from noa to tomer 60 money, should be false since noa dosent have 60 money ,but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						if(D) System.out.print("transfering from tomer to no a real account 60 money:");
						check = TOMER.transferMoney(60,1,3);
						if(check) {
							fail();
							System.out.println("trying to transfer from tomer to not a real account 60 money, should be false but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						if(D) System.out.print("transfering from not a real account to tomer 60 money:");
						check = TOMER.transferMoney(60,3,1);
						if(check) {
							fail();
							System.out.println("trying to transfer from no a real account  to tomer 60 money, should be false but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						if(good) {
							good();
						System.out.println();
						
						System.out.print("transferMoney by name:");
						if(D)System.out.println();
						if(D)System.out.println("adding segev with 100");
						BA = new BankAccount("segev",4,100);
						TOMER.add(BA);
						if(D)System.out.println("adding guy with 100");
						BA = new BankAccount("guy",5,100);
						TOMER.add(BA);
						
						if(D)System.out.print("transfering from segev to guy 60 money:");
						check = TOMER.transferMoney(60,4,"guy");
						if(!check) {
							fail();
							System.out.println("trying to transfer from segev to guy 60 money, should be true but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						check=TOMER.lookUp(5).getBalance()==160;
						if(D) System.out.print("check for account guy if he has 160 now:");
						if(!check) {
							fail();
							System.out.println("after adding to guy 60 when he had 100 should be 160 but yours is: " + TOMER.lookUp(1).getBalance() );
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						check=TOMER.lookUp(4).getBalance()==40;
						if(D) System.out.print("check for account segev if she has 40 now:");
						if(!check) {
							fail();
							System.out.println("after withrawing from segev 60 when he had 100 should be 40 but yours is: " + TOMER.lookUp(1).getBalance() );
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						if(D)System.out.print("transfering from segev to guy another 60 money:");
						check = TOMER.transferMoney(60,4,"guy");
						if(check) {
							fail();
							System.out.println("trying to transfer from segev to guy 60 money, should be false since segev dosent have 60 money ,but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						if(D) System.out.print("transfering from guy to no a real account 60 money:");
						check = TOMER.transferMoney(60,5,"test");
						if(check) {
							fail();
							System.out.println("trying to transfer from segev to not a real account 60 money, should be false but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						if(D) System.out.print("transfering from not a real account to guy account 60 money:");
						check = TOMER.transferMoney(60,10,"guy");
						if(check) {
							fail();
							System.out.println("trying to transfer from no a real account to guy 60 money, should be false but yours is : "+ check);
							good=false;
						}//if
						if(D & good) System.out.println("good");
						
						if(good) 
							good();
						System.out.println();
			}}}}}
			
		}
		private static boolean CS(String s1,String s2) {
			return s1.equalsIgnoreCase(s2);
		}
		private static String cleanString(String s1)
		{
			String ans = "";
			for(int i =1;i<s1.length();i++)
			{
				char c = s1.charAt(i);
				if(s1.charAt(i-1)!= 'r')
				{
					if(toInclued(c))
					{
						ans += c;
					}
				}
			}
			return ans;
		}
		private static boolean toInclued(char c)
		{
			if("0123456789(),".indexOf(c)!=-1)
				return true;
			return false;
		}
		
}
