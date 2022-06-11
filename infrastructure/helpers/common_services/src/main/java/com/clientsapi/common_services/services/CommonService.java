package com.clientsapi.common_services.services;

import java.util.Optional;

public interface CommonService<E> {

    Iterable<E> findAll();
    Optional<E> findById(Integer id);
    E save(E entity);
    boolean delete(Integer id);

}
