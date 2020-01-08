/*  CSI2114 Lab 2 - DLinkedList.java
 *  
 *  Class doubly linked list   
 *  
 *  by Jeff Souza
 *
 */

class DLinkedList {

    ListNode firstNode;
    ListNode lastNode;

    // Appends a node to the end of the list
    void AppendNode(ListNode nNode) {
        InsertNode(nNode,lastNode);
    }

    // Inserts a node into the list after pAfter
    void InsertNode(ListNode nNode, ListNode pAfter) {
		nNode.next = pAfter.next;
		nNode.previous = pAfter;
		pAfter.next = nNode;
		lastNode = nNode;
    }

    // Removes the specified node from the list
    void RemoveNode(ListNode nNode) {
		if(firstNode == null || nNode == null){
			return;
		}
		if(firstNode == nNode){
			firstNode = nNode.next;
		}

		if(lastNode == nNode){
			lastNode = nNode.previous;
		}

		if(nNode.next != null){
			nNode.next.previous = nNode.previous; 
		}

		if (nNode.previous != null) { 
			nNode.previous.next = nNode.next; 
		}
		
		return; 
    }

    // print the content of the list
    void print() {
        ListNode nNode = null;
        System.out.print("Current list: ");
        for (nNode = firstNode; nNode != null; nNode = nNode.next) {
            System.out.print(nNode.data +  " ");
        }
        System.out.println("");
    } 
  
}