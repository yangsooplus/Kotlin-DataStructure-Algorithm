data class TNode<E>(
    val item: E,
    var left: TNode<E>?,
    var right: TNode<E>?
)

class Tree<E> {

    var root: TNode<E>? = null

    fun add(p: E, l: E?, r: E?) {
        val parent = if (root == null) {
            root = TNode(p, null, null)
            root
        } else {
            get(p)
        }

        if (l != null) {
            parent?.left = TNode(l, null, null)
        }

        if (r != null) {
            parent?.right = TNode(r, null, null)
        }
    }


    fun get(e: E): TNode<E>? {
        if (root == null) return null

        val queue = Queue<TNode<E>>().apply {
            enqueue(root!!)
        }

        while (queue.isEmpty().not()) {
            val v = queue.dequeue() ?: return null
            if (v.item == e) return v
            if (v.left != null) queue.enqueue(v.left!!)
            if (v.right != null) queue.enqueue(v.right!!)
        }
        return null
    }

    fun printInOrder() {
        val queue = Queue<TNode<E>>().apply {
            enqueue(root!!)
        }

        while (queue.isEmpty().not()) {
            val v = queue.dequeue() ?: return

            print("${v.item} ")
            if (v.left != null) queue.enqueue(v.left!!)
            if (v.right != null) queue.enqueue(v.right!!)
        }
    }

}

/*

    val tree = Tree<Char>()

    tree.add('A', 'B', 'C')
    tree.add('B', 'D', null)
    tree.add('C', 'E', 'F')
    tree.add('E', null, null)
    tree.add('F', null, 'G')
    tree.add('D', null, null)
    tree.add('G', null, null)

    tree.printInOrder()
    >>> A B C D E F G


 */