package operaciones;

import modelos.Empleado;
import modelos.Empresa;
import java.util.ArrayList;
import java.util.List;

public class OperacionEmpleado implements IOperacionEmpleado {
    private List<Empleado> empleados;

    public OperacionEmpleado() {
        this.empleados = new ArrayList<>();
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    @Override
    public Empleado buscarEmpleadoPorDocumento(String documento) {
        for (Empleado e : empleados) {
            if (e.getDocumento().equalsIgnoreCase(documento)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return empleados;
    }

    @Override
    public double calcularSueldoEmpleado(String documento, int horasTrabajadas) {
        Empleado e = buscarEmpleadoPorDocumento(documento);
        if (e != null) {
            return e.getSueldoHora() * horasTrabajadas;
        }
        return 0;
    }

    @Override
    public int contarEmpleadosPorEmpresa(Empresa empresa) {
        int contador = 0;
        for (Empleado e : empleados) {
            if (e.getEmpresa() != null && e.getEmpresa().getNit().equalsIgnoreCase(empresa.getNit())) {
                contador++;
            }
        }
        return contador;
    } 
}
