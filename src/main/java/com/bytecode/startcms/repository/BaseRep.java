package com.bytecode.startcms.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import java.util.List;

public interface BaseRep<T> {

    public boolean save(T object);
    public boolean update(T object);
    public List<T> findAll(Pageable pageable);
    public T findById(int Id);

}
