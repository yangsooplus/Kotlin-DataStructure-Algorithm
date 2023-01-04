class PriorityQueue {

    private val arrayList: ArrayList<Int> = arrayListOf(0)
    val size get() = arrayList.size - 1

    fun enqueue(e: Int) {
        arrayList.add(e)
        upHeap(size)
    }

    fun addAll(collection: Collection<Int>) {
        collection.forEach {
            enqueue(it)
        }
    }

    private fun upHeap(idx: Int) {
        var target = idx

        while (true) {
            if (target <= 0) break

            val p = target/2

            if (arrayList[p] > arrayList[target]) {
                swap(p, target)
                target = p
            } else {
                break
            }
        }
    }

    private fun downHeap() {
        for (i in size/2 downTo 1) {
            val target = if (arrayList[2*i] < arrayList[2*i + 1]) 2*i else 2*i + 1
            if (target < size /2) continue
            // 내가 더 커?
            if (arrayList[i] > arrayList[target]) {
                swap(i, target)
            }
        }
    }

    private fun swap(a: Int, b: Int) {
        val tmp = arrayList[a]
        arrayList[a] = arrayList[b]
        arrayList[b] = tmp
    }

    fun dequeue(): Int {
        val root = arrayList[1]
        arrayList[1] = arrayList[size]
        arrayList.removeAt(size)

        var target = 1
        while (target <= size/2) {
            val left = if (2*target <= size) 2*target else break
            val smaller = if (2*target + 1 <= size) {
                val right = 2*target + 1
                if (arrayList[left] < arrayList[right]) left else right
            } else {
                left
            }


            if (arrayList[target] > arrayList[smaller]) {
                swap(target, smaller)
                target = smaller
            } else {
                break
            }
        }
        return root
    }

    fun print() {
        arrayList.forEach {
            print("$it ")
        }
        println()
    }
}

/*
    val priorityQueue = PriorityQueue()
    priorityQueue.addAll(listOf(1, 5, 9, 40, 1, 3, 4))
    priorityQueue.print()
    >>> 0 1 1 3 40 5 9 4

    println("dequeue: ${priorityQueue.dequeue()}")
    println("dequeue: ${priorityQueue.dequeue()}")
    println("dequeue: ${priorityQueue.dequeue()}")
    println("dequeue: ${priorityQueue.dequeue()}")
    println("dequeue: ${priorityQueue.dequeue()}")
    println("dequeue: ${priorityQueue.dequeue()}")
    println("dequeue: ${priorityQueue.dequeue()}")
    >>> dequeue: 1
    >>> dequeue: 1
    >>> dequeue: 3
    >>> dequeue: 4
    >>> dequeue: 5
    >>> dequeue: 9
    >>> dequeue: 40

*/
