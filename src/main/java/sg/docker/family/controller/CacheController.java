package sg.docker.family.controller;

import org.springframework.web.bind.annotation.*;
import sg.docker.family.model.Family;
import sg.docker.family.service.CacheService;

@RestController
@RequestMapping("/v1/cache")
public class CacheController {
    private CacheService cacheFamilyService;

    public CacheController(CacheService cacheFamilyService) {
        this.cacheFamilyService = cacheFamilyService;
    }

    @PostMapping("/add")
    Family add(@RequestBody Family family) {
        return cacheFamilyService.add(family);
    }

    @DeleteMapping("/remove")
    void clear(@RequestBody Family family) {
        cacheFamilyService.remove(family);
    }

    @PostMapping("/clearall")
    void clearAll() {
        cacheFamilyService.clearAll();
    }
}
