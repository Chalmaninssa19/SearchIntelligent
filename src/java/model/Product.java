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

@DBTable(name = "category", sequenceName = "seq_category")
public class Product {
    @DBField(name="id_product", isPrimaryKey = true)
    private int idProduct;
    
    @DBField(name="name")
    private String name;
    
    @DBField(name="id_categorie", isForeignKey = true)
    private Category categorie;
    
    @DBField(name="prix")
    private Double prix;
    
    @DBField(name="qualite")
    private Double qualite;
        
    @DBField(name="status")
    private Integer status;
    
///Getters et setters

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategorie() {
        return categorie;
    }

    public void setCategorie(Category categorie) {
        this.categorie = categorie;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getQualite() {
        return qualite;
    }

    public void setQualite(Double qualite) {
        this.qualite = qualite;
    }
    
///Constructors

    public Product() {
    }

    public Product(int idProduct, String name, Category categorie, Double prix, Double qualite, Integer status) {
        this.idProduct = idProduct;
        this.name = name;
        this.categorie = categorie;
        this.prix = prix;
        this.qualite = qualite;
        this.status = status;
    }

    public Product(String name, Category categorie, Double prix, Double qualite, Integer status) {
        this.name = name;
        this.categorie = categorie;
        this.prix = prix;
        this.qualite = qualite;
        this.status = status;
    }
}
