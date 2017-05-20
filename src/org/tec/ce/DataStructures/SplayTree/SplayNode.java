package org.tec.ce.DataStructures.SplayTree;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Created by Arturo on 8/5/2017.
 */
public class SplayNode<T extends Comparable>{
	@JsonTypeInfo( use = Id.CLASS, include = As.WRAPPER_OBJECT)
    private T data;
    private SplayNode left;
    private SplayNode right;

    /**
     * Constructor
     * @param data Informacion que va a almacenar el nodo
     */
    
    public SplayNode(T data){
        this(data, null, null);
    }
    /**
     * Constructor
     * @param data Informacion que va a almacenar el nodo
     * @param left Hijo izquierdo del nodo
     * @param right Hijo derecho del nodo
     */
    public SplayNode(T data, SplayNode left, SplayNode right){
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

    public SplayNode getLeft() {
        return left;
    }

    public void setLeft(SplayNode left) {
        this.left = left;
    }

    public SplayNode getRight() {
        return right;
    }

    public void setRight(SplayNode right) {
        this.right = right;
    }
}
