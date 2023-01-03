class Queue<E> : LinkedList<E>() {

    fun enqueue(e: E) {
        addLast(e)
    }

    fun dequeue(): E? {
        return removeFirst()
    }

    fun peek(): E? {
        return first?.item
    }

}

/*
    val queue = Queue<Int>()

    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.print()
    >>> 1 2 3

    println("peek: ${queue.peek()}")
    queue.print()
    >>> peek: 1
    >>> 1 2 3

    println("pop: ${queue.dequeue()}")
    queue.print()
    println("pop: ${queue.dequeue()}")
    queue.print()
    >>> pop: 1
    >>> 2 3
    >>> pop: 2
    >>> 3

 */