package com.arima.javareactaws.example.Impl;

import com.arima.javareactaws.example.DataService;
import org.springframework.stereotype.Component;

@Component
public class MySQLDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}
