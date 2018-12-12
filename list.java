package lab3b;

import List.Node;

public class list {

	public class Node {
		public int data;
		public Node next;
		Node()
		{
			this.data=-1;
			this.next=null;
		}
		Node(int d)
		{
			this.data=d;
			this.next=null;
		}

	}
	private Node first=new Node();
	private int size=0;
	//Method for Insertion at the Beginning of the list
	public void InsertBegin(int d)
	{
		if(this.isEmpty())
			{
			first.next=new Node(d);
			print(d+" is inserted");
			this.increSize();
			}
		else
		{
			Node n=new Node(d);
			n.next=first.next;
			first.next=n;
			print(d+" is inserted");
			this.increSize();
		}
	}
	//Merge two Sorted Lists
	public list merge(list l2)
	{
		list m=new list();
		Node temp1=this.first.next;
		Node temp2=l2.first.next;
		int i,j;
		for(i=1,j=1;i<=this.size&&j<=l2.size;)
		{
			if(temp1.data<temp2.data)
			{
				m.insertEnd(temp1.data);
				temp1=temp1.next;
				++i;
			}
			else
			{
				m.insertEnd(temp2.data);
				temp2=temp2.next;
				++j;
			}
		}
		while(i<=this.size)
		{
			m.insertEnd(temp1.data);
			temp1=temp1.next;
			++i;
		}
		while(j<=l2.size)
		{
			m.insertEnd(temp2.data);
			temp2=temp2.next;
			++j;
		}
		return m;
	}
	//Method to return the nth value
	public void nthNode(int n) {
		Node temp=head;
		int len=0;
		while(temp!=null) {
			temp=temp.next;
			len++;
		}
		if(len<n) 
			return;
		temp=head;
	for(int i=1;i<len-n+1;i++) 
		temp=temp.next;
	System.out.print(temp.data);
	System.out.println("");
	}
	//Method for finding middle value
	public double midValue()
	{
			int mid=(1+this.size)/2;
			return this.nthValue(mid); 
	}
	//Method to Remove all duplicates
	public void RemoveDuplicates()
	{
		Node temp=first.next;
		do
		{
		if(temp.data==temp.next.data)
			{
			temp.next=temp.next.next;
			this.decreSize();
			}
		else
			temp=temp.next;
		}while(temp.next!=null);
	}
	//Method for Insertion at the Beginning of the list,without print statement for checkForPallindrome Method
	public void insertAtBegForPal(int d)
	{
		if(this.isEmpty())
		{
		first.next=new Node(d);
		//print(v+" is inserted");
		this.increSize();
		}
	else
	{
		Node n=new Node(d);
		n.next=first.next;
		first.next=n;
		//print(v+" is inserted");
		this.increSize();
	}
	}
	//Method to reverse a singly linked list
	public void reverse()
	{
		Node curr=first.next;
		if(this.isEmpty())
			print("List is Empty");
		else
		{
		Node prev=null,next=null;
		while(curr!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		this.first.next=prev;
		}
	}
	//Method used for checking whether two linked lists are equal or not
	public boolean checkForEquality(list r)
	{
		if(this.size!=r.size)
			return false;
		else
		{
			Node temp1=this.first;
			Node temp2=r.first;
			do 
			{
				temp1=temp1.next;
				temp2=temp2.next;
				if(temp1.data!=temp2.data)
					return false;
			}while(temp1.next!=null);
		}
		return true;
	}
	
	//Method for removing an element or value in a particular position of the list
	public void removePos(int p)
	{
		if(this.isEmpty())
			print("Linked List is empty");
		else
		{
		int pos=1;
		if(p==1)
			this.removeFirst();
		else if(p==this.size)
			this.removeLast();
		else if(p<1||p>this.size)
			{
			print("Invalid position");
			}
		else
		{
			Node temp=first;
			do
			{
			temp=temp.next;
			if(p==pos+1)
			{
			print("Value deleted: "+temp.next.data);
			temp.next=temp.next.next;
			this.decreSize();
			return;
			}
			else
			pos++;
			}while(temp.next!=null);
		}
		}
	}
	
	//Method for inserting an element in a sorted Linked List
	public void sortedInsertion(int d)
	{
		if(this.isEmpty())
			print("List is empty");
		else
		{
			Node temp=first;
			int p=1;
			do
			{
				temp=temp.next;
				if(temp.data>=d)
					{
					this.insertionPos(p, d);
					return;
					}
				else
					++p;
					
			}while(temp.next!=null);
			if(d>=temp.data)
				{
				this.insertionPos(p, d);
				}
		}
	}
	//Method for inserting the given element at a particular position
	public void insertionPos(int pos,int v)
	{
		if(this.isEmpty())
		{
			print("List is empty");
		}
		else if(pos>=1&&pos<=this.size+1)
		{
			if(pos==1)
				{
				this.InsertBegin(v);
				}
			else if(pos==this.size+1)
				{
				this.insertEnd(v);
				}
			else
			{
				Node temp=first;
				int p=1;
				do
				{
					temp=temp.next;
					if(pos-1==p)
					{
						Node t=temp.next;
						temp.next=new Node(v);
						temp.next.next=t;
						print(v+" is inserted");
						this.increSize();
						return;
						
					}
					else
					++p;
					
				}while(temp.next!=null);
			}
				
			
		}
		else
			print("Invalid position");
	}
	//Method for incrementing the size of the Linked list,when values are inserted
	public void increSize()
	{
		this.size++;
	}
	//Method for decrementing the size of the Linked list,when values are removed from the list
	public void decreSize()
	{
		this.size--;
	}
	//Method that returns the size of the linked list
	public int getSize()
	{
		return this.size;
	}
	//Method for printing the elements of a linked list,ex:1->2->3->4
	public void printLinkedlist()
	{
		if(this.isEmpty())
			print("Nothing to print,List is Empty");
		else
		{
			print("Printing Linked List");
			Node temp=this.first;
			do
			{
			temp=temp.next;
			if(temp.next!=null)
			System.out.print(temp.data+"->");
			else
			System.out.println(temp.data);
			}
			while(temp.next!=null);
		}
	}
	//Method for inserting a value at the end of the linked list
	public void insertEnd(int v)
	{
		Node n=new Node(v);
		Node end=this.getLastElement();
		end.next=n;
		n.next=null;
		this.increSize();
		
	}
	//Method for removing the first element of the linked list
	public void removeFirst()
	{
		if(this.isEmpty())
			print("List is empty");
		else
		{
			print("\nValue deleted: "+first.next.data);
			first.next=first.next.next;
			this.decreSize();
		}
				
	}
	//Method for removing the last element of the linked last
	public void removeLast()
	{
		if(this.isEmpty())
			print("List is empty");
		else
		{
			Node v=this.getSecondLast();
			print("\nValue deleted "+v.next.data);
			v.next=null;
			this.decreSize();
		}
	}
	//Method for getting the second last node
	public Node getSecondLast()
	{
		Node temp=this.first;
		do
		{
			temp=temp.next;
			if(temp.next.next==null)
				return temp;
			
		}while(temp.next!=null);
		return first;
	}
	//Method for removing value v from the linked list
	public void removeVal(int v)
	{
		if(this.isEmpty())
			print("List is empty");
		else
		{
			Node temp=first;
			while(temp.next!=null)
			{
				if(temp.next.data==v)
				{
					temp.next=temp.next.next;
					print("Value removed: "+v);
					return;
				}
				temp=temp.next;
			}
		}
		print("Value of not found");
	}
	//Method for searching a node,having value v
	public Node Search(int v)
	{
			Node temp=first;
			do
			{
				temp=temp.next;
				if(temp.data==v)
					return temp;
			}while(temp.next!=null);
			return null;
	}
	//Method for getting the last element of the linked list
	public Node getLastElement()
	{
		if(this.isEmpty())
		{
			return this.first;
		}
		else
		{
			Node temp=this.first;
			while(temp.next!=null)
			{
				//Continue
				temp=temp.next;
			}
			return temp;
		}
	}	
	public static void print(String s)
	{
		System.out.println(s);
	}
	public boolean isEmpty()
	{
		if(this.first.next==null)
			return true;
		else
			return false;
	}
}

