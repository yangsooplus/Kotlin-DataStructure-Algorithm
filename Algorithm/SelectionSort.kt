class SelectionSort {
    fun selectionSort(array: Array<Int>) {
        for (i in array.indices) {
            var minIdx = i
            var minValue = array[i]
            for (j in i until array.size - 1) {
                if (array[j] < minValue) {
                    minIdx = j
                    minValue = array[j]
                }
            }
            swap(array, i, minIdx)
        }
    }

    fun swap(array: Array<Int>, a: Int, b: Int) {
        val tmp = array[a]
        array[a] = array[b]
        array[b] = tmp
    }
}