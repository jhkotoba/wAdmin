//package com.wAdmin.wcommon;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Service;
//
//import reactor.core.publisher.Flux;
//
//@Service
//public class WCommonService {
//	
//	@Autowired
//	private WCommonRepository wCommonRepository;
//	
//	/**
//	 * 메뉴코드 조회 API
//	 * @param request
//	 * @return
//	 */
//	public Flux<? extends Map<String, Object>> getMenuCodeList(ServerHttpRequest request){
//		return wCommonRepository.selectMenuCodeList(request.getQueryParams());		
//	}
//	
//	/**
//	 * 페이지코드 조회 API
//	 * @param request
//	 * @return
//	 */
//	public Flux<? extends Map<String, Object>> getPageCodeList(ServerHttpRequest request){
//		return wCommonRepository.selectPageCodeList(request.getQueryParams());		
//	}
//	
//	/**
//	 * 공통코드 조회 API
//	 * @param request
//	 * @return
//	 */
//	public Flux<? extends Map<String, Object>> getCodeList(ServerHttpRequest request){
//		return wCommonRepository.selectCodeList(request.getQueryParams());		
//	}
//}
