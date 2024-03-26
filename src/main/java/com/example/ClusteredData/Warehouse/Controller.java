package com.example.ClusteredData.Warehouse;

import org.hibernate.internal.util.compare.CalendarComparator;
import org.hibernate.type.descriptor.java.DateJavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClusteredData.Warehouse.entites.Order;
import com.example.ClusteredData.Warehouse.entites.ResponsePojo;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import ch.qos.logback.classic.pattern.DateConverter;
import ch.qos.logback.core.joran.action.TimestampAction;
import ch.qos.logback.core.util.TimeUtil;
//import java.util.Date;
//import java.util.List;
import java.util.*;

import java.util.HashMap;
import com.smattme.requestvalidator.RequestValidator;

@RestController
public class Controller {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private Repository repository;

	@PostMapping("/order")
	private ResponseEntity<ResponsePojo> addOrder(@RequestBody Order order) {

		HashMap requiredFields = new HashMap();
		requiredFields.put("fromCurrency", "required");
		requiredFields.put("toCurrency", "required");
		requiredFields.put("dealAmount", "required");

		List<String> erros = RequestValidator.validate(order, requiredFields);
		if (erros.isEmpty()) {

			order.setTimestamp(generateTimestamp());

			try {

				Order newOrder = repository.save(order);
				
				logger.info("new order has been created" + newOrder.toString());

				return new ResponseEntity(new ResponsePojo("Success", "Order Created Successfully", newOrder),
						HttpStatus.OK);

			} catch (Exception e) {
				logger.info("database exception" + e.getMessage());
				return new ResponseEntity(new ResponsePojo("Error", e.getMessage(), null),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} else {
			logger.info("bad request error");

			return new ResponseEntity(new ResponsePojo("BAD REQUEST", "Missing reuired field", null),
					HttpStatus.BAD_REQUEST);

		}
	}

	private String generateTimestamp() {

		Date currentDate = new Date();
		return currentDate.toString();

	}

}
