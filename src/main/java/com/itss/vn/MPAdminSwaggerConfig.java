package com.itss.vn;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.itss.vn.authorization.model.AuthorizationRequest;
import com.itss.vn.authorization.service.AuthorizationService;
import com.itss.vn.shops.entity.Account;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MPAdminSwaggerConfig {

    @Value("${swagger.host.url}")
    private String swaggerHostUrl;
    
    @Value("${oauth2.admin.id}")
	private String clientId;
	
	@Autowired
	private AuthorizationService authorizationService;

    @Bean
    public Docket petApi() {
    	
    	AuthorizationRequest authorizationRequest = new AuthorizationRequest();
		authorizationRequest.setUserName("thang.vm");
		authorizationRequest.setPassWord("1234");
		
		Account account = authorizationService.authorizeAccount(authorizationRequest);
		OAuth2AccessToken token = authorizationService.generateAccessToken(account, clientId);
		
		/*Parameter parameter = new Parameter("Authorization", null, "Bear " + token.getValue(), true, true, null, null, null, "String", "String");
		List<Parameter> parameters = new ArrayList<>();
		parameters.add(parameter);*/
		/*String token = "";
		try {
			token = authorizationService.authorize(authorizationRequest).getValue();
		} catch (Exception ex) {
			token = "";
		}*/

		/*Parameter parameter = new ParameterBuilder().name("authorization").defaultValue("Bear " + token.getValue())
								.description("header").modelRef(null).parameterType("String").required(false).build();
		List<Parameter> parameters = new ArrayList<>();
		parameters.add(parameter);*/
		
        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerHostUrl)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo())
                .globalOperationParameters(parameterList(token.getValue()));
    }

    private List<Parameter> parameterList(String token) {
    	List<Parameter> list = new ArrayList<>();
    	String default_token = "";
    	if(token != null && !StringUtils.isEmpty(token)) {
    		default_token = "Bear " + token;
    	}
    	Parameter param = new ParameterBuilder()
    			.name("Authorization")
    			.defaultValue(default_token)
    			.description("Access Token")
    			.modelRef(new ModelRef("string"))
    			.parameterType("header")
    			.required(false)
    			.build();
    	list.add(param);
    	return list;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Shop - Services Admin API")
                .description("Shop - Services Admin API Description")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

}
