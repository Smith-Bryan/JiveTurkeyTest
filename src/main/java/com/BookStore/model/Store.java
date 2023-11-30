package com.BookStore.model;

import javax.persistence.*;

@Entity
@Table
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String storeName;

    @Column
    private String storeOwner;

    public Store(){

    }

    public Store(Long id, String storeName, String storeOwner) {
        this.id = id;
        this.storeName = storeName;
        this.storeOwner = storeOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }


}
