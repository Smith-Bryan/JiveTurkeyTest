package com.BookStore.service;

import com.BookStore.dto.BookNotFoundException;
import com.BookStore.dto.StoreNotFoundException;
import com.BookStore.model.Store;
import com.BookStore.model.Category;
import com.BookStore.model.Store;
import com.BookStore.repository.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;
    private final Logger logger = LoggerFactory.getLogger(StoreService.class);
    public Store createStore(Store store, Category categories){
        logger.info("Store Created");
        return storeRepository.save(store);
    }

    public Optional<Store> getById(Long storeId){
        logger.info("Store Front with id " + storeId + " Retrieved");
        return storeRepository.findById(storeId);
    }

    public Iterable<Store> returnAllStores(){

        logger.info("Stores retrieved! ");
        return storeRepository.findAll();
    }

    public Store editStore(Store store, Long storeId){
        logger.info("Store Updated");
        Optional<Store> existingStoreOptional = storeRepository.findById(storeId);
        if (!existingStoreOptional.isEmpty()){
            throw new StoreNotFoundException("Store with an id of " + storeId + "does NOT exist");
        }
        Store existingStore = existingStoreOptional.get();
        existingStore.setStoreName(store.getStoreName());
        existingStore.setStoreOwner(store.getStoreOwner());

        return storeRepository.save(existingStore);

    }

    public void bankrupt(Long storeId){
        logger.info("Store Removed Successfully");
//        logger.error("Store Removed already");
        storeRepository.deleteById(storeId);
    }

}
