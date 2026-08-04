package com.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;
}
