package Datos;

import Excepciones.ExcepcionErrorModificacion;
import Excepciones.ExcepionRegistroIncompleto;
import cajeroautomatico.Model.Model;

public interface ManejadorDeDatos {
        public void Registro(Model registro) throws ExcepionRegistroIncompleto;
        public void Modificar(Model registro) throws ExcepcionErrorModificacion;        
}
