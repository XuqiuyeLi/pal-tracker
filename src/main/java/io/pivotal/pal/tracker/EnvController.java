package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String memory;
    private final String cfIndex;
    private final String cfAddress;

    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memory,
                         @Value("${cf.instance.index:NOT SET}") String cfIndex,
                         @Value("${cf.instance.addr:NOT SET}") String cfAddress) {
        this.port = port;
        this.memory = memory;
        this.cfIndex = cfIndex;
        this.cfAddress = cfAddress;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> map = new HashMap<>();
        map.put("PORT", port);
        map.put("MEMORY_LIMIT", memory);
        map.put("CF_INSTANCE_INDEX", cfIndex);
        map.put("CF_INSTANCE_ADDR", cfAddress);

        return map;
    }
}
