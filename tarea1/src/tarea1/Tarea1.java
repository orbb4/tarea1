package tarea1;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;


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
        return "Nombre: " + nombre + "\nRut: " + rut + "\nDireccion: " + ubicacion+"\n";
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
    public String toString(){
        return direccion + "\n";
    }
}
class OrdenCompra{
    private Cliente cliente;
    private String estado;
    private Date fecha;
    private ArrayList<DetalleOrden> detalleOrdenes = new ArrayList();
    private ArrayList<Pago> pagos = new ArrayList();
    private DocTributario documento;
    public OrdenCompra(String estado, Date fecha, ArrayList<DetalleOrden> detalleOrdenes, DocTributario documento, Cliente cliente, ArrayList<Pago> pagos){
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
    public DocTributario getDoc(){
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
    public void setDocumento(DocTributario documento){
        this.documento=documento;
    }
    
    public String toString(){
        String strorden = "";
        for(DetalleOrden a: detalleOrdenes){
            strorden+=a.toString();
        }
        String strpagos = "";
        for(Pago a: pagos){
            strpagos+=a.toString();
        }
        return "Cliente:\n" + cliente + "\nEstado: " + estado + "\nFecha: " + fecha + "\nOrdenes:\n" + strorden + "\nPagos:\n" + strpagos + "\nDocumento:\n" + documento + "\n";
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
        return "Numero: " + numero + "\nRut: " + rut + "\nFecha: " + fecha+"\n" + "Direccion: " + direccion + "\n";
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
        return super.toString() + "\nBanco: " + banco + "\nNumero de Cuenta: " + numCuenta + "\n";
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
        return super.toString() + "\nTipo: " + tipo + "\nNumero de Transacción " + numTransaccion + "\n";
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
        return "Nombre: " + getNombre() + "\nPrecio: " + getPrecio() + "\nDescripcion: " + getDescripcion() + "\n Peso: "+ getPeso() + "\n";
    }
    

}

public class Tarea1 {


    public static void main(String[] args) {
        Direccion calle1 = new Direccion("4 Poniente 3711 El Pinar, San Joaquin");
        Cliente b = new Cliente("Luciano Esteban Garrido Sepulveda", "17.546.876-3", calle1);
        Articulo arroz = new Articulo(1000, "Arroz", "Arroz Miraflores Grado 1", 1899);
        System.out.println(arroz.toString());
        Articulo lentejas = new Articulo(1000, "Lentejas", "Deliciosas Lentejas bolsa 4 mm 1 kg", 3119);
        System.out.println(lentejas.toString());
        Articulo spaguetti = new Articulo(400, "Spaguetti", "Ricos Spaghettis Carozzi n° 5.", 1079);
        System.out.println(spaguetti.toString());
        Cliente c = new Cliente("Juan Luis Lara Lara", "9.708.843-8", calle1);
        Articulo gallSal = new Articulo(187, "Galletas Saladas", "Sabor original - Formato individual", 700);
        System.out.println(gallSal.toString());
        Articulo chocolate = new Articulo(200, "Chocolate Amargo", "Con un 70% de cacao", 1700);
        System.out.println(chocolate.toString());
        
        DetalleOrden det1 = new DetalleOrden(1, chocolate);
        System.out.println(det1.toString());
        DetalleOrden det2 = new DetalleOrden(3, arroz);
        System.out.println(det2.toString());
        DetalleOrden det3 = new DetalleOrden(3, spaguetti);
        System.out.println(det3.toString());
        DetalleOrden det4 = new DetalleOrden(1, lentejas);
        System.out.println(det4.toString());
        DetalleOrden det5 = new DetalleOrden(2, gallSal);
        System.out.println(det5.toString());
        
        DetalleOrden orden1 = new DetalleOrden(5, lentejas);
        System.out.println(orden1.toString());
        DetalleOrden orden2 = new DetalleOrden(12, arroz);
        System.out.println(orden2.toString());
        
        DetalleOrden det6 = new DetalleOrden(25, gallSal);
        System.out.println(det6.toString());
        
        Calendar calendario = Calendar.getInstance();
        calendario.set(2022, 8,1);
        Date f1 = new Date(calendario.getTimeInMillis());
        
        calendario.set(2022, 9, 1);
        Date f2 = new Date(calendario.getTimeInMillis());
        
        calendario.set(2022, 8, 2);
        Date f3 = new Date(calendario.getTimeInMillis());
        Efectivo efec = new Efectivo(17500, f3);
        Tarjeta tar = new Tarjeta("crédito", "9430034", 4985, f1);
        Transferencia tran = new Transferencia(4985, f2, "Santander", "9431100");
        ArrayList<DetalleOrden> detalles = new ArrayList();
        ArrayList<DetalleOrden> detalles2 = new ArrayList();
        detalles2.add(det6);
        Collections.addAll(detalles, det1, det2, det3, det4, det5);
        ArrayList<Pago> pagos = new ArrayList();
        ArrayList<Pago> pagos2 = new ArrayList();
        pagos2.add(efec);
        Collections.addAll(pagos, tar, tran);
        DocTributario doc1 = new DocTributario("8881329", c.getRut(), f1, c.getUbicacion());
        DocTributario doc2 = new DocTributario("8881999", c.getRut(), f3, c.getUbicacion());
        OrdenCompra compra = new OrdenCompra("no pagado", f1, detalles, doc1, c, pagos);
        OrdenCompra compra2 = new OrdenCompra("pagado", f3, detalles2, doc2, c, pagos2);
        
        Calendar calendario1 = Calendar.getInstance();
        calendario1.set(2022, 5,23);
        Date fecha1 = new Date(calendario1.getTimeInMillis());
        
        Calendar calendario2 = Calendar.getInstance();
        calendario2.set(2022, 9, 14);
        Date fecha2 = new Date(calendario2.getTimeInMillis());
        
        Transferencia pago1 = new Transferencia(10000, fecha1, "BancoEstado", "0023475834");
        Efectivo pago2 = new Efectivo(12000, fecha2);
        
        ArrayList<DetalleOrden> detorden1 = new ArrayList();
        detorden1.add(orden1);
        detorden1.add(orden2);
        
        DocTributario doc3 = new DocTributario("27392790786", b.getRut(), fecha1, calle1);
        
        ArrayList<Pago> pagos3 = new ArrayList();
        pagos3.add(pago1);
        pagos3.add(pago2);
        
        OrdenCompra comp1 = new OrdenCompra("No pagado", fecha1, detorden1, doc3, b, pagos3);
        System.out.println(comp1.toString());
        System.out.println(compra.toString());
        System.out.println(compra2.toString());
  
    }
    
}
