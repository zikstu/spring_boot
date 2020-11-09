package com.medsci.hello.spring.boot.dto;

import com.medsci.hello.spring.boot.annotation.constraints.RSADtoCheckAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @author: 学长
 * @date: 2020/10/15 18:21
 */
@Getter
@Setter
@ApiModel("RSA")
public class RSADto {
    @NotBlank(message = "key是必须的！")
    @ApiModelProperty(value = "RSA key", required = true)
    private String key;

    @NotBlank(message = "需要加密或者解密的数据是必须的！")
    @ApiModelProperty(value = "需加密或者解密的数据", required = true)
    private String data;

    @NotBlank(message = "key类型是必须的！")
    @RSADtoCheckAction(name = "keyType")
    @ApiModelProperty(value = "RSA key类型（private or public）", required = true)
    private String keyType;

    @NotBlank(message = "加密或者解密操作是必须的！")
    @RSADtoCheckAction(name = "action")
    @ApiModelProperty(value = "加密或者解密操作（encrypt or decrypt）", required = true)
    private String action;

    public RSADto(String keyType, String action) {
        this.keyType = keyType;
        this.action = action;
    }
}
