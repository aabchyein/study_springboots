package com.example.study_springboots.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboots.service.CarCompanyService;
import com.example.study_springboots.service.CarInforsService;

@RestController
public class CarCompanyController {
    @Autowired   // 스프링이 이미 클래스를 인스턴스했기 때문에 그냥 선언해서 갖다 쓴다는 의미의 캡
    CarCompanyService carCompanyService;

    // /carCompanySelectSearch/COMPANY/현
    // /carCompanySelectSearch/COMPANY_ID/C
    @GetMapping("/carCompanySelectSearch/{search}/{words}")  // uri 방식 : get
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words) {  // uri로 받는 변수가 메서드의 파라미터로 온다는 것을 표시해줘야 한다. @PathVariable 표시를 통해서 mapping
        Object result = carCompanyService.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
    }

    // /carCompanyInsert
    // create
    @PostMapping("/carCompanyInsert")  // uri 방식 : post
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carCompanyService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // /carCompanyUpdate
    // update
    @PutMapping("/carCompanyUpdate")  //uri 방식 : put
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carCompanyService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // /carCompanyDelete/C006
    // delete
    @DeleteMapping("/carCompanyDelete/{COMPANY_ID}")  // uri 방식 : DELETE
    public ResponseEntity delete(@PathVariable String COMPANY_ID) {  // uri로 받는 변수가 메서드의 파라미터로 온다는 것을 표시해줘야 한다. @PathVariable 표시를 통해서 mapping
        Object result = carCompanyService.delete((COMPANY_ID));
        return ResponseEntity.ok().body(result);
    }
}
