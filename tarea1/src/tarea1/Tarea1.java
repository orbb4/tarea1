package tarea1;
import java.util.Date;


class Cliente{
    private Direccion ubicacion;
    private String nombre;
    private String rut;
    public Cliente(String nombre, String rut, Direccion ubicacion){
        this.ubicacion=ubicacion;
        this.nombre=nombre;
        this.rut=rut;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public Direccion getUbicacion(){
        return ubicacion;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setRut(String rut){
        this.rut=rut;
    }
    public void setUbicacion(Direccion ubicacion){
        this.ubicacion=ubicacion;
    }
    public String toString(){
        return " Nombre: " + nombre + "\nRut: " + rut + "\nDirección: " + ubicacion+"\n";
    }
}

class Direccion{
    private String direccion;
    public Direccion(String direccion){
        this.direccion=direccion;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
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
        return numero;
    }
    public String getRut(){
        return rut;
    }
    public Date getFecha(){
        return fecha;
    }
    public void setNumero(String numero){
        this.numero=numero;
    }
    public void setRut(String rut){
        this.rut=rut;
    }
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    public String toString(){
        return " Número: " + numero + "\nRut: " + rut + "\nFecha: " + fecha+"\n";
    }
}

class Boleta extends docTributario{
    public Boleta(String numero, String rut, Date fecha){
        super(numero, rut, fecha);
    }
    public String toString(){
        return super.toString();
    }
}
class Factura extends docTributario{
    public Factura(String numero, String rut, Date fecha){
        super(numero, rut, fecha);
    }
    public String toString(){
        return super.toString();
    }
}
class Pago{
    private float monto;
    private Date fecha;
    public Pago(float monto, Date fecha){
        this.monto = monto;
        this.fecha = fecha;
    }
    public float getMonto(){
        return monto;
    }
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date newFecha){
        fecha = newFecha;
    }
    public void setMonto(float newMonto){
        monto = newMonto;
    }
    
}

class Efectivo extends Pago{
    private float dineroEntregado;
    public Efectivo(float monto, Date fecha, float dineroEntregado){
        super(monto, fecha);
        this.dineroEntregado = dineroEntregado;
    }
    public float calcDevolucion(){
        return getDineroEntregado() - getMonto(); 
    }
    public float getDineroEntregado(){
        return dineroEntregado;
    }
    public void setDineroEntregado(float num){
        dineroEntregado = num;
    }
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    public Transferencia(float monto, Date fecha, String banco, String numCuenta){
        super(monto, fecha);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }
    public String getBanco(){
        return banco;
    }
    public String getNumCuenta(){
        return numCuenta;
    }
    public void setBanco(String newBanco){
        banco = newBanco;
    }
    public void setNumCuenta(String num){
        numCuenta = num;
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    public Tarjeta(String tipo, String numTransaccion){
        this.numTransaccion = numTransaccion;
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }
    public String getNumTransaccion(){
        return numTransaccion;
    }
    public void setTipo(String newTipo){
        tipo = newTipo;
    }
    public void setNumTransaccion(String num){
        numTransaccion = num;
    }
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
