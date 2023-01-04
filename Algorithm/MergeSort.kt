class MergeSort {

    fun mergeSort(array: Array<Int>, left: Int, right: Int) { // right 범위 포함.
        val size = right - left + 1
        if (size <= 2) return
        val center = left + size / 2

        mergeSort(array, left, center)
        mergeSort(array, center + 1, right)

        val tmpArray = Array(size) {0}
        var idx = 0
        var i = left
        var j = center + 1

        while (idx < size && i <= center && j <= right) {
            if (array[i] < array[j]) {
                tmpArray[idx++] = array[i++]
            } else {
                tmpArray[idx++] = array[j++]
            }
        }

        while (i <= center) {
            tmpArray[idx++] = array[i++]
        }

        while (j <= right) {
            tmpArray[idx++] = array[j++]
        }

        for (idx in 0 until size) {
            array[left+idx] = tmpArray[idx]
        }
    }

}