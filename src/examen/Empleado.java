package examen;

import java.util.ArrayList;

public class Empleado {
    private String nombre;
    private String DNI;
    private int numeroEmpleado;
    private double complejidadTrabajos;
    public String getNombre() {
		return nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	private double calidadTrabajos;
    private double proactividad;
    private double compañerismo;

    public Empleado(String nombre, String DNI, int numeroEmpleado) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.numeroEmpleado = numeroEmpleado;
        this.complejidadTrabajos = 0.0;
        this.calidadTrabajos = 0.0;
        this.proactividad = 0.0;
        this.compañerismo = 0.0;
    }

    public void setComplejidadTrabajos(double complejidadTrabajos) {
        if (complejidadTrabajos >= 0 && complejidadTrabajos <= 1) {
            this.complejidadTrabajos = complejidadTrabajos;
        } else {
            System.out.println("El valor de complejidad de trabajos debe estar entre 0 y 1.");
        }
    }

    public void setCalidadTrabajos(double calidadTrabajos) {
        if (calidadTrabajos >= 0 && calidadTrabajos <= 1) {
            this.calidadTrabajos = calidadTrabajos;
        } else {
            System.out.println("El valor de calidad de trabajos debe estar entre 0 y 1.");
        }
    }

    public void setProactividad(double proactividad) {
        if (proactividad >= 0 && proactividad <= 1) {
            this.proactividad = proactividad;
        } else {
            System.out.println("El valor de proactividad debe estar entre 0 y 1.");
        }
    }

    public void setCompañerismo(double compañerismo) {
        if (compañerismo >= 0 && compañerismo <= 1) {
            this.compañerismo = compañerismo;
        } else {
            System.out.println("El valor de compañerismo debe estar entre 0 y 1.");
        }
    }

    public double getComplejidadTrabajos() {
        return complejidadTrabajos;
    }

    public double getCalidadTrabajos() {
        return calidadTrabajos;
    }

    public double getProactividad() {
        return proactividad;
    }

    public double getCompañerismo() {
        return compañerismo;
    }

    public double calcularMedia() {
        return (complejidadTrabajos + calidadTrabajos + proactividad + compañerismo) / 4;
    }

    public static Empleado max(ArrayList<Empleado> empleados) {
        if (empleados.isEmpty()) {
            return null;
        }

        Empleado maxEmpleado = empleados.get(0);
        double maxMedia = maxEmpleado.calcularMedia();

        for (Empleado empleado : empleados) {
            double media = empleado.calcularMedia();
            if (media > maxMedia) {
                maxEmpleado = empleado;
                maxMedia = media;
            }
        }

        return maxEmpleado;
    }
}


