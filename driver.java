package lab3b;
import java.util.Scanner;
public class driver {
		public static void main(String[] args)
		{
			Scanner scan=new Scanner(System.in);
			list l=new list();
			list.print("Enter no: of elements: ");
			int s=scan.nextInt();
			list.print("Enter elements: ");
			for(int i=0;i<s;i++)
			{
				l.insertEnd(scan.nextInt());
			}
			l.printLinkedlist();
			//1.Function that returns the nth value of a linked list
			System.out.print("The nth node from the end is: ");
			l.nthNode(3);
			//2.Function that returns the middle value
			v=l.midValue();
			if(v==-1)
			{
				list.print("Error");
			}
			else
			{
				list.print("Value at middle: "+v);
			}
			//3.Function that removes all duplicates in a sorted linked list(ascending or descending) 
			l.RemoveDuplicates();
			list.print("New Size,After removing duplicates: "+l.getSize());
			l.printLinkedlist();
			int n1,n2;
			list l1=new list();
			list l2=new list();
			//4.Merging two sorted Linked Lists
			list.print("Enter size of list 1 to be merged: ");
			n1=scan.nextInt();
			list.print("Enter elements: ");
			for(int i=0;i<n1;i++)
				l1.insertEnd(scan.nextInt());
			list.print("Enter size of list 2 to be merged ");
			n2=scan.nextInt();
			list.print("Enter elements: ");
			for(int i=0;i<n2;i++)
				l2.insertEnd(scan.nextInt());
			list l3=l1.merge(l2);
			l3.printLinkedlist();
			//5.Reversing the linked list by reversing the links
			list.print("Reversing the above linked list");
			l3.reverse();
			l3.printLinkedlist();
		scan.close();
		}

	}

