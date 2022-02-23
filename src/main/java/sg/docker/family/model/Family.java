package sg.docker.family.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RedisHash(CacheFamily.FAMILY_CACHE)
public class Family implements Serializable {
    @Id
    private Long id;
    @Indexed
    private String lastName;
    private List<String> familyMembers;

    public Family(String lastName, List<String> familyMembers) {
        this.lastName = lastName;
        this.familyMembers = familyMembers;
    }

}
