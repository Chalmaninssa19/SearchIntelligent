/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import generalisation.GenericDAO.GenericDAO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chalman
 */
public class TraitKeyWord {
    public static String requestSql(String request) throws Exception {
        String sqlToTrait = TraitKeyWord.getRequestSynonym(request.toLowerCase());
        System.out.println("REQ = "+sqlToTrait);
        String [] keyWords = sqlToTrait.toLowerCase().split(" ");
        String categorie = "";
        String column = "";
        String keyWord = "";
        List<Category> categorys = (List<Category>)GenericDAO.getAll(Category.class, null, null);
        List<KeyWord> keyWordList = (List<KeyWord>)GenericDAO.getAll(KeyWord.class, null, null);
        Field [] fieldsProduct = new Product().getClass().getDeclaredFields();
        int countColumn = 0;
        String conditions = "";
        String top = "";

        for(int i = 0; i < keyWords.length; i++) {
            if(TraitKeyWord.isInListCategory(keyWords[i], categorys) != null) {
                if(categorie.equals("")) {
                    Category newCategory = TraitKeyWord.isInListCategory(keyWords[i], categorys);
                    categorie = "WHERE (id_categorie = "+newCategory.getIdCategory();
                } else {
                    Category newCategory = TraitKeyWord.isInListCategory(keyWords[i], categorys);
                    categorie = categorie+" OR id_categorie = "+newCategory.getIdCategory();
                }
            }
            if(TraitKeyWord.isInListKeyWord(keyWords[i], keyWordList) != null) {
                KeyWord newKeyWord = TraitKeyWord.isInListKeyWord(keyWords[i], keyWordList);
                if(sqlToTrait.toLowerCase().contains("rapport") || !sqlToTrait.toLowerCase().contains("prix")) {
                    keyWord = newKeyWord.getKeyValueNormal();
                } 
                else {
                    keyWord = newKeyWord.getKeyValuePrix();
                }
            }
            if(TraitKeyWord.isInListField(keyWords[i], fieldsProduct) != null) {
                column = TraitKeyWord.isInListField(keyWords[i], fieldsProduct);
                
                countColumn++;
            }
            if(keyWords[i].equals("ou")) {
                String col = keyWords[i+1];
                if(keyWords[i+3].toLowerCase().equals("egale")) {
                    String operator = TraitKeyWord.getOperator(keyWords[i+2]+" "+keyWords[i+3]);
                    String value = keyWords[i+4];
                    conditions = col+" "+operator+" "+value;
                    i = i+4;
                } 
                else if(keyWords[i+2].toLowerCase().equals("entre")) {
                    String operator = TraitKeyWord.getOperator(keyWords[i+2]);
                    String value = keyWords[i+3]+" AND "+keyWords[i+5];
                    conditions = col+" "+operator+" "+value;
                    i = i+5;
                }
                else {
                    String operator = TraitKeyWord.getOperator(keyWords[i+2]);
                    String value = keyWords[i+3];
                    conditions = col+" "+operator+" "+value;
                    i = i+3;
                }
            }
            if(keyWords[i].equals("top")) {
                top = "LIMIT "+keyWords[i+1];
                i = i+1;
            }
        }
        
        if(countColumn == 2 && sqlToTrait.toLowerCase().contains("rapport")) {
            column = "qualite / prix";
        }
        
        if(!conditions.equals("")) {
            if(categorie.equals("")) {
                conditions = " WHERE "+conditions;
            } else {
                conditions = " AND "+conditions;
            }
        }
       
        if(!categorie.equals("")) {
            categorie = categorie+")";
        }
        if(!categorie.equals("") && column.equals("")) {
            column = "qualite/prix";
        }
        String sql = "SELECT * FROM v_product_categorie "+categorie+" "+ conditions +" ORDER BY "+column+" "+keyWord+" "+top;
        if(sqlToTrait.toLowerCase().contains("all product")) {
            return "SELECT * FROM v_product_categorie";
        }
        return sql;
    }
  
    
  ///Fonctions de merde
  
  public static String requestTestSql(String request) throws Exception {
        String sqlToTrait = TraitKeyWord.getRequestSynonym(request.toLowerCase());
        System.out.println("REQ = "+sqlToTrait);
        String [] keyWords = sqlToTrait.toLowerCase().split(" ");
        List<String> categorie = new ArrayList<>();
        List<String> column = new ArrayList<>();
        List<String> keyWord = new ArrayList<>();
        List<Category> categorys = (List<Category>)GenericDAO.getAll(Category.class, null, null);
        List<KeyWord> keyWordList = (List<KeyWord>)GenericDAO.getAll(KeyWord.class, null, null);
        Field [] fieldsProduct = new Product().getClass().getDeclaredFields();
        int countColumn = 0;
        String conditions = "";

        for(int i = 0; i < keyWords.length; i++) {
            if(TraitKeyWord.isInListCategory(keyWords[i], categorys) != null) {
                if(categorie.size() == 0) {
                    Category newCategory = TraitKeyWord.isInListCategory(keyWords[i], categorys);
                    categorie.add("WHERE (id_categorie = "+newCategory.getIdCategory());
                } else {
                    Category newCategory = TraitKeyWord.isInListCategory(keyWords[i], categorys);
                    categorie.add("WHERE (id_categorie = "+newCategory.getIdCategory());
                }
            }
            if(TraitKeyWord.isInListKeyWord(keyWords[i], keyWordList) != null) {
                KeyWord newKeyWord = TraitKeyWord.isInListKeyWord(keyWords[i], keyWordList);
                if(sqlToTrait.toLowerCase().contains("rapport") || !sqlToTrait.toLowerCase().contains("prix")) {
                    keyWord.add(newKeyWord.getKeyValueNormal());
                } 
                else {
                    keyWord.add(newKeyWord.getKeyValuePrix());
                }
            }
            if(TraitKeyWord.isInListField(keyWords[i], fieldsProduct) != null) {
                column.add(TraitKeyWord.isInListField(keyWords[i], fieldsProduct));
                
                countColumn++;
            }
            if(keyWords[i].equals("ou")) {
                String col = keyWords[i+1];
                if(keyWords[i+3].toLowerCase().equals("egale")) {
                    String operator = TraitKeyWord.getOperator(keyWords[i+2]+" "+keyWords[i+3]);
                    String value = keyWords[i+4];
                    conditions = col+" "+operator+" "+value;
                    i = i+4;
                } 
                else if(keyWords[i+2].toLowerCase().equals("entre")) {
                    String operator = TraitKeyWord.getOperator(keyWords[i+2]);
                    String value = keyWords[i+3]+" AND "+keyWords[i+5];
                    conditions = col+" "+operator+" "+value;
                    i = i+5;
                }
                else {
                    String operator = TraitKeyWord.getOperator(keyWords[i+2]);
                    String value = keyWords[i+3];
                    conditions = col+" "+operator+" "+value;
                    i = i+3;
                }
            }
        }
        
        if(countColumn == 2 && sqlToTrait.toLowerCase().contains("rapport")) {
            column.set(0, "qualite / prix");
        }
        
        if(!conditions.equals("")) {
            if(categorie.equals("")) {
                conditions = " WHERE "+conditions;
            } else {
                conditions = " AND "+conditions;
            }
        }
       
        /*if(!categorie.equals("")) {
            categorie = categorie+")";
        }
        if(!categorie.equals("") && column.equals("")) {
            column = "qualite/prix";
        }*/
        String sql = "";
        for(int i = 0; i < categorie.size(); i++) {
            sql = sql+" (SELECT * FROM v_product_categorie "+categorie.get(i)+" ORDER BY "+column.get(i)+" "+keyWord.get(i)+")";
            if(categorie.size()>1) {
                sql = sql+" UNION";
            }
        }
        //String sql = "SELECT * FROM v_product_categorie "+categorie+" "+ conditions +" ORDER BY "+column+" "+keyWord;

        return sql;
    }
  
  //Est ce que dans liste des categories
  public static Category isInListCategory(String categorie, List<Category> categorys) {
        for(int i = 0; i < categorys.size(); i++) {
            if(categorys.get(i).getName().toLowerCase().equals(categorie)) {
                return categorys.get(i);
            }
        }
        
        return null;
  }
  
  //Est ce que dans la liste des mot cles
  public static KeyWord isInListKeyWord(String keyWord, List<KeyWord> keyWords) {
      for(int i = 0; i < keyWords.size(); i++) {
          if(keyWords.get(i).getRequest().toLowerCase().equals(keyWord)) {
              return keyWords.get(i);
          }
      }
      
      return null;
  }
  
  //Est ce que dans la liste des attributs
  public static String isInListField(String word, Field [] fields) throws Exception {
      for(int i = 0; i < fields.length; i++) {
          if(word.equals(fields[i].getName().toLowerCase())) {
                return fields[i].getName();
          }
      }
      
      return null;
  }
  
  //Les operateurs correspondant
  public static String getOperator(String word) throws Exception {
      if(word.equals("inferieur")) {
          return "<";
      }
      if(word.equals(("superieur"))) {
          return ">";
      }
      if(word.equals("inferieur egale")) {
          return "<=";
      }
      if(word.equals("superieur egale")) {
          return ">=";
      }
      if(word.equals("egale")) {
          return "=";
      }
      if(word.equals("entre")) {
          return "BETWEEN";
      }
      return null;
  }
  
  //Les 
  public static String getRequestSynonym(String request) {
      if((request.contains("moins cher") || request.contains("cher moins")) && (request.contains("rapport"))) {
          return request.replace("moins", "meilleur").replace("cher", "");
      }
      if((request.contains("tres cher") || request.contains("cher tres")) && (request.contains("rapport"))) {
          return request.replace("tres", "pire").replace("cher", "");
      }
      if((request.contains("plus cher") || request.contains("cher plus")) && (request.contains("rapport"))) {
          return request.replace("plus", "pire").replace("cher", "");
      }
      if(request.contains("moins cher") || request.contains("cher moins")) {
          return request.replace("moins", "meilleur").replace("cher", "prix");
      }
      if(request.contains("tres cher") || request.contains("cher tres")) {
            return request.replace("tres", "pire").replace("cher", "prix");
      }
    
      if(request.contains("plus cher") || request.contains("cher plus")) {
            return request.replace("plus", "pire").replace("cher", "prix");
      }
      
      return request;
  }
}
