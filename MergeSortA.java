import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MergeSortA{

    // Método para leer el archivo y almacenar los números en un arreglo
    public static int[] leerArchivo(String fileName) {
        ArrayList<Integer> numeros = new ArrayList<>();

        try {
            File file = new File("C:\\archivos\\" + fileName + ".txt");
            BufferedReader bufer = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufer.readLine()) != null) {
                numeros.add(Integer.parseInt(line.trim()));
            }
            bufer.close();

        } catch (Exception e) {
            // Se omite el manejo de errores.
        }

        int[] arr = new int[numeros.size()];
        for (int i = 0; i < numeros.size(); i++) {
            arr[i] = numeros.get(i);
        }
        return arr;
    }

    // Método de Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    // Método para combinar dos mitades de un arreglo
    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new java.io.InputStreamReader(System.in));
        System.out.println("Escribe el nombre del archivo:");
        String fileName = bufer.readLine();

        int[] arr = leerArchivo(fileName);

        // Mostrar arreglo original
        System.out.println("Arreglo original:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Ordenar el arreglo con Merge Sort
        mergeSort(arr, 0, arr.length - 1);

        // Mostrar arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
