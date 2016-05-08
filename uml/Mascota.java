import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Mascota {
    
    private int codigo;

    
    private String alias;

    
    private String especie;

    
    private String raza;

    
    private String colorPelo;

    
    private Date fechanacimiento;

    
    private float pesoMedio;

    
    private float[] pesoActual = new float[10];

    
    public List<Historial> historial = new ArrayList<Historial> ();

    
    public List<Calendario> calendario = new ArrayList<Calendario> ();

    
    public int getCodigo() {
    }

    
    public void setCodigo(int codigo) {
    }

    
    public String getAlias() {
    }

    
    public void setAlias(String alias) {
    }

    
    public String getEspecie() {
    }

    
    public void setEspecie(String especie) {
    }

    
    public String getRaza() {
    }

    
    public void setRaza(String raza) {
    }

    
    public String getColorPelo() {
    }

    
    public void setColorPelo(String color) {
    }

    
    public Date getFechaNacimiento() {
    }

    
    public void setFechaNacimiento(Date fecha) {
    }

    
    public float getPesoActual() {
    }

    
    public float getPesoMedio() {
    }

    
    public void addPeso(float peso) {
    }

}
