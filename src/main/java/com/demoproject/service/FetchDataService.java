package com.demoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoproject.exception.MyCustomException;

@Service
public interface FetchDataService {

	List<?> getResults(String entity) throws MyCustomException;

}
