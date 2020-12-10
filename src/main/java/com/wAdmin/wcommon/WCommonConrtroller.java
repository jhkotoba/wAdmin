//package com.wAdmin.wcommon;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import reactor.core.publisher.Flux;
//
//@RestController
//public class WCommonConrtroller {
//	
//	@Autowired
//	private WCommonService wCommonService;	
//	
//	/**
//	 * 메뉴코드 조회 API
//	 * @param request
//	 * @return
//	 */
//	@GetMapping(value = "/api/admin/getMenuCodeList", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Flux<? extends Map<String, Object>> getMenuCodeList(ServerHttpRequest request){		
//		return wCommonService.getMenuCodeList(request);
//	}
//	
//	/**
//	 * 페이지코드 조회 API
//	 * @param request
//	 * @return
//	 */
//	@GetMapping(value = "/api/admin/getPageCodeList", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Flux<? extends Map<String, Object>> getPageCodeList(ServerHttpRequest request){		
//		return wCommonService.getPageCodeList(request);
//	}
//	
//	/**
//	 * 공통코드 조회 API
//	 * @param request
//	 * @return
//	 */
//	@GetMapping(value = "/api/admin/getCodeList", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Flux<? extends Map<String, Object>> getCodeList(ServerHttpRequest request){		
//		return wCommonService.getCodeList(request);
//	}
//
//}
