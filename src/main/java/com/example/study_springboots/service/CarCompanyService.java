package com.example.study_springboots.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study_springboots.dao.SharedDao;

@Service
public class CarCompanyService {
    @Autowired
    SharedDao sharedDao;

    // 검색(search의 조건: COMPANY, COMPANY_ID)
    public Object selectSearch(String search, String words) {
        String sqlMapId = "CarCompany.selectSearch";  // xml에서 namespace와 id가 합쳐져서 유니크한 id가 된다.
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // insert
    public Object insert(Map dataMap) {
        String sqlMapId = "CarCompany.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    // update
    public Object update(Map datMap) {
        String sqlMapId = "CarCompany.update";
        Object result = sharedDao.update(sqlMapId, datMap);
        return result;
    }

    // delete
    public Object delete(String COMPANY_ID) {
        String sqlMapId = "CarCompany.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY_ID", COMPANY_ID);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }
}
