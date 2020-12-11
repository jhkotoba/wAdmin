package com.wAdmin.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wAdmin.common.Constant;
import com.wAdmin.common.ResponseModel;

import reactor.core.publisher.Mono;

@Component
public class CodeHandler {
	
	@Autowired
	private CodeService codeService;
	
	/**
	 * 메뉴코드 조회
	 * @param request
	 * @return
	 */
	public Mono<ServerResponse> getMenuCodeList(ServerRequest request){
		
		ResponseModel<List<?>> result = new ResponseModel<List<?>>();
		
		return codeService.getMenuCodeList(request).collectList()
			.flatMap(fm -> {
				//응답
				result.setData(fm);
				result.setResultCode(Constant.CODE_SUCCESS);
				return ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(BodyInserters.fromValue(result));
			//응답오류
			}).onErrorResume(error -> {
				result.setResultCode(error.getMessage());
				return ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue(result));
			});
	}
	
	/**
	 * 공통코드 조회
	 * @param request
	 * @return
	 */
	public Mono<ServerResponse> getCmmCodeList(ServerRequest request){
		
		ResponseModel<List<?>> result = new ResponseModel<List<?>>();
		
		return codeService.getCmmCodeList(request).collectList()
			.flatMap(fm -> {
				//응답
				result.setData(fm);
				result.setResultCode(Constant.CODE_SUCCESS);
				return ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(BodyInserters.fromValue(result));
			//응답오류
			}).onErrorResume(error -> {
				result.setResultCode(error.getMessage());
				return ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue(result));
			});
	}

}
