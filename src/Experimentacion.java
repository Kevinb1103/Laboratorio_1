public class Experimentacion {
    public static void main(String[] args) {
        int cantEvaluacionesFijas = 10;

        // Para la tabla
        System.out.println("Estudiantes | T. Prom. | T. Prom. Opt. | T. Eval. | T. Eval. Opt. | T. Varianza | T. Máximo");

        for (int i = 1; i <= 100; i++) {
            int cantEstudiantes = 100 * i;

            // Instancia de la clase AnalizadorDeNotas para cada tamaño de matriz
            AnalizadorDeNotas analizador = new AnalizadorDeNotas(cantEstudiantes, cantEvaluacionesFijas);

            // Mide el tiempo de calcularPromediosEstudiantes()
            long tiempoInicio1 = System.nanoTime();
            analizador.calcularPromediosEstudiantes();
            long tiempoFin1 = System.nanoTime();
            long duracion1 = tiempoFin1 - tiempoInicio1;

            // MMide el tiempo de calcularPromediosEstudiantesOptimizado()
            long tiempoInicio2 = System.nanoTime();
            analizador.calcularPromediosEstudiantesOptimizado();
            long tiempoFin2 = System.nanoTime();
            long duracion2 = tiempoFin2 - tiempoInicio2;

            //Mide el tiempo de calcularPromedioEvaluaciones()
            long tiempoInicio5 = System.nanoTime();
            analizador.calcularPromedioEvaluaciones(new String[0]); // El parámetro no afecta la medición del tiempo
            long tiempoFin5 = System.nanoTime();
            long duracion5 = tiempoFin5 - tiempoInicio5;

            // Mide el tiempo de calcularPromedioEvaluacionesOptimizado()
            long tiempoInicio6 = System.nanoTime();
            analizador.calcularPromedioEvaluacionesOptimizado();
            long tiempoFin6 = System.nanoTime();
            long duracion6 = tiempoFin6 - tiempoInicio6;

            // Mide el tiempo de calcularVarianzaEstudiantes()
            long tiempoInicio3 = System.nanoTime();
            analizador.calcularVarianzaEstudiantes();
            long tiempoFin3 = System.nanoTime();
            long duracion3 = tiempoFin3 - tiempoInicio3;

            // Mide el tiempo de encontrarMaximo()
            long tiempoInicio4 = System.nanoTime();
            analizador.encontrarMaximo(0);
            long tiempoFin4 = System.nanoTime();
            long duracion4 = tiempoFin4 - tiempoInicio4;

            // Imprime los resultados
            System.out.println(cantEstudiantes + " | " + duracion1 + " | " + duracion2 + " | " + duracion5 + " | " + duracion6 + " | " + duracion3 + " | " + duracion4);
        }
    }
}