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
@DBTable(name = "key_word", sequenceName = "seq_key_word")
public class KeyWord {
    @DBField(name="id_key_word", isPrimaryKey = true)
    private int idKeyWord;
    
    @DBField(name="request")
    private String request;
      
    @DBField(name="key_value_normal")
    private String keyValueNormal;
    
    @DBField(name="key_value_prix")
    private String keyValuePrix;
    
///Getters et setters

    public int getIdKeyWord() {
        return idKeyWord;
    }

    public void setIdKeyWord(int idKeyWord) {
        this.idKeyWord = idKeyWord;
    }

    public String getKeyValueNormal() {
        return keyValueNormal;
    }

    public void setKeyValueNormal(String keyValueNormal) {
        this.keyValueNormal = keyValueNormal;
    }

    public String getKeyValuePrix() {
        return keyValuePrix;
    }

    public void setKeyValuePrix(String keyValuePrix) {
        this.keyValuePrix = keyValuePrix;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
    
///Constructors

    public KeyWord() {
    }

    public KeyWord(int idKeyWord, String request, String keyValueNormal, String keyValuePrix) {
        this.idKeyWord = idKeyWord;
        this.request = request;
        this.keyValueNormal = keyValueNormal;
        this.keyValuePrix = keyValuePrix;
    }

    public KeyWord(String request, String keyValueNormal, String keyValuePrix) {
        this.request = request;
        this.keyValueNormal = keyValueNormal;
        this.keyValuePrix = keyValuePrix;
    }
}
