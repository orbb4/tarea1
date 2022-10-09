package tarea1;
import java.util.Date;
import java.util.ArrayList;


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
    private ArrayList<DocTributario> docTributarios = new ArrayList();
    private ArrayList<Cliente> clientes = new ArrayList();
    public Direccion(String direccion, ArrayList<DocTributario> docTributarios, ArrayList<Cliente> clientes){
        this.direccion=direccion;
        this.docTributarios=docTributarios;
        this.clientes=clientes;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public ArrayList<DocTributario> getDocTributarios(){
        return docTributarios;
    }
    public void setDoctributarios(ArrayList<DocTributario> newDocTributarios){
        docTributarios=newDocTributarios;
    }
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> newClientes){
        clientes=newClientes;
    }
    public String toString(){
        String strdocTributario = " ";
        for(DocTributario a: docTributarios){
            strdocTributario+=a.toString();
        }
        String strcliente = " ";
        for(Cliente a: clientes){
            strcliente+=a.toString();
        }
        return " Dirección: " + direccion + "\nDocumentos tributarios: " + strdocTributario + "\nClientes: " + strcliente+"\n";
    }
}
class OrdenCompra{
    private Cliente cliente;
    private String estado;
    private Date fecha;
    private ArrayList<DetalleOrden> detalleOrdenes = new ArrayList();
    private ArrayList<Pago> pagos = new ArrayList();
    private ArrayList<DocTributario> documento;
    public OrdenCompra(String estado, Date fecha, ArrayList<DetalleOrden> detalleOrdenes, ArrayList<DocTributario> documento, Cliente cliente, ArrayList<Pago> pagos){
        this.estado = estado;
        this.fecha = fecha;
        this.detalleOrdenes = detalleOrdenes;
        this.documento = documento; 
        this.cliente=cliente;
        this.pagos=pagos;
    }
    public float getVuelto(){
        float total = 0;
        for(Pago p: pagos){
            total += p.getMonto();
        }
        return total;
    }

    public float calcPrecioSinIVA(){
        float precioTotalSinIva=0;
        for(DetalleOrden a: detalleOrdenes){
            precioTotalSinIva+= a.calcPrecioSinIVA();
        }
        return precioTotalSinIva;
    }
    public float calcIVA(){
        float totalIva=0;
        for(DetalleOrden a: detalleOrdenes){
        totalIva+= a.calcIVA();
        }
        return totalIva;
    }
    public float calPrecio(){
       float precioTotal=0;
       for(DetalleOrden a: detalleOrdenes){
        precioTotal+= a.calcPrecio();
        }
       return precioTotal;
    }
    public float calcPeso(){
        float totalPeso=0;
        for(DetalleOrden a: detalleOrdenes){
        totalPeso+= a.calcPeso();
        }
        return totalPeso;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public String getEstado(){
        return estado;
    }
    public ArrayList<DocTributario> getDoc(){
        return documento;
    }
    public Date getFecha(){
        return fecha;
    }
    public ArrayList<DetalleOrden> getDetalleOrdenes(){
        return detalleOrdenes;
    }
    public void setCliente(Cliente newCliente){
        cliente=newCliente;
    }
    public void setEstado(String newEstado){
        estado=newEstado;
    }
    public void setFecha(Date newFecha){
        fecha=newFecha;
    }
    public void setDetalleOrdenes(ArrayList<DetalleOrden> newDetalleOrdenes){
        detalleOrdenes=newDetalleOrdenes;
    }
    
    public String toString(){
        String strorden = " ";
        for(DetalleOrden a: detalleOrdenes){
            strorden+=a.toString();
        }
        String strpagos = " ";
        for(Pago a: pagos){
            strpagos+=a.toString();
        }
        String strdocumento = " ";
        for(DocTributario a: documento){
            strdocumento+=a.toString();
        }
        return " Cliente: " + cliente + " Estado: " + estado + "\nFecha: " + fecha + "\nOrdenes: " + strorden + "\nPagos: " + strpagos + "\nDocumentos: " + strdocumento;
    }
}
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    private Direccion direccion;
    public DocTributario(String numero, String rut, Date fecha, Direccion direccion){
        this.numero=numero;
        this.rut=rut;
        this.fecha=fecha;
        this.direccion = direccion;
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
    public Direccion getDireccion(){
        return direccion;
    }
    
    public void setNumero(String newNumero){
        this.numero=newNumero;
    }
    public void setDireccion(Direccion dir){
        direccion = dir;
    }
    public void setRut(String newRut){
        this.rut=newRut;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public String toString(){
        return " Número: " + numero + "\nRut: " + rut + "\nFecha: " + fecha+"\n" + "Direccion: " + direccion + "\n";
    }

}

class Boleta extends DocTributario{
    public Boleta(String numero, String rut, Date fecha, Direccion direccion){
        super(numero, rut, fecha, direccion);
    }
    public String toString(){
        return super.toString();
    }
}
class Factura extends DocTributario{
    public Factura(String numero, String rut, Date fecha, Direccion direccion){
        super(numero, rut, fecha, direccion);
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
    

    public String toString() {
        return "Monto: " + monto + "\nFecha: " + fecha + "\n";
    }
    
}

class Efectivo extends Pago{
    public Efectivo(float monto, Date fecha){
        super(monto, fecha);
    }
    public String toString(){
        return super.toString();
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
    public Tarjeta(String tipo, String numTransaccion, float monto, Date fecha){
        super(monto,fecha);
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
    // uso de un array de Articulo para obtener precios y peso total de la orden
    private Articulo arti;
    private int cantidad;
    public DetalleOrden(int cantidad, Articulo arti){
        this.arti = arti;
        this.cantidad = cantidad;
    }

    public float calcIVA(){
        float iva = cantidad*arti.getPrecio()*(float)0.19;
        return iva;
    }
    public float calcPeso(){
        float pesoTotal = cantidad*arti.getPeso();    
        return pesoTotal;
    }
    public void setCantidad(int num){
        cantidad = num;
    }
    public void setArticulos(Articulo newArticulo){
        arti = newArticulo;
    }

    public String toString(){
        return "Articulo: " + arti.getNombre() + ", cantidad: " + cantidad + "\n";
    }   
    
    public float calcPrecio(){
        float sumaPrecios=arti.getPrecio()*cantidad*(float)1.19;
        return sumaPrecios;
    }
    public float calcPrecioSinIVA(){
        float sumaPreciosSinIVA=0;
        sumaPreciosSinIVA = arti.getPrecio()*cantidad;
        return sumaPreciosSinIVA;
    }

    public float getCantidad(){
        return cantidad;
    }
    public Articulo getArticulo(){
        return arti;
    }

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
