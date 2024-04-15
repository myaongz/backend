package com.mya.ong.backend.myaong.health.controller;

import com.mya.ong.backend.myaong.health.service.GetServerStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mya.ong.backend.myaong.health.service.GetServerStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ResponseBody
@RestController

public class StatusController {
    @GetMapping("/status")
    public Map<String , String> hello () {
        String[] storageInfo = GetServerStatus.getStorage();
        HashMap<String, String> map = new HashMap<>();
        map.put("health","checked");
        map.put("storage", Arrays.toString(storageInfo));
        return map;
    }
}
