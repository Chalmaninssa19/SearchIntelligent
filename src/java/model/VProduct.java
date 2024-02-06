/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author chalman
 */
@DBTable(name = "v_product_categorie", sequenceName = "")
public class VProduct {
    @DBField(name="id_product")
    private int idProduct;
    
    @DBField(name="product")
    private String product;
    
     @DBField(name="id_categorie")
    private Integer idCategorie;
     
    @DBField(name="categorie")
    private String categorie;
    
    @DBField(name="prix")
    private Double prix;
    
    @DBField(name="qualite")
    private Double qualite;
    
    @DBField(name="status")
    private Double status;
    
///getters et setters

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Double getQualite() {
        return qualite;
    }

    public void setQualite(Double qualite) {
        this.qualite = qualite;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    
///Constructors

    public VProduct() {
    }

    public VProduct(int idProduct, String product, Integer idCategorie, String categorie, Double prix, Double qualite, Double status) {
        this.idProduct = idProduct;
        this.product = product;
        this.idCategorie = idCategorie;
        this.categorie = categorie;
        this.prix = prix;
        this.qualite = qualite;
        this.status = status;
    }
}
