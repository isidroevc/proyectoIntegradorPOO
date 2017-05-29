/**
 * Model.java
 *
 * Es la clase abstracta para todos los modelos, para facilitar el registro en base de datos
 * de cualquier entidad.
 *
 */
package cajeroautomatico.Model;

public abstract class Model {

    // -Atributos
    protected String tablaBD;
    protected String[] atributosBD;

    // -Métodos
    public abstract String getInsertCommand();
    
    public abstract String getUpdateCommand();
}
