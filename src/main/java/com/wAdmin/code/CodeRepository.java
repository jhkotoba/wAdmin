package com.wAdmin.code;

import java.util.Objects;

import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import com.wAdmin.common.Utils;

import reactor.core.publisher.Flux;

@Repository
public class CodeRepository {
	
	private final DatabaseClient client;
	
	public CodeRepository(DatabaseClient databaseClient) {
		this.client = databaseClient;
	}
	
	/**
	 * 메뉴코드 조회
	 * @param params	
	 * @return
	 */
	public Flux<?> selectMenuCodeList(MultiValueMap<String, String> params){		
		
		String menuCd = params.getFirst("menuCd");
		String menuUprCd = params.getFirst("menuUprCd");
		String mduTpCd = params.getFirst("mduTpCd");
		
		StringBuilder sql = new StringBuilder("SELECT MENU_CD, MENU_NM, MENU_UPR_CD, PAGE_CD, MENU_LV, ODR_NO, REG_DTTM, MOD_DTTM FROM MENU WHERE 1=1");
		
		if(Objects.nonNull(mduTpCd)) {
			sql.append(" AND MDU_TP_CD = '").append(mduTpCd).append("'");
		}		
		if(Objects.nonNull(menuCd)) {
			sql.append(" AND MENU_CD = '").append(menuCd).append("'");
		}		
		if(Objects.nonNull(menuUprCd)) {
			sql.append(" AND MENU_UPR_CD = '").append(menuUprCd).append("'");
		}
		sql.append(" ORDER BY ODR_NO");
		
		return client.sql(sql.toString()).fetch().all().map(Utils::converterCamelCase);
	}
	
	
	/**
	 * 공통코드 조회 API
	 * @param params
	 * @return
	 */
	public Flux<?> selectCmmCodeList(MultiValueMap<String, String> params){
		
		String grpCode = params.getFirst("grpCode");		
		String uprCode = params.getFirst("uprCode");
		
		StringBuilder sql = new StringBuilder("SELECT GRP_CODE, GRP_CODE_NM, UPR_CODE, CODE, CODE_NM FROM CODE WHERE 1=1");
		
		if(Objects.nonNull(grpCode)) {
			sql.append(" AND GRP_CODE = '").append(grpCode).append("'");
		}		
		if(Objects.nonNull(uprCode)) {
			sql.append(" AND URP_CODE = '").append(uprCode).append("'");
		}
		
		return client.sql(sql.toString()).fetch().all().map(Utils::converterCamelCase);
	}

}
