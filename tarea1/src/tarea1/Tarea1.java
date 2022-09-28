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
// ToDo: terminar toString()
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
    
    @Override
    public String toString() {
        return "Monto: " + monto + "\nFecha: " + fecha + "\n";
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
    public String toString(){
        return super.toString() + "\nMonto recibido: " + dineroEntregado + "\nVuelto: " + calcDevolucion();
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
    public String toString(){
        return super.toString() + "\nBanco: " + banco + "\nNúmero de Cuenta: " + numCuenta + "\n";
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
    public String toString(){
        return super.toString() + "\nTipo: " + tipo + "\nNúmero de Transacción " + numTransaccion + "\n";
    }
}

class DetalleOrden{
    public DetalleOrden(){}
}
class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    public Articulo(float peso, String nombre, String descripcion, float precio){
        this.peso = peso;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    public float getPeso(){
        return peso;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public float getPrecio(){
        return precio;
    }
    public void setTipo(float newPeso){
        peso = newPeso;
    }
    public void setNombre(String newNombre){
        nombre = newNombre;
    }
    public void setDescripcion(String newDes){
        descripcion = newDes;
    }
    public void setPrecio(float newPrecio){
        precio = newPrecio;
    }

    public String toString() {
        return "nombre: " + getNombre() + "\nprecio: " + getPrecio() + "\ndescripcion: " + getDescripcion() + "\n peso: "+ getPeso() + "\n";
    }
    

}

public class Tarea1 {

    
    public static void main(String[] args) {
        
    }
    
}
