package com.ahyql.java.improve;

import java.util.Arrays;

/**
 * Created by yql on 2017/5/14.
 * 使用数组模拟顺序线性表
 */
public class SimpleList<T> {

    /**
     * 默认容量
     */
    private static final int  DEFAULT_CAPACITY = 10;


    /**
     * 定义一个数组存储元素
     */
    private Object[] elementData;

    /**
     * 线性表大小
     */
    private int size;

    /**
     * 容量
     */
    private int capactity;

    /**
     * 创建空的线性表
     */
    public  SimpleList(){
        capactity = DEFAULT_CAPACITY;
        elementData = new Object[capactity];
    }

    /**
     * 创建一个带初始化元素的线性表
     * @param t
     */
    public SimpleList(T t){
        this();
        elementData[0] = t;
        size ++;
    }

    /**
     * 创建一个带初始化元素，并指定线性表大小
     * @param t
     * @param initSize
     */
    public SimpleList(T t ,int initSize){
        capactity = 1;
        while (capactity < initSize){
            capactity <<= 1;
        }
        elementData = new Object[capactity];
        elementData[0] = t;
        size ++;

    }

    /**
     * 返回线性表的长度
     * @return
     */
    public  int length(){
        return this.size;
    }

    /**
     * 查找指定位置的元素
     * @param index
     * @return
     */
    public T get(int index){
        if(index < 0 || index > size -1){
            throw new IndexOutOfBoundsException("index:["+index+"],size:["+size+"]");
        }
        return (T)elementData[index];
    }

    /**
     * 返回指定元素在线性表中第一次出现的位置
     * @param element
     * @return
     */
    public int locate(T element){
        for(int i = 0 ; i < size ; i++){
            if(elementData[i].equals(element)){
                return i;
            }
        }
        return -1;
    }


    /**
     *
     * @param index
     * @return
     */
    public T delete(int index){
        if(index < 0 || index > size -1){
            throw new IndexOutOfBoundsException("index:["+index+"],size:["+size+"]");
        }

        T del
                = (T)elementData[index];

        //需要移动的元素个数
        int moveNum = size - index -1;
        if(moveNum > 0){
            System.arraycopy(elementData,index +1,elementData,index,moveNum);
            //Arrays.fill(elementData,);
        }

        /**
         * 让数组最后一个元素为空
         */
        elementData[size - 1] = null;

        return del;
    }

    /**
     * 移除线性表中最后一个元素
     * @return
     */
    public T remove(){
        return delete(size -1);
    }

    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向线性表指定位置插入元素
     * @param element
     * @param index
     */
    public void  insert(T element,int index){
        //size -1 ? 比如size是3，index最大可以为3
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("index:["+index+"],size:["+size+"]");
        }
        ensureCapaticy(size + 1);

        System.arraycopy(elementData,index,elementData,index+1,size - index);
        elementData[index] = element;
        size++;

    }

    /**
     * 在线性表中开始处添加一个元素
     * @param element
     */
    public void add (T element){
        insert(element,size);
    }


    /**
     * 扩容
     * @param minCapacity
     */
    private void ensureCapaticy(int minCapacity){
        if(minCapacity > capactity){
            while (capactity < minCapacity){
                capactity <<= 1;
            }
            Arrays.copyOf(elementData,capactity);
        }
    }

    /**
     * 清空线性表
     */
    public void clear(){
        Arrays.fill(elementData,null);
        size = 0;
    }


    public String toString(){

        if(size == 0){
            return "[]";
        }else {
            StringBuilder sb = new StringBuilder("[");
            for(int i = 0;i < size ; i++){
                sb.append(elementData[i].toString()+", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
