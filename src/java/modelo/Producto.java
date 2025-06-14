/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author NANA
 */
public class Producto {
    private int id;
    private String nombre;
    private int cantidadDisponible; 
    private double precio;
    private int capacidadAlmacenamiento; 
    private int ram; 
    private int memoriaGpu;
    private String modelo;
    private int nucleosCpu;
    private int nucleosGpu;
    private String arquitectura;
    private String descripcion;
    private int marcaId; 
    private int tipoId; 
    private String imagen;

    public Producto() {

    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCapacidadAlmacenamiento() { return capacidadAlmacenamiento; }
    public void setCapacidadAlmacenamiento(int capacidadAlmacenamiento) { this.capacidadAlmacenamiento = capacidadAlmacenamiento; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public int getMemoriaGpu() { return memoriaGpu; }
    public void setMemoriaGpu(int memoriaGpu) { this.memoriaGpu = memoriaGpu; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getNucleosCpu() { return nucleosCpu; }
    public void setNucleosCpu(int nucleosCpu) { this.nucleosCpu = nucleosCpu; }

    public int getNucleosGpu() { return nucleosGpu; }
    public void setNucleosGpu(int nucleosGpu) { this.nucleosGpu = nucleosGpu; }

    public String getArquitectura() { return arquitectura; }
    public void setArquitectura(String arquitectura) { this.arquitectura = arquitectura; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getMarcaId() { return marcaId; }
    public void setMarcaId(int marcaId) { this.marcaId = marcaId; }

    public int getTipoId() { return tipoId; }
    public void setTipoId(int tipoId) { this.tipoId = tipoId; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
}