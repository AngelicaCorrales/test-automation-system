package com.endava.training.gui.dto.saucedemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckoutInfo {
    private String firstName;
    private String lastName;
    private String zipCode;
}
