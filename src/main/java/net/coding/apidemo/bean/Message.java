package net.coding.apidemo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "JSON 正常返回")
public class Message {
    @ApiModelProperty(value = "消息码")
    private Integer code;

    @ApiModelProperty(value = "类型", allowableValues = "SUCCESS,ERROR")
    private String type;

    @ApiModelProperty(value = "异常信息")
    private String message;
}
