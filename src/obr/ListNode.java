package obr;


public class ListNode<T> {
	 private ListNode<T> next;
	 private T item;
	 private ListNode<T> prev;

	    public ListNode(T item) {
	        this.item = item;
	        this.next = null;
	    }

	    public T getElement() {
	        return item;
	    }

	    public ListNode <T> getNext() {
	        return next;
	    }

	    public void setNext(ListNode <T> next) {
	        this.next = next;
	    }
	    
	    public ListNode <T> getPrev() {
	    	return prev;
	    }
	    
	    public void setPrev(ListNode<T> prev) {
	    	this.prev = prev;
	    }
}
