package operaciones;

import java.util.ArrayList;
import java.util.List;
import modelos.Empresa;

public class OperacionEmpresa implements IOperacionEmpresa {
    private List<Empresa> empresas;

    public OperacionEmpresa() {
        this.empresas = new ArrayList<>();
    }

    @Override
    public void agregarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    @Override
    public Empresa buscarEmpresaPorNit(String nit) {
        for (Empresa e : empresas) {
            if (e.getNit().equalsIgnoreCase(nit)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Empresa> listarEmpresas() {
    return empresas;
 }
} 
    

