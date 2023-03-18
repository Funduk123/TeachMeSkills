package org.tms.dependencyLookup;

import org.tms.dependencyLookup.service.CarService;

import java.util.Optional;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        ServiceLoader loader = ServiceLoader.load(CarService.class);
        Optional first = loader.findFirst();

        if (first.isPresent()) {
            CarService o = (CarService) first.get();
            o.process();
        }

    }
}
