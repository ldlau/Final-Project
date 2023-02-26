package com.promineotech.book;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;
@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})

public class LesliesLibrary {

  public static void main(String[] args) {
    SpringApplication.run(LesliesLibrary.class, args);
  }

}
