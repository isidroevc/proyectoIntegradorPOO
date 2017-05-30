package Datos;

import Excepciones.ExcepcionErrorModificacion;
import Excepciones.ExcepcionRegistroIncompleto;
import cajeroautomatico.Model.Model;

public interface ManejadorDeDatos {
        public void Registro(Model registro) throws ExcepcionRegistroIncompleto;
        public void Modificar(Model registro) throws ExcepcionErrorModificacion;        
}
