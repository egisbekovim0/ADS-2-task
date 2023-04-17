Here how my files work

MyList (Interface)
size(): returns the number of elements in the list.
contains(Object o): returns true if the list contains the specified object.
add(T item): adds the specified element to the end of the list.
add(T item, int index): inserts the specified element at the specified position in the list.
remove(T item): removes the first occurrence of the specified element from the list.
remove(int index): removes the element at the specified position in the list and returns it, otherwise throws an exception.
clear(): removes all elements from the list.
get(int index): returns the element at the specified position in the list.
indexOf(Object o): returns the index of the first occurrence of the specified element in the list.
lastIndexOf(Object o): returns the index of the last occurrence of the specified element in the list.
sort(): sorts the elements in the list in ascending order.

MyArrayList (Class)
increaseBuffer(): increases the capacity of the list by 2 times.
swap(Object[] arr, int i, int j): swaps two elements in the list.
implements MyList interface.
Can be iterated using Iterable.
MyLinkedList (Class)
removeNode(MyNode node): removes the specified node from the list.
Can be iterated using Iterable.

Main (Class)
Test all methods from MyArrayList and MyLinkedList with data structures of type Integer and String. Giving various examples
