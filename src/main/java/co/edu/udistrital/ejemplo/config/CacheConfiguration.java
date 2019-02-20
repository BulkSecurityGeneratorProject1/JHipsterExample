package co.edu.udistrital.ejemplo.config;

import java.time.Duration;

import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import io.github.jhipster.config.jcache.BeanClassLoaderAwareJCacheRegionFactory;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        BeanClassLoaderAwareJCacheRegionFactory.setBeanClassLoader(this.getClass().getClassLoader());
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(co.edu.udistrital.ejemplo.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.Client.class.getName(), jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.Client.class.getName() + ".addresses", jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.Client.class.getName() + ".telephones", jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.Client.class.getName() + ".invoices", jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.Address.class.getName(), jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.Telephone.class.getName(), jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.Invoice.class.getName(), jcacheConfiguration);
            cm.createCache(co.edu.udistrital.ejemplo.domain.Discount.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
