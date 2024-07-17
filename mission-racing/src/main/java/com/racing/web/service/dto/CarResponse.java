package com.racing.web.service.dto;

import java.util.List;
import java.util.Map;

public record CarResponse(List<Map<String, Integer>> carStates, List<String> winners) {

}
