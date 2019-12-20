package net.coding.apidemo.bean;

import java.util.List;

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
@ApiModel(description = "宠物实体信息")
public class Pet {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("分类")
    private Category category;

    @ApiModelProperty(value = "状态", allowableValues = "available,pending,sold")
    private String status;

    @ApiModelProperty("照片地址列表")
    private List<String> photoUrls;

    @ApiModelProperty(value = "名称", example = "doggie")
    private String name;

    @ApiModelProperty("是否健康")
    private Boolean isHealthy;

    @ApiModelProperty("标签")
    private List<Tag> tags;
}
