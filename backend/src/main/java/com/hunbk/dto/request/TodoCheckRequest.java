package com.hunbk.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoCheckRequest {

    private Boolean isCheck;

    public TodoCheckRequest(Boolean isCheck) {
        this.isCheck = isCheck;
    }
}
