package com.example.study_springboots.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.study_springboots.service.HelloWorldService;

@Controller
public class HelloWorldController {
    @Autowired        // AutoWired는 new라고 생각하면 된다. 스프링프레임워크의 가장 중요한 기능 중의 하나인 DI 기능. 스프링부트가 뜨면서 캡 씌운 부분을 메모리에 전부 올려놓는다. 초기화 뜰 때는 시간이 걸리지만 사용할 때 속도는 증가한다.(메모리에 올라가 있는 상태이므로)
    HelloWorldService helloWorldService;

    @GetMapping("/helloWorld")
    public int helloWorld(){
        return 0;
    }

    // /helloWorldGetRequest?Name=yojulab     원래 우리가 servlet에서 사용하던 url 형식 (변수=값)
    // /helloWorldGetRequest/yojulab/U-01     url에서 해당 위치에 있으면 name으로 그냥 여기기 때문에 yojulab이 name이 된다.
    @GetMapping("/helloWorldGetRequest/{name}/{Id}")  // 위치값 지정
    public int helloWorldGetRequest(@PathVariable String name, @PathVariable String Id){   //@PathVariable 이것을 붙이지 않으면 그냥 parameter로 넘어온 변수로 생각함. 이것을 넣어줘야 {} 안의 위치에 있는 값이라는 것을 스프링에 알려주는 것이다.
        return 0;
    }

    //?serviceKey=n1D34DQYo4jF080CnTyQNe%2FDQKRrmxq%2FVWIpwgfqdvG%2FXUWF1i2u64KLG5MjwwtQTatblMXR0S8v8B2pTqev0g%3D%3D&currentPage=1&perPage=10&SN=1
    // &currentPage=1
    // &perPage=10
    // &SN=1
    @GetMapping("/helloWorldResponse/{currentPage}/{perPage}/{SN}")  // 위치값 지정
    public ResponseEntity<Object> helloWorldResponse(@PathVariable String currentPage, @PathVariable String perPage
                    , @PathVariable String SN){   //@PathVariable 이것을 붙이지 않으면 그냥 parameter로 넘어온 변수로 생각함. 이것을 넣어줘야 {} 안의 위치에 있는 값이라는 것을 스프링에 알려주는 것이다.
        
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);

        return ResponseEntity.ok().body(resultMap); ///스프링에서 json으로 알아서 convert해줌
    }

    // /helloWorldResponseList/1/10/1
    @GetMapping("/helloWorldResponseList/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponseList(@PathVariable String currentPage, @PathVariable String perPage
                    , @PathVariable String SN){   //@PathVariable 이것을 붙이지 않으면 그냥 parameter로 넘어온 변수로 생각함. 이것을 넣어줘야 {} 안의 위치에 있는 값이라는 것을 스프링에 알려주는 것이다.
    
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3
        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("spm_row", 571);
        resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return ResponseEntity.ok().body(arrayList);
    }


    // /helloWorldResponseWithService/1/10/1
    @GetMapping("/helloWorldResponseWithService/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponseWithService(@PathVariable String currentPage, @PathVariable String perPage
                    , @PathVariable String SN){   //@PathVariable 이것을 붙이지 않으면 그냥 parameter로 넘어온 변수로 생각함. 이것을 넣어줘야 {} 안의 위치에 있는 값이라는 것을 스프링에 알려주는 것이다.
        ArrayList arrayList = new ArrayList<>();
        arrayList = helloWorldService.fakeSelect(currentPage, perPage);
        
        return ResponseEntity.ok().body(arrayList);
    }
}


// helloWorldGetRequest?Name=yojulab 원래 우리가 url로 보내던 형식 (변수=값)
// /helloWorldGetRequest/yojulab  url에서 해당 위치에 있으면 name으로 그냥 여기기 때문에 yojulab이 name이 된다.
// 해킹이 되었을 때 밑에 방식은 값만 봐서는 어던건지 알 수가 없기 때문에 유리함.