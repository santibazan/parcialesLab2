package entities;

import javax.persistence.*;

@Entity
@Table(name = "articulo_insumo")

public class ArticuloInsumo extends Articulo {

    @Column(name = "precio_compra")
    private double precioCompra;

    @Column(name = "stock_actual")
    private int stockActual;

    @Column(name = "stock_maximo")
    private int stockMaximo;

    @Column(name="es_para_elaborar")
    private boolean esParaElaborar;

    public ArticuloInsumo() {

    }

    public ArticuloInsumo(String denominacion, double precioVenta, double precioCompra, int stockActual, int stockMaximo, boolean esParaElaborar) {
        super(denominacion, precioVenta);
        this.precioCompra = precioCompra;
        this.stockActual = stockActual;
        this.stockMaximo = stockMaximo;
        this.esParaElaborar = esParaElaborar;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public boolean EsParaElaborar() {
        return esParaElaborar;
    }

    public void setEsParaElaborar(boolean esParaElaborar) {
        this.esParaElaborar = esParaElaborar;
    }
}

