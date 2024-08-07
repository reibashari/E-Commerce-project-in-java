package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ecom.entity.PaymentEntity;
import com.ecom.exception.RecordNotFoundException;
import com.ecom.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	public PaymentRepository repository;

	public ResponseEntity<?> Add(PaymentEntity entity) {
		PaymentEntity cEntity = null;
		try {
			
				cEntity = repository.save(entity);
			
		} catch (Exception e) {
             e.printStackTrace();
			throw new RecordNotFoundException("Something went wrong."+e);
		}
		return new ResponseEntity<>(cEntity, HttpStatus.OK);
	}
	
	

	public List<PaymentEntity> list() {
		List<PaymentEntity> list = null;

		list = repository.findAll();

		return list;
	}

	public PaymentEntity Update(PaymentEntity dto) {

		PaymentEntity entity = repository.saveAndFlush(dto);
		return entity;
	}

	public List<PaymentEntity> Delete(long id) {
		List<PaymentEntity> list = null;
		if (findById(id) != null) {
			repository.deleteById(id);
			list = repository.findAll();
		} else {
			throw new RecordNotFoundException("Not a valid record id");
		}
		return list;
	}

	public PaymentEntity findById(long id) {
		try {
			if (id > 0) {
				PaymentEntity entity = repository.findById(id);
				if (entity == null) {
					throw new RecordNotFoundException("Record not found");

				} else {
					return entity;
				}
			} else {
				throw new RecordNotFoundException("Not a valid record id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RecordNotFoundException("Record not found");
		}
	}
	
	public List<PaymentEntity> findByUserId(long id) {
		try {
			if (id > 0) {
				List<PaymentEntity> entity = repository.findByUserId(id);
				if (entity == null) {
					throw new RecordNotFoundException("Record not found");

				} else {
					return entity;
				}
			} else {
				throw new RecordNotFoundException("Not a valid record id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RecordNotFoundException("Record not found");
		}
	}

}
