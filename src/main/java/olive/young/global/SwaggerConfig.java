package olive.young.global;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "OliveYoung API 제품 Spring Server 명세서",
                description = "제품 추천 서비스 API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {

}
