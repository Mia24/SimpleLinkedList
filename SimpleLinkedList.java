/**
 **
 * @author Miao He mhe23@myseneca.ca
 * @version 1.0
 */
package partB;



	public class SimpleLinkedList {

		public Node head; // Head is first node in linked list
		public SimpleLinkedList() { }
		public SimpleLinkedList(Node head) {
			this.head=head;
		}
		public boolean isEmpty() {
			return length() == 0? true:false;
		}
		public void insertAtEnd(String data) {
		// TODO to be implemented
			Node temp =new Node(data);
			
			if (head == null)
				head=temp;
			else{
				Node last=tail();
				last.next=temp;
			// starting at the head node, crawl to the end of the list
			/*while(currentNode.getNext()!= null)
			
				currentNode = currentNode.getNext();
			
			// the last node's "next" reference set to our new node
			currentNode.setNext(temp);*/
			}
		}
		 public void insertAtBeginning(String data) {
		// TODO to be implemented
			Node n=new Node(data);
			n.next=head;
			head = n;
		}
		public Node tail() {
			Node tmp=head;
			if(tmp !=null)
				while(tmp.next != null)
					tmp=tmp.next;
			
			return tmp;
		// TODO to be implemented
		// returns the last node
		}
		public int length() {
			int count = 0;
			Node position = head;
			while(position!= null){
				count++;
				position = position.getNext();//to find the final value of the link
			}
			return count;
				
		}
		void insertAtIndex(int idx, String data) {
		// TODO to be implemented
			if(idx == 1)
			{
				insertAtBeginning(data);
			}
			else{
				Node n=new Node(data);
				Node tmp = head;
				for(int i=1; i<idx; i++)
					tmp=tmp.next;
				
				n.next=tmp.next;
				tmp.next=n;
				
			}
		}

		Node findAtIndex(int idx) {
			Node tmp = head;
			for(int i=1; i<idx; i++)
				tmp=tmp.next;
			/*if(idx <= 0)
				return null;
			
			Node curr = head.getNext();
			for(int i = 1; i < idx; i++)
			{
				if(curr.getNext() == null)
					
				
					curr = curr.getNext();
			}*/
			return tmp;
		// TODO to be implemented
		}
		void deleteAtIndex(int idx) {
		// TODO to be implemented
			if(idx == 1)
			{
				if(head != null)
					head = head.next;
			}
				else{
					Node tmp=head;
					for(int i=2; i<idx; i++)
						tmp=tmp.next;
					tmp.next =tmp.next.next;
				}
		}

		/* this methods reverse the list, for example 30891147becomes 74119803 */
		Node reverse() {
			Node p = null;
			Node tmp = head;
			while(tmp != null)
			{
				Node con=tmp.next;
				tmp.next=p;
				p=tmp;
				tmp=con;
				
			}
			head=p;
			return p;
			
		// TODO to be implemented
		}
		
		/* the same as previous method but use the recursive style */
		/*@SuppressWarnings("null")
		void reverseRecursive(Node p) {
			if (p == null)
				//return;
			if(p.next== null){
				head=p;
			   // return;
			}
			
		// TODO to be implemented
			reverseRecursive(p.next);
		// TODO to be implemented
			p.next.next =p;
			p.next = null;
		}*/
		
		void reverseRecursive(Node p) {
			if(p.next.next != null){
				reverseRecursive(p.next);
			}
			else {
				this.head=p.next;	
			}
			p.next.next =p;
			p.next = null;	
		}
		void deleteData(String s) {
		// TODO to be implemented
			Node p=null;
			Node tmp = head;
			while(tmp != null)
			{
				if (tmp.data.equals(s))
				{
					if(p == null)
						head = head.next;
					else
						p.next=tmp.next;
					break;
				}
				
				p=tmp;
				tmp =tmp.next;
			}
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((head == null) ? 0 : head.hashCode());
			return result;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SimpleLinkedList other = (SimpleLinkedList) obj;
			if (head == null) {
				if (other.head != null)
					return false;
			} else if (!head.equals(other.head))
				return false;
			return true;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			String StudID = "";
		
			for (Node d = head; d != null; d = d.getNext())
				StudID += d.data;

			return StudID;	
		}
		
		
	//Node is nested class because it only exists along with linked list
	public static class Node {
	private String data;
	Node next;
	//TODO develop all the methods that are needed
	//such as constructors, setters, getters
	//toString, equals, hashCode
		public Node(){
			data=null;
			next=null;
			
		}
		public Node(String data) {
			
			this.data = data;
			
			}
		public Node(String data, Node next) {
		super();
		this.data = data;
		this.next = next;
		}
		
	/**
		 * @return the data
		 */
		public String getData() {
			return data;
		}

		/**
		 * @param data the data to set
		 */
		public void setData(String data) {
			this.data = data;
		}

		/**
		 * @return the next
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}
		

	/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			return true;
		}


	/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return data;
		}
	}

	public void buildListFromID(long num, SimpleLinkedList digits) {
		if (num / 10 > 0) 
		{
		    buildListFromID(num / 10, digits);
	        }
		String s = String.valueOf(num % 10);
		//System.out.println(s);
		digits.insertAtEnd(s);
		
	}
		public static void main(String[] args) {
			 
				SimpleLinkedList sll = new SimpleLinkedList();
				long sid = 112727145L;
				sll.buildListFromID(sid, sll);

				System.out.println(sll); 

				for (int i = 1; i <= sll.length(); i++) 
				System.out.print(sll.findAtIndex(i));
				
				System.out.println();
				sll.reverse();
				for (int i = 1; i <= sll.length(); i++) 
					System.out.print(sll.findAtIndex(i));
				
				System.out.println();
				sll.deleteAtIndex(3);
				for (int i = 1; i <= sll.length(); i++) 
					System.out.print(sll.findAtIndex(i));
				
				System.out.println();
				sll.insertAtIndex(3, "Miao");
				for (int i = 1; i <= sll.length(); i++) 
					System.out.print(sll.findAtIndex(i));
				
	}
		
	}


