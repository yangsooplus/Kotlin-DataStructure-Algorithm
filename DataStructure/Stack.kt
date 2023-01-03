
class Stack<E> : LinkedList<E>() {

    fun push(e: E) {
        addLast(e)
    }

    fun pop(): E? {
        return removeLast()
    }

    fun peek(): E? {
        return super.last?.item
    }
}

/*
    val stack = Stack<Int>()

    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.print()
    >>> 1 2 3

    println("peek: ${stack.peek()}")
    stack.print()
    >>> peek: 3
    >>> 1 2 3

    println("pop: ${stack.pop()}")
    stack.print()
    >>> pop: 3
    >>> 1 2

 */