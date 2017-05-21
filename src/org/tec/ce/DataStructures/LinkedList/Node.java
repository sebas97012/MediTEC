package org.tec.ce.DataStructures.LinkedList;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Created by Arturo on 20/3/2017.
 */
public class Node<T extends Comparable<T>>{
	@JsonTypeInfo( use = Id.CLASS, include = As.WRAPPER_OBJECT)
    private T dataT;
    private Node<T> next;

    public Node(){
    	
    }
    
    public Node(T data){
        this.dataT = data;
        this.next = null;
    }

    public T getDataT() {
        return this.dataT;
    }

    public void setDataT(T dataT) {
        this.dataT = dataT;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

