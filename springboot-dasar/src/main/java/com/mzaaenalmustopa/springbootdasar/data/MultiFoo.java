package com.mzaaenalmustopa.springbootdasar.data;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;

import java.util.List;

public class MultiFoo {

    @Getter
    private List<Foo> foos;

    public MultiFoo(ObjectProvider<Foo> objectProvider) {
        foos = objectProvider.stream().toList();
    }
}
