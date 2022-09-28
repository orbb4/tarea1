// testing. si este mensaje se ve en la rama maestra, quizá algo esté mal
package tarea1;
import java.util.Date;


class Cliente{
    private String nombre;
    private String rut;
    public Cliente(){}
    
}
class Direccion{
    public Direccion(){}
}
class OrdenCompra{
    private String estado;
    private Date fecha;
    public OrdenCompra(){}
    public float calcPrecioSinIVA(){}
    public float calcIVA(){}
    public float calPrecio(){}
    public float calcPeso(){}
}
class docTributario{
    private String numero;
    private String rut;
    private Date fecha;
    public docTributario(String numero, String rut, Date fecha){
        this.numero=numero;
        this.rut=rut;
        this.fecha=fecha;
    }
    public String getNumero(){
        return this.numero;
    }
    public String getRut(){
        return this.rut;
    }
    public Date getFecha(){
        return this.fecha;
    }
}

class Boleta extends docTributario{
    public Boleta(String numero, String rut, Date fecha){
        super(numero, rut, fecha);
    }
}
class Factura extends docTributario{
    public Factura(String numero, String rut, Date fecha){
        super(numero, rut, fecha);
    }
}
class Pago{
    private float monto;
    private Date fecha;
}
class DetalleOrden{
    public DetalleOrden(){}
}
class Articulo{
    public Articulo(){}

}

public class Tarea1 {

    
    public static void main(String[] args) {
        
    }
    
}
