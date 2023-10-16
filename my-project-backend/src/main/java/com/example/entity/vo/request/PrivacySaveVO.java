package com.example.entity.vo.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

/*使用单次单个的方式，不将5个隐私设置同时提交*/
@Data
public class PrivacySaveVO {
    @Pattern(regexp = "(phone|email|qq|wx|gender)")
    String type;
    boolean status;
}
