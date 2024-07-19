package com.racing.web.dto;

import java.util.List;
import java.util.Map;

public record CarResultResponse(String winner, List<Map<String, Integer>> status) {
}
