// Реализовать алгоритм пирамидальной сортировки (HeapSort).

public class task_3_dz {
    public static void main(String[] args) {
        int[] a = new int[] {-9, -3, 4, -10, -1, -6, 8, 8, -8, -6};
        for (int i : a) System.out.print(i + " ");
        System.out.println();
        sort(a);
        for (int j : a) System.out.print(j + " ");
    }

	private static int heapSize; // Размер кучи. Изначально равен размеру сортируемого массива
	
	public static void sort(int[] a) {  // Сортировка с помощью кучи.
		buildHeap(a);             // Сначала формируется куча. Теперь максимальный элемент массива находится в корне кучи.
		while (heapSize > 1) {          // Повторить до тех пор, пока в куче не останется 1 элемент.
			swap(a, 0, heapSize - 1); // Максимальный элемент массива нужно поменять местами с последним элементом и 
			heapSize--;                  // убрать из кучи (уменьшить размер кучи на 1). Теперь в корне кучи находится 
			heapify(a, 0);  // элемент, который раньше был последним в массиве. Нужно переупорядочить кучу так, чтобы
		}                     // выполнялось основное условие кучи - a[parent]>=a[child].
	}                         // После этого в корне окажется максимальный из оставшихся элементов.

    private static void buildHeap(int[] a) { // Построение кучи. Поскольку элементы с номерами начиная с a.length / 2 + 1
		heapSize = a.length;                 // это листья, то нужно переупорядочить поддеревья с корнями в индексах от 0
		for (int i = a.length / 2; i >= 0; i--) { // до a.length / 2 (метод heapify вызывать в порядке убывания индексов).
			heapify(a, i);
		}
	}
	
	private static void heapify(int[] a, int i) { // Переупорядочивает поддерево кучи начиная с узла i так, чтобы 
		int l = 2 * i + 1;                          //выполнялось основное свойство кучи - a[parent] >= a[child].
		int r = 2 * i + 2;
		int largest = i;
		if (l < heapSize && a[i] < a[l]) {
			largest = l;
		} 
		if (r < heapSize && a[largest] < a[r]) {
			largest = r;
		}
		if (i != largest) {
			swap(a, i, largest);
			heapify(a, largest);
		}
	}

	private static void swap(int[] a, int i, int j) { // Меняет местами два элемента в массиве.
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
