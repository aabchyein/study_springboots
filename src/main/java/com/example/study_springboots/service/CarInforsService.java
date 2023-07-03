package com.example.study_springboots.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_springboots.dao.SharedDao;

@Service  // 스프링프레임워크가 관리할 수 있게 리스트업 시켜주기 위해서 캡을 씌워줘야 함. 그래야 더 빠르게 동작할 수 있고 스프링이 관리를 할 수 있다.
@Transactional // 데이터 정확성을 유지시켜줌.
public class CarInforsService {
    @Autowired  // spring DI에서 사용되는 annotation(annotation:주석처럼 쓰여서 특별한 의미, 기능을 수행하도록 하는 기술)
    SharedDao sharedDao; // DI

    // 검색(search의 조건 : YEAR, CAR_NAME)
    public Object selectSearch(String search, String words) {
        // Object getList(String sqlMapId, Object dataMap) 이 형식에 맞춰서 parameter를 써줘야 한다.
        String sqlMapId = "CarInfors.selectSearch";  // xml에서 namespace와 id가 합쳐져서 유니크한 id가 된다.
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);


        Object result = sharedDao.getList(sqlMapId, dataMap); //datampa을 getOne에 넘겨준다.
        return result;
    }

    public Object selectAll(String CAR_INFOR_ID) {
        // Object getList(String sqlMapId, Object dataMap) 이 형식에 맞춰서 parameter를 써줘야 한다.
        String sqlMapId = "CarInfors.selectAll";  // xml에서 namespace와 id가 합쳐져서 유니크한 id가 된다.
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getList(sqlMapId, dataMap); //datampa을 getOne에 넘겨준다.
        return result;
    }

    public Object selectDetail(String CAR_INFOR_ID) {
        // Object getOne(String sqlMapId, Object dataMap) 이 형식에 맞춰서 parameter를 써줘야 한다.
        String sqlMapId = "CarInfors.selectByUID";  // xml에서 namespace와 id가 합쳐져서 유니크한 id가 된다.
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap); //datampa을 getOne에 넘겨준다.
        return result;
    }


    // insert
    public Object insert(Map dataMap) {
        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    // update
    public Object update(Map dataMap) {
        String sqlMapId = "CarInfors.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    // delete
    public Object delete(String CAR_INFOR_ID) {  // key가 하나이기 때문에 굳이 body에 넣지 않고 사용.
        String sqlMapId = "CarInfors.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    // 2PC (2 pices commit) : 레코드는 하나만 받고 두 번 insert
    public Object insertDouble(Map dataMap) {
        String sqlMapId = "CarInfors.insert"; //Dao와 xml이 1:1로 mapping
        // success
        Object result = sharedDao.insert(sqlMapId, dataMap);  // 첫 insert는 성공
        // error
        result = sharedDao.insert(sqlMapId, dataMap);  // 두번째 insert는 에러를 뱉을 것.
        return result;
    }
}

//  서비스에서 sharedDao의 메서드를 호출하기 위해서는 형식을 그대로 맞춰서 써줘야 한다.(getOne호출)
//  스프링은 이미 모든 클래스를 인스턴스해서 리스트업 시켜놓았기 때문에 선언만 해주면 됨.