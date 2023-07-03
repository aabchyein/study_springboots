package com.example.study_springboots.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SharedDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 여러 개의 레코드를 가져올 때 사용하는 메서드
    public Object getList(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.selectList(sqlMapId, dataMap);
        return result;
    }

    // 레코드 하나를 가져올 때 사용하는 메서드
    public Object getOne(String sqlMapId, Object dataMap) {  // 이 메서드의 return값이 object
        Object result = sqlSessionTemplate.selectOne(sqlMapId, dataMap);
        return result;
    }

    // 레코드 수정할 때
    public Object update(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.update(sqlMapId, dataMap);
        return result;
    }

    // 레코드 만들 때
    public Object insert(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.insert(sqlMapId, dataMap);
        return result;
    }

    // 레코드 삭제할 때
    public Object delete(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.delete(sqlMapId, dataMap);
        return result;
    }
}
