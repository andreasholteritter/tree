package no.ritter.tree;

import no.ritter.tree.repository.TreeRepository;
import no.ritter.tree.service.TreeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("main")
    public TreeRepository treeService() {
        return new TreeService();
    }
}
