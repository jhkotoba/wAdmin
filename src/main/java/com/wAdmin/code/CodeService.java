package com.wAdmin.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.wAdmin.common.Constant;

import reactor.core.publisher.Flux;

@Component
public class CodeService {
	
	@Autowired
	private CodeRepository codeRepository;

	/**
	 * 메뉴코드 조회
	 * @param request	 
	 * @return
	 */
	public Flux<?> getMenuCodeList(ServerRequest request){
		try {
			return codeRepository.selectMenuCodeList(request.queryParams());
		}catch (Exception e) {
			return Flux.error(new RuntimeException(Constant.CODE_REPOSITORY_ERROR, e));
		}
	}
	
	/**
	 * 공통코드 조회
	 * @param request	 
	 * @return
	 */
	public Flux<?> getCmmCodeList(ServerRequest request){
		try {
			return codeRepository.selectCmmCodeList(request.queryParams());
		}catch (Exception e) {
			return Flux.error(new RuntimeException(Constant.CODE_REPOSITORY_ERROR, e));
		}
	}
}
