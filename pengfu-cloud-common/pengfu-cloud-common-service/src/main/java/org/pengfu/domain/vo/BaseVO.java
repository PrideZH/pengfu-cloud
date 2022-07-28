package org.pengfu.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/27 15:04
 */
@Data
public class BaseVO implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime updateTime;

}
