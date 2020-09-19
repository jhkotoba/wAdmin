package com.wAdmin.wcommon;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class WCommonConrtroller {
	
	@Autowired
	WCommonService wCommonService;	
	
	@GetMapping(value = "/api/admin/getMenuCodeList", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<? extends Map<String, Object>> getMenuCodeList(ServerHttpRequest request){		
		return wCommonService.getMenuCodeList(request);
	}
	
	@GetMapping(value = "/api/admin/getPageCodeList", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<? extends Map<String, Object>> getPageCodeList(ServerHttpRequest request){		
		return wCommonService.getPageCodeList(request);
	}

}
