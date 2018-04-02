package org.javacore.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * ArrayList源码剖析
 *
 * ArrayList简介
 ArrayList是基于数组实现的，是一个动态数组，其容量能自动增长，类似于C语言中的动态申请内存，动态增长内存。
 ArrayList不是线程安全的，只能用在单线程环境下，
 多线程环境下可以考虑用Collections.synchronizedList(List l)函数返回一个线程安全的ArrayList类，
 也可以使用concurrent并发包下的CopyOnWriteArrayList类。
 ArrayList实现了Serializable接口，因此它支持序列化，能够通过序列化传输，
 实现了RandomAccess接口，支持快速随机访问，实际上就是通过下标序号进行快速访问，
 实现了Cloneable接口，能被克隆。
 * @author chenzhongqiang
 * @create 2018-04-02 14:52
 **/
public class ArrayListT {

    public static void main(String[] args) {
        listMethods();
    }

    public static void listMethods() {
        // 无参构造函数：
        // 创建一个 空的 ArrayList，此时其内数组缓冲区 elementData = {}, 长度为 0
        List a1 = new ArrayList<String>();

//       当元素第一次被加入时，扩容至默认容量 10
        a1.add("List01");
        a1.add("List03");
        a1.add("List04");
        System.out.print("原来集合：\n\t" + a1 + "\n");
        a1.add(1, "List02");
        System.out.print("指定角标1插入：\n\t" + a1 + "\n");
        a1.remove(2);
        System.out.print("指定角标2删除：\n\t" + a1 + "\n");
        System.out.print("指定角标2查询：\n\t" + a1.get(2) + "\n");

        Iterator i1 = a1.iterator();
        System.out.println("用迭代器查询全部元素：");
        while (i1.hasNext()) {
            System.out.print(i1.next() + "\t");
        }

        List list = Collections.synchronizedList(a1);
        System.out.println("该list是线程安全的");
    }
}
