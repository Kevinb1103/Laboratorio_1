import java.util.Random;
import java.lang.Math;

public class AnalizadorDeNotas{

    private double[][] notas;
    private String[] evaluaciones;
    private int[] rut;
    private int cantEstudiantes;
    private int cantEvaluaciones;
    private double [] promediosEstudiantes;
    private double [] promediosEvaluaciones;

    public AnalizadorDeNotas(int estudiantes, int evaluaciones) {
        this.cantEstudiantes = estudiantes;
        this.cantEvaluaciones = evaluaciones;
        this.notas = new double[estudiantes][evaluaciones];
        this.rut = new int[estudiantes];
        this.evaluaciones = new String[evaluaciones];

        for (int i = 0; i < estudiantes; i++) {
            rut[i] = 1000 + i;
        }

        for (int j = 0; j < evaluaciones; j++) {
            this.evaluaciones[j] = "Evaluacion" + (j + 1);
        }

        generarNotasAleatorias();
        calcularYAlmacenarPromedios();
    }

    public AnalizadorDeNotas(int estudiantes, int evaluaciones, String[] nombresEvaluaciones) {
        this(estudiantes, evaluaciones);
        if (nombresEvaluaciones.length == evaluaciones) {
            this.evaluaciones = nombresEvaluaciones;
        }
    }

    private void generarNotasAleatorias() {
        Random rand = new Random();
        for (int i = 0; i < cantEstudiantes; i++) {
            for (int j = 0; j < cantEvaluaciones; j++) {
                notas[i][j] = 1.0 + (rand.nextDouble() * 6.0);
            }
        }
    }

    public double calcularPromedioEstudiante(int numEstudiante) {
        double suma = 0;
        for (int j = 0; j < cantEvaluaciones; j++) {
            suma += notas[numEstudiante][j];
        }
        return suma / cantEvaluaciones;
    }
    private void calcularYAlmacenarPromedios() {
        this.promediosEstudiantes = new double[cantEstudiantes];
        this.promediosEvaluaciones = new double[cantEvaluaciones];

        for(int i = 0; i < cantEstudiantes; i++) {
            promediosEstudiantes[i] = calcularPromedioEstudiante(i);
        }
        for(int j = 0; j < cantEvaluaciones; j++) {
            promediosEvaluaciones[j] = calcularPromedioEvaluacion(j);
        }
    }

    public double[] calcularPromediosEstudiantesOptimizado() {
        return promediosEstudiantes;
    }

    public double[] calcularPromedioEvaluacionesOptimizado() {
        return promediosEvaluaciones;
    }

    public double calcularPromedioEvaluacion(int index) {
        double suma = 0;
        for (int i = 0; i < cantEstudiantes; i++) {
            suma += notas[i][index];
        }
        return suma / cantEstudiantes;
    }

    public double calcularVarianzaEvaluacion(int index) {
        double promedio = calcularPromedioEvaluacion(index);
        double suma = 0;
        for (int i = 0; i < cantEstudiantes; i++) {
            suma += Math.pow(notas[i][index] - promedio, 2);
        }
        return suma / cantEstudiantes;
    }

    public double[] calcularPromediosEstudiantes() {
        double[] promedios = new double[cantEstudiantes];
        for (int i = 0; i < cantEstudiantes; i++) {
            promedios[i] = calcularPromedioEstudiante(i);
        }
        return promedios;
    }

    public double[] calcularVarianzaEstudiantes() {
        double[] varianzas = new double[cantEstudiantes];
        for (int i = 0; i < cantEstudiantes; i++) {
            double promedio = calcularPromedioEstudiante(i);
            double suma = 0;
            for (int j = 0; j < cantEvaluaciones; j++) {
                suma += Math.pow(notas[i][j] - promedio, 2);
            }
            varianzas[i] = suma / cantEvaluaciones;
        }
        return varianzas;
    }

    public double[] calcularPromedioEvaluaciones(String[] evals) {
        double[] promedios = new double[cantEstudiantes];
        for (int i = 0; i < cantEstudiantes; i++) {
            double suma = 0;
            int count = 0;
            for (String eval : evals) {
                for (int j = 0; j < cantEvaluaciones; j++) {
                    if (evaluaciones[j].equals(eval)) {
                        suma += notas[i][j];
                        count++;
                    }
                }
            }
            if (count > 0) {
                promedios[i] = suma / count;
            } else {
                promedios[i] = 0;
            }
        }
        return promedios;
    }

    public String encontrarMaximo(int index) {
        double maxNota = notas[0][index];
        int pos = 0;
        for (int i = 1; i < cantEstudiantes; i++) {
            if (notas[i][index] > maxNota) {
                maxNota = notas[i][index];
                pos = i;
            }
        }
        return "Rut: " + rut[pos] + " | Nota: " + maxNota;
    }
}