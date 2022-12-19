package com.bm.relation.core.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * swagger 配置实体类
 * @author : zyg
 * @since  : 2022/07/19
 **/

@Data
@Component
@ToString
public class SwaggerConfigProperties {

    private String title;
    private String description;
    private String termsOfServiceUrl;
    private String apiPackage;
    private String version;

    public SwaggerConfigProperties(
            @Value("${swagger.apiPackage:null}") String apiPackage,
            @Value("${swagger.title:demo}") String title,
            @Value("${swagger.description:demo}") String description,
            @Value("${swagger.termsOfServiceUrl:demo}") String termsOfServiceUrl,
            @Value("${swagger.version:demo}") String version
    ) {
        this.apiPackage = apiPackage;
        this.title = title;
        this.description = description;
        this.termsOfServiceUrl = termsOfServiceUrl;
        this.version = version;
    }

}
