package Datos;

import Excepciones.ExcepcionErrorModificacion;
import Excepciones.ExcepionRegistroIncompleto;

public interface ManejadorDeDatos {
        public void Registro() throws ExcepionRegistroIncompleto;
        public void Modificar() throws ExcepcionErrorModificacion;
        
}
