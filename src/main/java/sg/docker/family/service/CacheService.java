package sg.docker.family.service;

import sg.docker.family.model.Family;


public interface CacheService {
    Family add(Family family);

    void remove(Family family);

    void clearAll();
}
