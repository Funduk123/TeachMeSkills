package org.tms.dependencyLookup.impl;

import org.tms.dependencyLookup.service.CarService;

public class CarCacheServiceImpl implements CarService {
    @Override
    public void process() {
        System.out.println("Save to cache");
    }
}
