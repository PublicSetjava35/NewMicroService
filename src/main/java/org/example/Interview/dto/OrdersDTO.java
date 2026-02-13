package org.example.Interview.dto;

public class OrdersDTO {
   private String itemName;
   private Integer id;

   public OrdersDTO(Integer id, String itemName) {
       this.itemName = itemName;
       this.id = id;
   }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}