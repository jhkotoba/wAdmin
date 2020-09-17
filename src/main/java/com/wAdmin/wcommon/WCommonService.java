package com.wAdmin.wcommon;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class WCommonService {
	
	@Autowired
	private WCommonRepository wCommonRepository;
	
	public Flux<? extends Map<String, Object>> getMenuCodeList(ServerHttpRequest request){
		return wCommonRepository.selectMenuCodeList(request.getQueryParams());
		
	}
}
