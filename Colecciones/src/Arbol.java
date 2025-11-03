public class Arbol {
    private String especie;
    private int anioPlantacion;
    static int nroArboles = 0;
    public Arbol(String especie, int anioPlantacion) {
        this.especie = especie;
        this.anioPlantacion = anioPlantacion;
    }
    public String getEspecie() {
        return especie;
    }
    public int getAnioPlantacion() {
        return anioPlantacion;
    }
    
    public String toString() {
        return "Arbol [especie=" + especie + ", anioPlantacion=" + anioPlantacion + "]";
    }
    
    

}
