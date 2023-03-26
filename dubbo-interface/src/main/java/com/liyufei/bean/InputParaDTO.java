package com.liyufei.bean;

import java.io.Serializable;

public class InputParaDTO implements Serializable {
    private Integer type;

    public InputParaDTO() {
    }

    public InputParaDTO(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
