package com.example.service;
import com.example.domain.StoreStatus;
import com.example.exception.UserException;
import com.example.modal.Store;
import com.example.modal.User;
import com.example.payload.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    StoreDTO createStore(StoreDTO storeDTO, User user);
    StoreDTO getStoreById(Long id) throws Exception;
    List<StoreDTO> getAllStores();
    Store getStoreByAdmin() throws UserException;
    StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception;
    void deleteStore(Long storeDTO) throws Exception;
    StoreDTO getStoreByEmployee() throws UserException;
    StoreDTO moderateStore(Long id , StoreStatus status) throws Exception;
}
