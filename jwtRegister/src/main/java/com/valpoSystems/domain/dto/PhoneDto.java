package com.valpoSystems.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.valpoSystems.domain.models.PhoneModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhoneDto {
	@JsonProperty("number")
	private String number;

	@JsonProperty("citycode")
	private String cityCode;

	@JsonProperty("contrycode")
	private String countryCode;

	public PhoneDto() {
	}

	public PhoneDto(final PhoneModel phoneEntity) {
		this.number = phoneEntity.getNumber();
		this.cityCode = phoneEntity.getCityCode();
		this.countryCode = phoneEntity.getCountryCode();
	}
}
