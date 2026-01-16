package com.example.actividad_m1_03;

// Librerias necesarias para la Activity
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log; // Necesario para imprimir en Logcat
import java.util.Random;
import java.util.Arrays; // Necesario para el método de ordenamiento (sort)

public class MainActivity extends AppCompatActivity {

    // Etiqueta para filtrar los mensajes en Logcat
    private static final String TAG = "SortingPerformanceTest";
    // Constante para definir el tamaño del arreglo (1 millón de elementos)
    private static final int ARRAY_SIZE = 1_000_000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout llamado activity_main.xml
        setContentView(R.layout.activity_main);

        // 3. Crear un arreglo con 1 millón de elementos enteros de manera aleatoria.
        Log.i(TAG, "==================================================");
        Log.i(TAG, "Iniciando prueba de ordenamiento...");

        int[] randomArray = new int[ARRAY_SIZE];
        Random random = new Random();

        // Llenado del arreglo con números aleatorios
        for (int i = 0; i < ARRAY_SIZE; i++) {
            // Genera enteros entre 0 y ARRAY_SIZE (excluido)
            randomArray[i] = random.nextInt(ARRAY_SIZE);
        }
        Log.i(TAG, "Arreglo de " + ARRAY_SIZE + " elementos aleatorios creado.");

        // 5. Medición detiempo de inicio
        // System.currentTimeMillis() devuelve el tiempo en milisegundos.
        long startTime = System.currentTimeMillis();
        Log.i(TAG, "Tiempo de ordenamiento inicial (ms): " + startTime);

        // 4. Ordenanación de elementos.
        // Arrays.sort() utiliza un algoritmo muy eficiente (Dual-Pivot Quicksort)
        Arrays.sort(randomArray);

        // 5. Medición de tiempo final
        long endTime = System.currentTimeMillis();
        Log.i(TAG, "Tiempo de ordenamiento final (ms): " + endTime);

        // Calculo de la duración
        long duration = endTime - startTime;

        // 6. Imprimir en el logcat los resultados obtenidos.
        Log.d(TAG, "--- RESULTADOS DE LA PRUEBA DE ORDENAMIENTO ---");
        Log.d(TAG, "Tamaño del arreglo: " + ARRAY_SIZE + " elementos.");
        Log.d(TAG, "Algoritmo usado: Arrays.sort() de Java");
        Log.d(TAG, "Tiempo total de ordenamiento: " + duration + " milisegundos.");
        Log.d(TAG, "--------------------------------------------------");

        // Opcional: Verificar que el ordenamiento fue correcto imprimiendo los primeros 5 elementos.
        Log.v(TAG, "Primeros 5 elementos ordenados: " + Arrays.toString(Arrays.copyOfRange(randomArray, 0, 5)));
        Log.v(TAG, "Últimos 5 elementos ordenados: " + Arrays.toString(Arrays.copyOfRange(randomArray, ARRAY_SIZE - 5, ARRAY_SIZE)));
        Log.i(TAG, "==================================================");
    }
}