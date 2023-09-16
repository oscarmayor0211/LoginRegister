package com.valpoSystems.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import javax.persistence.Column;

@Getter
@Setter
@ToString
@javax.persistence.MappedSuperclass
public class AuditFields {
	@CreatedDate
	@Column(name = "created")
	private LocalDateTime created;

	@LastModifiedDate
	@Column(name = "modified")
	private LocalDateTime modified;

	public AuditFields() {
	}
}
