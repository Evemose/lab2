package org.projectparams.lab2.commons;

import java.util.Optional;

public interface BasicService<T> {
    Optional<T> findById(Long id);

    void save(T entity);
}
