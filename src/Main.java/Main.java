

import modelos.*;
import operaciones.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OperacionEmpresa opEmpresa = new OperacionEmpresa();
        OperacionEmpleado opEmpleado = new OperacionEmpleado();

        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar Empresa");
            System.out.println("2. Listar Empresas");
            System.out.println("3. Agregar Empleado");
            System.out.println("4. Listar Empleados");
            System.out.println("5. Buscar Empleado Por Documento");
            System.out.println("6. Calcular Sueldo Empleado");
            System.out.println("7. Contar Empleados Por Empresa");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                     System.out.print("Nit: ");
                     String nit = scanner.nextLine();
                     System.out.print("Nombre: ");
                     String nombreE = scanner.nextLine();
                     System.out.print("Direccion: ");
                     String direccion = scanner.nextLine();
                     System.out.print("Ciudad: ");
                     String ciudad = scanner.nextLine();

                     Empresa empresa = new Empresa(nit,nombreE, direccion, ciudad);
                     opEmpresa.agregarEmpresa(empresa);
                     System.out.println("Empresa agregada.");
                     break;

                case 2:
                    List<Empresa> empresas = opEmpresa.listarEmpresas();
                    for (Empresa e : empresas) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.print("Documento empleado: ");
                    String doc = scanner.nextLine();
                    System.out.print("Nombre empleado: ");
                    String nombreEmp = scanner.nextLine();
                    System.out.print("Sueldo por hora: ");
                    double sueldoHora = Double.parseDouble(scanner.nextLine());

                    System.out.print("Area (solo para GestorProyectos, dejar vacio para Desarrollar o Admin): ");
                    String area = scanner.nextLine();

                    System.out.print("Nit de la empresa donde trabaja: ");
                    String nitempresa = scanner.nextLine();

                    Empresa empAsignada = opEmpresa.buscarEmpresaPorNit(nitempresa);
                    if (empAsignada == null) {
                        System.out.println("Empresa no encontrada.");
                        break;
                    }

                    Empleado empleadoNuevo;
                    if  (!area.isEmpty()) {
                        empleadoNuevo = new GestorProyectos(doc, nombreEmp, sueldoHora, empAsignada, area); 
                    } else {
                        //puedes decidir si es Admin o Desarrollador, por ejemplo:
                        System.out.print("Tipo empleado (1=Desarrollador, 2=Admin): ");
                        int tipo = Integer.parseInt(scanner.nextLine());
                        if (tipo == 1) {
                            empleadoNuevo = new Desarrollador(doc, nombreEmp, sueldoHora, empAsignada);
                        } else {
                            empleadoNuevo = new Admin(doc, nombreEmp, sueldoHora, empAsignada);
                        }
                    }
                    opEmpleado.agregarEmpleado(empleadoNuevo);
                    System.out.println("Empleado agregado.");
                    break;

                case 4:
                     List<Empleado> empleados = opEmpleado.listarEmpleados(); 
                     for (Empleado e : empleados) {
                        System.out.println(e);
                     }
                     break;

                case 5:
                    System.out.print("Documento a buscar: ");
                    String docBuscar = scanner.nextLine();
                    Empleado eEncontrado = opEmpleado.buscarEmpleadoPorDocumento(docBuscar);
                    if (eEncontrado != null) {
                        System.out.println(eEncontrado);
                    }     
                    break;
                
                case 6:
                System.out.print("Documento del empleado: ");
                String docCalcular = scanner.nextLine();
                System.out.print("Horas trabajadas: ");
                int horas = Integer.parseInt(scanner.nextLine());
                double sueldo = opEmpleado.calcularSueldoEmpleado(docCalcular, horas);
                if (sueldo > 0) {
                    System.out.println("Sueldo calculado: " + sueldo);
                } else {
                    System.out.println("Empleado no encontrado o sueldo 0.");
                }
                break;

            case 7:
                System.out.print("Nit empresa: ");
                String nitContar = scanner.nextLine();
                Empresa empContar = opEmpresa.buscarEmpresaPorNit(nitContar);
                if (empContar != null) {
                    int cantidad = opEmpleado.contarEmpleadosPorEmpresa(empContar);
                    System.out.println("Cantidad de empleados en empresa " + empContar.getNombre() + ": "+ cantidad);
                } else {
                    System.out.println("Empresa no encontrada.");
                }
                break;

            case 8:
                salir = true;
                System.out.println("Saliendo...");    
                break;

            default:
                System.out.println("Opcion invalida.");    
            }
       }

       scanner.close();
    }

    private static class OperacionEmpleado {

        public OperacionEmpleado() {
        }
    }

    private static class OperacionEmpresa {

        public OperacionEmpresa() {
        }
    }

    private static class Empresa {

        public Empresa() {
        }

        public Empresa(String nit, String nombreE, String direccion, String ciudad) {
            //TODO Auto-generated constructor stub
        }
    }
}
