package com.verizon.tsp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tsp.models.PlanDetails;
import com.verizon.tsp.services.PlanDetailsServiceImpl;

@RestController
@RequestMapping("/plan")
//@CrossOrigin
public class PlanDetailsController {

	@Autowired
	PlanDetailsServiceImpl pdservice;
	
	
	@GetMapping
	public ResponseEntity<List<PlanDetails>> getAllPlan(){
		return new ResponseEntity<>(pdservice.getAllPlan(),HttpStatus.OK);
	}
	
	@GetMapping("/{planId}")
	public ResponseEntity<PlanDetails> findByPlanId(@PathVariable("id") long planId) {
		
		ResponseEntity<PlanDetails> resp;
		
		PlanDetails pd = pdservice.findByPlanId(planId);
		
		if (pd == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(pd, HttpStatus.OK);
		
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<PlanDetails> createPlan(@RequestBody PlanDetails pd) {
		ResponseEntity<PlanDetails> resp = null;
		
		PlanDetails pd_return = pdservice.createPlan(pd);
		
		if(pd_return != null) {
			resp = new ResponseEntity<>(pd_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}

	
	@PutMapping
	public ResponseEntity<PlanDetails> updatePlan(@RequestBody PlanDetails pd) {
		ResponseEntity<PlanDetails> resp = null;
		
		PlanDetails pd_return = pdservice.updatePlan(pd);
		
		if(pd_return != null) {
			resp = new ResponseEntity<>(pd_return, HttpStatus.OK);
		} else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}

	
	@DeleteMapping("{planId}")
	public ResponseEntity<Void> deletePlan(@PathVariable("planId") int planId) {
		ResponseEntity<Void> resp = null;

		if (pdservice.deletePlan(planId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}


}
