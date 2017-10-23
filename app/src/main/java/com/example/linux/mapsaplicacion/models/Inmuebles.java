package com.example.linux.mapsaplicacion.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by linux on 21/10/17.
 */

public class Inmuebles {

    @SerializedName("area_construida")
    @Expose
    private String areaConstruida;
    @SerializedName("area_terreno")
    @Expose
    private String areaTerreno;
    @SerializedName("barrio")
    @Expose
    private String barrio;
    @SerializedName("ciudad")
    @Expose
    private String ciudad;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("departamento")
    @Expose
    private String departamento;
    @SerializedName("detalle_disponibilidad")
    @Expose
    private String detalleDisponibilidad;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("estrato")
    @Expose
    private String estrato;
    @SerializedName("precio")
    @Expose
    private String precio;
    @SerializedName("tipo_de_inmueble")
    @Expose
    private String tipoDeInmueble;
    @SerializedName("datos_adicionales")
    @Expose
    private String datosAdicionales;

    public String getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(String areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public String getAreaTerreno() {
        return areaTerreno;
    }

    public void setAreaTerreno(String areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDetalleDisponibilidad() {
        return detalleDisponibilidad;
    }

    public void setDetalleDisponibilidad(String detalleDisponibilidad) {
        this.detalleDisponibilidad = detalleDisponibilidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTipoDeInmueble() {
        return tipoDeInmueble;
    }

    public void setTipoDeInmueble(String tipoDeInmueble) {
        this.tipoDeInmueble = tipoDeInmueble;
    }

    public String getDatosAdicionales() {
        return datosAdicionales;
    }

    public void setDatosAdicionales(String datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }

}