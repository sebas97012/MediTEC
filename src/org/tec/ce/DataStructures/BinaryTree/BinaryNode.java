package org.tec.ce.DataStructures.BinaryTree;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Created by Arturo on 22/4/2017.
 */
public class BinaryNode<T extends Comparable<T>>{
	@JsonTypeInfo( use = Id.CLASS, include = As.WRAPPER_OBJECT)
    private T data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(){
    	
    }
    
    /**
     * Constructor
     * @param data Informacion que va a almacenar el nodo
     */
    public BinaryNode(T data){
        this(data, null, null);
    }

    /**
     * Constructor
     * @param data Informacion que va a almacenar el nodo
     * @param left Hijo izquierdo del nodo
     * @param right Hijo derecho del nodo
     */
    public BinaryNode(T data, BinaryNode left, BinaryNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
