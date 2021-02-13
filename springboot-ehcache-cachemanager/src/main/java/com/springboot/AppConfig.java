package com.springboot;

import java.util.Collection;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class AppConfig extends CachingConfigurerSupport {

  @Bean
  public net.sf.ehcache.CacheManager ehCacheManager() {
    CacheConfiguration tenSecondCache = new CacheConfiguration();
    tenSecondCache.setName(AppCache.TEN_SECOND_CACHE);
    tenSecondCache.setMemoryStoreEvictionPolicy("LRU");
    tenSecondCache.setMaxEntriesLocalHeap(1000);
    tenSecondCache.setTimeToLiveSeconds(10);

    CacheConfiguration twentySecondCache = new CacheConfiguration();
    twentySecondCache.setName(AppCache.TWENTY_SECOND_CACHE);
    twentySecondCache.setMemoryStoreEvictionPolicy("LRU");
    twentySecondCache.setMaxEntriesLocalHeap(1000);
    twentySecondCache.setTimeToLiveSeconds(20);

    net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
    config.addCache(tenSecondCache);
    config.addCache(twentySecondCache);
    return net.sf.ehcache.CacheManager.newInstance(config);
  }

  @Bean
  @Override
  public CacheManager cacheManager() {
    return new EhCacheCacheManager(ehCacheManager());
  }

}
