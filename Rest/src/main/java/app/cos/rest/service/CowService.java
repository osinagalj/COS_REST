package app.cos.rest.service;

import java.util.List;

import app.cos.rest.model.Cow;


public interface CowService {
	Cow register(Cow cow);
	Cow findById(int id);
	List<Cow> getAllCows();

}