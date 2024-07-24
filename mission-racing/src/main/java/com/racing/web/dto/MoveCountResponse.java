package com.racing.web.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public class MoveCountResponse {

    private final int moveCount;

    public MoveCountResponse(int moveCount) {
        this.moveCount = moveCount;
    }

    public static MoveCountResponse from(int moveCount){
        return new MoveCountResponse(moveCount);
    }

    @JsonValue
    public int getMoveCount(){
        return moveCount;
    }
}
