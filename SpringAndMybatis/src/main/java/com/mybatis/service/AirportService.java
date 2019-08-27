package com.mybatis.service;

import com.mybatis.pojo.Airport;

import java.io.IOException;
import java.util.List;

public interface AirportService {
    List<Airport> showTakePort() throws IOException;
}
