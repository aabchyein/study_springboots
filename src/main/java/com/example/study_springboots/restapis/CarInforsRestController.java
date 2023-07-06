package com.example.study_springboots.restapis;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboots.service.CarInforsService;

@RestController
public class CarInforsRestController {
    @Autowired   // 스프링이 이미 클래스를 인스턴스했기 때문에 그냥 선언해서 갖다 쓴다는 의미의 캡
    CarInforsService carInforsService;

    // foreach
    @GetMapping("/selectInUID")
    public ResponseEntity selectInUID(@RequestBody Map paramMap) {  // reauestbody: 사용자가 요청을 보낼 때 body에 데이터를 넣어서 보내야 한다는 것.
        Object result = null;
        try {
            result = carInforsService.selectInUID(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);

        }
        return ResponseEntity.ok().body(result);
    }

    // /selectSearch/YEAR/2020
    // /selectSearch/CAR_NAME/소
    @GetMapping("/selectSearch/{search}/{words}")  // uri 방식 : get
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words) {  // uri로 받는 변수가 메서드의 파라미터로 온다는 것을 표시해줘야 한다. @PathVariable 표시를 통해서 mapping
        Object result = carInforsService.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/selectAll/{CAR_INFOR_ID}")  // uri 방식 : get
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {  // uri로 받는 변수가 메서드의 파라미터로 온다는 것을 표시해줘야 한다. @PathVariable 표시를 통해서 mapping
        Object result = carInforsService.selectAll((CAR_INFOR_ID));
        return ResponseEntity.ok().body(result);
    }


    // /selectDetail/CI002
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")  // uri 방식 : get
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {  // uri로 받는 변수가 메서드의 파라미터로 온다는 것을 표시해줘야 한다. @PathVariable 표시를 통해서 mapping
        Object result = carInforsService.selectDetail((CAR_INFOR_ID));
        return ResponseEntity.ok().body(result);
    }

    // create
    @PostMapping("/insert")  // uri 방식 : post
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carInforsService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // update
    @PutMapping("/update")  //uri 방식 : put
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carInforsService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // delete
    @DeleteMapping("/delete/{CAR_INFOR_ID}")  // uri 방식 : DELETE
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) {  // uri로 받는 변수가 메서드의 파라미터로 온다는 것을 표시해줘야 한다. @PathVariable 표시를 통해서 mapping
        Object result = carInforsService.delete((CAR_INFOR_ID));
        return ResponseEntity.ok().body(result);
    }

    // 2PC create
    @PostMapping("/insertDouble")  // uri 방식 : post (header의 숨어있는 부분에 parameter를 끼워 보냄)
    public ResponseEntity insertDouble(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = carInforsService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }
}
