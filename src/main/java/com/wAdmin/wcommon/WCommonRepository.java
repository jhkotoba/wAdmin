package com.wAdmin.wcommon;

import java.util.Map;
import java.util.Objects;

import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import com.wAdmin.common.Utils;

import reactor.core.publisher.Flux;

@Repository
public class WCommonRepository {
	
	private final DatabaseClient client;
	
	public WCommonRepository(DatabaseClient databaseClient) {
		this.client = databaseClient;
	}
	
	public Flux<? extends Map<String, Object>> selectMenuCodeList(MultiValueMap<String, String> params){
		
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
		
		return client.execute(sql.toString()).fetch().all().map(Utils::converterCamelCase);
	}
	
	
	public Flux<? extends Map<String, Object>> selectPageCodeList(MultiValueMap<String, String> params){
		
		String pageCd = params.getFirst("pageCd");		
		String mduTpCd = params.getFirst("mduTpCd");
		
		StringBuilder sql = new StringBuilder("SELECT PAGE_CD, PAGE_NM, PAGE_PATH, PAGE_FILE, REG_DTTM, MOD_DTTM FROM PAGE WHERE 1=1");
		
		if(Objects.nonNull(mduTpCd)) {
			sql.append(" AND MDU_TP_CD = '").append(mduTpCd).append("'");
		}		
		if(Objects.nonNull(pageCd)) {
			sql.append(" AND PAGE_CD = '").append(pageCd).append("'");
		}
		
		return client.execute(sql.toString()).fetch().all().map(Utils::converterCamelCase);
	}
	
	

}
