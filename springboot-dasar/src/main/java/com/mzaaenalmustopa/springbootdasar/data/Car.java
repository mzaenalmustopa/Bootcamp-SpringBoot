package com.mzaaenalmustopa.springbootdasar.data;

import com.mzaaenalmustopa.springbootdasar.aware.IdAware;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Car implements IdAware {

    @Getter
    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
