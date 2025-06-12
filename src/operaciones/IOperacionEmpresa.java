package operaciones;

import java.util.List;
import modelos.Empresa;

public interface IOperacionEmpresa {
    void agregarEmpresa(Empresa empresa);
    Empresa buscarEmpresaPorNit(String nit);
    List<Empresa> listarEmpresas();
}
