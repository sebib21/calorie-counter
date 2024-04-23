package com.sebaba.caloriecounter.activitylevel;

public record RetrieveActivityLevelDTO(
		Integer activityLevelId,
		String descripion,
		Double multiplier
){}