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
    protected int id;
    protected String tablaBD;
    protected String[] atributosBD;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // -Métodos
    public abstract String getInsertCommand();
    
    public abstract String getUpdateCommand();
    
    
}
