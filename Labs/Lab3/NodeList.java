// ==========================================================================
// $Id: addTemplate.cpp,v 1.1 2005/11/02 23:13:32 jlang Exp $
// CSI2110 Lab code Node List skeleton class
// ==========================================================================
// (C)opyright:
//
//   Jochen Lang
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: jlang (Jochen Lang)
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: addTemplate.cpp,v $
//
// ==========================================================================
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class NodeList<E> {
  // The linked list which is to be adapted
  protected LinkedList<E> linkedList = new LinkedList<E>();

  // Directly available
  public int size() {
    return linkedList.size();
  }

  // Directly available
  public boolean isEmpty() {
     return linkedList.isEmpty();
  }

  // fix me!
  public boolean isFirst(E element) {
    if(element == linkedList.getFirst()) {
    	return true;
    }
    return false;
  }

  // fix me!
  public boolean isLast(E element) {
    if(element == linkedList.getLast()) {
    	return true;
    }
    return false;
  }

  // Directly available
  public E first() 
    throws NoSuchElementException {
    return linkedList.element();
  }


  // Directly available
  public E last() 
    throws NoSuchElementException {
    return linkedList.getLast();
  }

  // fix me!
  E prev(E element)
    throws NoSuchElementException {
	  if(element == linkedList.getFirst()) {
		    throw new NoSuchElementException();
	  }
    int index = linkedList.indexOf(element);
    return linkedList.get(index-1);
  }


  // fix me!
  E next(E element)
    throws NoSuchElementException {
	  if(element == linkedList.getLast()) {
		    throw new NoSuchElementException();
	  }
  int index = linkedList.indexOf(element);
  return linkedList.get(index+1);
  }

  // fix me!
  public void swapElements(E element1, E element2)
    throws NoSuchElementException {
    if(!linkedList.contains(element1) || !linkedList.contains(element2)) {
    	throw new NoSuchElementException();
    }
    int index1 = linkedList.indexOf(element1);
    int index2 = linkedList.indexOf(element2);
    linkedList.set(index2, element1);
    linkedList.set(index1, element2);
  }
  

  // fix me!
  public void set(E currElement, E repElement)
    throws NoSuchElementException {
    if(!linkedList.contains(currElement)){
    	throw new NoSuchElementException();
    }
    linkedList.set(linkedList.indexOf(currElement), repElement);
  }


  // Directly available
  public void addFirst(E element) {
    linkedList.addFirst(element);
    return;
  }

  // Directly available
  public void addLast(E element) {
    linkedList.addLast(element);
    return;
  }

  // fix me!
  public void addBefore(E currElement,E addElement)
    throws NoSuchElementException {
    if(!linkedList.contains(currElement)) {
    	throw new NoSuchElementException();
    }
    linkedList.add(linkedList.getLast());
    int index = linkedList.indexOf(currElement);
    for(int i = linkedList.size()-2; i>= index; i--) {
    	linkedList.set(i+1, linkedList.get(i));
    }
    linkedList.set(index, addElement);
  }

  // fix me!
  public void addAfter(E currElement,E addElement) 
    throws NoSuchElementException {
	    if(!linkedList.contains(currElement)) {
	    	throw new NoSuchElementException();
	    }
	    linkedList.add(linkedList.getLast());
	    int index = linkedList.indexOf(currElement);
	    for(int i = linkedList.size()-2; i>= index; i--) {
	    	linkedList.set(i+1, linkedList.get(i));
	    }
	    linkedList.set(index+1, addElement);
  }
  
  // fix me!
  public E remove(E element) 
    throws NoSuchElementException {
	    if(!linkedList.contains(element)) {
	    	throw new NoSuchElementException();
	    }
	    linkedList.remove(element);
	    return element;
  	}
}
