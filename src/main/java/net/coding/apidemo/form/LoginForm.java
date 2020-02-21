package net.coding.apidemo.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiiModel(description = "标签")
public class LoginForm {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "记住我密码2")
    private Boolean rememberMe;
}
