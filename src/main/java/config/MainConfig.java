package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с основной конфигурацией проекта
 */
@Config.Sources({"classpath:config.properties"})
public interface MainConfig extends Config{

    /**
     * Метод для возвращения параметра baseUrl из config.properties
     *
     * @return базовый URL
     */
    String url();

    /**
     * Метод для возвращения параметра accessKey из config.properties
     *
     * @return ключ доступа
     */
    String accessKey();
}
