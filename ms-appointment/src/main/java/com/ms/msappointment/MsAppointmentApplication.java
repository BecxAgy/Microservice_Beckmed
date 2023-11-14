package com.ms.msappointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAppointmentApplication.class, args);
	}

}
