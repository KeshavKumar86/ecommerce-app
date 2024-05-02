package com.keshav.ecommerce.config;

import com.keshav.ecommerce.entity.Product;
import com.keshav.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] unsupportedActions = {HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT};

        //disable http methods for Product: post, put, delete
        config.getExposureConfiguration().forDomainType(Product.class)
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)))
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable((unsupportedActions))));

        //disable http methods for ProductCategory: post, put, delete
        config.getExposureConfiguration().forDomainType(ProductCategory.class)
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)))
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable((unsupportedActions))));
    }
}
