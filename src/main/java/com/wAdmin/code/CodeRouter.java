package com.wAdmin.code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CodeRouter {

	@Bean
	public RouterFunction<ServerResponse> codeRoute(CodeHandler codeHandler){
		return RouterFunctions
			//메뉴코드 조회
			.route(RequestPredicates.GET("/api/admin/getMenuCodeList")
				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), codeHandler::getMenuCodeList)
			//공통코드 조회
			.andRoute(RequestPredicates.GET("/api/admin/getCodeList")
				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), codeHandler::getCodeList);
	}
}
