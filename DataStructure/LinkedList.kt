import java.util.NoSuchElementException

data class Node<E>(
    var item: E,
    var prev: Node<E>?,
    var next: Node<E>?
) {
    override fun toString(): String {
        return item.toString()
    }
}

class LinkedList<E> {

    private var size = 0
    var first: Node<E>? = null
    var last: Node<E>? = null

    fun add(e: E) {
        if (size > 0) {
            val node = Node(e, last, null)
            last?.next = node
            last = node
        } else {
            val node = Node(e, null, null)
            first = node
            last = node
        }
        size++
    }

    fun removeAt(idx: Int): E? {
        if (idx >= size) return null

        var target = first
        for (i in 0 until idx) {
            target = target?.next
        }
        return target?.let { remove(it) }
    }

    fun removeByData(element: E): E? {
        var target = first
        while (target != null) {
            if (target.item == element) {
                return remove(target)
            }
            target = target?.next
        }
        return null
    }

    private fun remove(node: Node<E>): E {
        node.prev?.next = node.next
        node.next?.prev = node.prev

        node.prev = null
        node.next = null
        size--
        return node.item
    }

    fun insert(idx: Int, e: E): Boolean {
        if (idx >= size) return false

        var target = first
        for (i in 0 until idx) {
            target = target?.next
        }
        if (target == first) {
            val node = Node(e, null, first)
            first?.prev = node
            first = node
        } else {
            val node = Node(e, target?.prev, target)
            target?.prev?.next = node
            target?.prev = node
        }

        size++
        return true
    }

    fun contains(e: E): Boolean {
        var p = first
        while (p != null) {
            if (p.item == e) {
                return true
            }
            p = p.next
        }
        return false
    }

    fun print() {
        var p = first
        while (p != null) {
            print("${p.item} ")
            p = p.next
        }
        println()
    }

    fun get(idx: Int): E? {
        var target = first
        for (i in 0 until idx) {
            target = target?.next ?: return null
        }
        return target?.item
    }

    fun set(idx: Int, e: E): Boolean {
        var target = first
        for (i in 0 until idx) {
            target = target?.next ?: return false
        }

        target?.item = e
        return true
    }


    // Clearing all the links between nodes is "unnecessary", but:
    // - helps a generational GC if the discarded nodes inhabit
    //   more than one generation
    // - is sure to free memory even if there is a reachable Iterator
    fun clear() {
        var target = first
        while (target != null) {
            val next = target.next
            target.prev = null
            target.next = null
            target = next
        }
        first = null
        last = null
    }
}

/*
    val selfLinkedList = LinkedList<Int>()

    selfLinkedList.add(1)
    selfLinkedList.add(2)
    selfLinkedList.add(3)
    selfLinkedList.print()
    >>> 1 2 3

    selfLinkedList.insert(1, 4)
    selfLinkedList.print()
    >>> 1 4 2 3

    selfLinkedList.removeAt(1)
    selfLinkedList.print()
    >>> 1 2 3

    selfLinkedList.removeByData(3)
    selfLinkedList.removeByData(5)
    selfLinkedList.print()
    >>> 1 2

    println("contains: ${selfLinkedList.contains(1)}")
    >>> contains: true

    selfLinkedList.clear()
    selfLinkedList.print()
    >>>
 */