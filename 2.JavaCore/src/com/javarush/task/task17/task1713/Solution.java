package com.javarush.task.task17.task1713;

import java.util.*;

/* 
Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.


Требования:
1. Класс Solution должен реализовывать интерфейс List<Long>.
2. Класс Solution должен содержать private поле original типа ArrayList<Long>.
3. Все переопределенные методы интерфейса List должны делегировать полномочия методам объекта original.
4. Все методы класса Solution, кроме метода main, должны быть синхронизированы.
*/

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    @Override
    public synchronized int size() {
        return original.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        if(original.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public synchronized boolean contains(Object o) {
        if(this.original.contains(o))
            return true;
        else
            return false;
    }

    @Override
    public synchronized Iterator<Long> iterator() {
        return original.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return original.toArray();
    }

    @Override
    public synchronized <T> T[] toArray(T[] ts) {
        return original.toArray(ts);
    }

    @Override
    public synchronized boolean add(Long aLong) {
        if(original.add(aLong))
            return true;
        else
            return false;
    }

    @Override
    public synchronized boolean remove(Object o) {
        if(original.remove(o))
            return true;
        else
            return false;
    }

    @Override
    public synchronized boolean containsAll(Collection<?> collection) {
        if(original.containsAll(collection))
            return true;
        else
            return false;
    }

    @Override
    public synchronized boolean addAll(Collection<? extends Long> collection) {
        if(original.addAll(collection))
            return true;
        else
            return false;
    }

    @Override
    public synchronized boolean addAll(int i, Collection<? extends Long> collection) {
        if(original.addAll(i, collection))
            return true;
        else
            return false;
    }

    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        if(original.removeAll(collection))
            return true;
        else
            return false;
    }

    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        if(original.retainAll(collection))
            return true;
        else
            return false;
    }

    @Override
    public synchronized void clear() {
        original.clear();
    }

    @Override
    public synchronized Long get(int i) {
        return original.get(i);
    }

    @Override
    public synchronized Long set(int i, Long aLong) {
        return original.set(i, aLong);
    }

    @Override
    public synchronized void add(int i, Long aLong) {
        original.add(i, aLong);
    }

    @Override
    public synchronized Long remove(int i) {
        return original.remove(i);
    }

    @Override
    public synchronized int indexOf(Object o) {
        return original.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return original.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator<Long> listIterator() {
        return original.listIterator();
    }

    @Override
    public synchronized ListIterator<Long> listIterator(int i) {
        return original.listIterator(i);
    }

    @Override
    public synchronized List<Long> subList(int i, int i1) {
        return original.subList(i, i1);
    }
}
