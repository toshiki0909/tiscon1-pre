package tiscon1.config;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

/**
 * @author kawasima
 */

@EnableHazelcastHttpSession
@Configuration
public class HazelcastHttpSessionConfig {
    @Bean
    public HazelcastInstance embeddedHazelcast() {
        Config hazelcastConfig = new Config();
        return Hazelcast.newHazelcastInstance(hazelcastConfig);
    }
}
