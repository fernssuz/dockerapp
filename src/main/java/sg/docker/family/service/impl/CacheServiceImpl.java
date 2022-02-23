package sg.docker.family.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import sg.docker.family.model.Family;
import sg.docker.family.repository.FamilyRepository;
import sg.docker.family.service.CacheService;

@Service
@Slf4j
public class CacheServiceImpl implements CacheService {

    private static String keyPrefix = "sg";
    private static String KEY_DELIMITER = "-";
    private CacheManager cacheManager;

    private FamilyRepository familyRepository;

    public CacheServiceImpl(FamilyRepository familyRepository, CacheManager cacheManager) {
        this.familyRepository = familyRepository;
        this.cacheManager = cacheManager;
    }

    @Override
    public Family add(Family family) {
        return familyRepository.save(family);
    }

    @Override
    public void remove(Family family) {
        familyRepository.findByLastName(family.getLastName())
            .ifPresentOrElse(
                f -> familyRepository.delete(f),
                () -> {
                    log.warn("Therer is no last name found");
                }
            );

    }

    @Override
    public void clearAll() {
        familyRepository.deleteAll();
    }
}
