public class superHeroe {

    String nombre;
    String nombreSuperh;
    String nombreReal;
    String ciudad;
    String franquicia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreSuperh() {
        return nombreSuperh;
    }

    public void setNombreSuperh(String nombreSuperh) {
        this.nombreSuperh = nombreSuperh;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    superHeroe(String nombre, String nombreSuperh, String nombreReal, String ciudad, String franquicia){
        this.nombre = nombre;
        this.nombreSuperh = nombreSuperh;
        this.nombreReal = nombreReal;
        this.ciudad = ciudad;
        this.franquicia = franquicia;
    }

    @Override
    public String toString() {
        return nombre+franquicia;
    }
}
